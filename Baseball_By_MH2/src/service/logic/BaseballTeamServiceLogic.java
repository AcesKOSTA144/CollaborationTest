package service.logic;

import java.util.ArrayList;
import java.util.List;

import domain.BaseballTeam;
import domain.Player;
import service.BaseballTeamService;
import store.BaseballTeamStore;
import store.PlayerStore;
import store.logic.BaseballTeamStoreLogic;
import store.logic.PlayerStoreLogic;

public class BaseballTeamServiceLogic implements BaseballTeamService {
	
	private BaseballTeamStore teamStore;
	private PlayerStore playerStore;
	
	public BaseballTeamServiceLogic() {
		teamStore = new BaseballTeamStoreLogic();
		playerStore = new PlayerStoreLogic();
	}

	@Override
	public BaseballTeam findTeam(String teamId) {
		return teamStore.retrieve(teamId);
	}

	@Override
	public List<BaseballTeam> findAllTeams() {
		return teamStore.retrieveAll();
	}

	@Override
	public List<BaseballTeam> findAllTeamsWithPlayers() {
		
		List<BaseballTeam> list = teamStore.retrieveAll();
		
		for (BaseballTeam team : list) {
			team.setPlayers(playerStore.retrieveByTeam(team.getTeamId()));
		}
		
		return list;
	}

	@Override
	public List<BaseballTeam> findTradeTargetPalyers(String teamId) {
		List<BaseballTeam> list = teamStore.retrieveAll();
		List<BaseballTeam> teams = new ArrayList<>();
		
		for (BaseballTeam team : list) {
			team.setPlayers(playerStore.retrieveByTeam(team.getTeamId()));
			
			if (!team.getTeamId().equals(teamId)) {
				teams.add(team);
			}
		}
		
		return teams;
	}

	@Override
	public Player findPlayer(String playerId) {
		return playerStore.retrieve(playerId);
	}

	@Override
	public void tradePlayer(String sourcePlayerId, String targetPlayerId) {
		Player sourcePlayer = playerStore.retrieve(sourcePlayerId);
		Player targetPlayer = playerStore.retrieve(targetPlayerId);
		
		String tmp = targetPlayer.getTeamId();
		targetPlayer.setTeamId(sourcePlayer.getTeamId());
		sourcePlayer.setTeamId(tmp);
		
		playerStore.update(sourcePlayer);
		playerStore.update(targetPlayer);
		
		
		
	}

}
