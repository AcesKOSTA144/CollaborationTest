package store;

import java.util.List;

import domain.BaseballTeam;


/**
 * BaseballTeamStore
 * 
 * @author Kwon-Ki Jin(kwonkijin@nextree.co.kr)
 */
public interface BaseballTeamStore {

	public BaseballTeam retrieve(String teamId);
	public List<BaseballTeam> retrieveAll();
}
