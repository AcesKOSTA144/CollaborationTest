package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.BaseballTeam;
import store.BaseballTeamStore;
import store.utils.ConnectionFactory;
import store.utils.JdbcUtils;

public class BaseballTeamStoreLogic implements BaseballTeamStore {
	
	private ConnectionFactory factory;
	
	public BaseballTeamStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public BaseballTeam retrieve(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BaseballTeam team = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("SELECT id, name, region, manager, stadium, logo FROM team_tb WHERE id = ?");
			pstmt.setString(1, teamId);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				team = new BaseballTeam();
				team.setTeamId(teamId);
				team.setName(rs.getString("name"));
				team.setRegion(rs.getString("region"));
				team.setManager(rs.getString("manager"));
				team.setStadium(rs.getString("stadium"));
				team.setLogo(rs.getString("logo"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt, rs);
		}
		
		return team;
	}

	@Override
	public List<BaseballTeam> retrieveAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BaseballTeam> list = new ArrayList<>();
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("SELECT id, name, region, manager, stadium, logo FROM team_tb");
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BaseballTeam team = new BaseballTeam();
				team.setTeamId(rs.getString("id"));
				team.setName(rs.getString("name"));
				team.setRegion(rs.getString("region"));
				team.setManager(rs.getString("manager"));
				team.setStadium(rs.getString("stadium"));
				team.setLogo(rs.getString("logo"));
				
				list.add(team);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	

}
