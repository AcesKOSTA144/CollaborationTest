package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Player;
import store.PlayerStore;
import store.utils.ConnectionFactory;
import store.utils.JdbcUtils;

public class PlayerStoreLogic implements PlayerStore {
	
	private ConnectionFactory factory;
	
	public PlayerStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public void update(Player player) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("UPDATE player_tb SET teamid=?, name=?, backnumber=?, position=? WHERE id=?");

			pstmt.setString(1, player.getTeamId());
			pstmt.setString(2, player.getName());
			pstmt.setInt(3, player.getBackNumber());
			pstmt.setString(4, player.getPosition());
			pstmt.setString(5, player.getPlayerId());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt);
		}
		
		
	}

	@Override
	public Player retrieve(String playerId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Player player = null;
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("SELECT id, teamid, name, backnumber, position, hitting, throw FROM player_tb WHERE id=? ");
			pstmt.setString(1, playerId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				player = new Player();
				player.setPlayerId(rs.getString("id"));
				player.setTeamId(rs.getString("teamid"));
				player.setName(rs.getString("name"));
				player.setBackNumber(rs.getInt("backnumber"));
				player.setPosition(rs.getString("position"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt, rs);
		}
		
		return player;
	}

	@Override
	public List<Player> retrieveByTeam(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Player> list = new ArrayList<>();
		
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("SELECT id, teamid, name, backnumber, position, hitting, throw FROM player_tb WHERE teamId=? ");
			pstmt.setString(1, teamId);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Player player = new Player();
				player.setPlayerId(rs.getString("id"));
				player.setTeamId(rs.getString("teamid"));
				player.setName(rs.getString("name"));
				player.setBackNumber(rs.getInt("backnumber"));
				player.setPosition(rs.getString("position"));
				
				list.add(player);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, pstmt, rs);
		}
		
		return list;
	}

	
}
