package service;

import java.util.List;

import domain.BaseballTeam;
import domain.Player;

/**
 * BaseballTeamService
 * 
 * @author Kwon-Ki Jin(kwonkijin@nextree.co.kr)
 */
public interface BaseballTeamService {

	//team
	public BaseballTeam findTeam(String teamId);
	public List<BaseballTeam> findAllTeams();
	public List<BaseballTeam> findAllTeamsWithPlayers();
	public List<BaseballTeam> findTradeTargetPalyers(String teamId);
	
	//player
	public Player findPlayer(String playerId);
	public void tradePlayer(String sourcePlayerId, String targetPlayerId);
	
}
