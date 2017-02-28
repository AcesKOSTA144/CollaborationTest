package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BaseballTeam;
import domain.Player;
import service.BaseballTeamService;
import service.logic.BaseballTeamServiceLogic;

@WebServlet("/tradeTargetList.do")
public class TradeTargetListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BaseballTeamService service;
	
	public TradeTargetListController() {
		service = new BaseballTeamServiceLogic();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sourcePlayerId = request.getParameter("playerId");
		Player sourcePlayer = service.findPlayer(sourcePlayerId);
		List<BaseballTeam> targetTeams = service.findTradeTargetPalyers(sourcePlayer.getTeamId());
		List<Player> targetPlayers = new ArrayList<>();
		HashMap<String, String> teamNames = new HashMap<>();
		
		
		
		for (BaseballTeam team : targetTeams) {
			targetPlayers.addAll(team.getPlayers());
			teamNames.put(team.getTeamId(), team.getName());
		}
		
		request.setAttribute("targetPlayers", targetPlayers);
		request.setAttribute("sourcePlayer", sourcePlayer);
		request.setAttribute("teamNames", teamNames);
		
		request.getRequestDispatcher("tradeTargetList.jsp").forward(request, response);
	}


}
