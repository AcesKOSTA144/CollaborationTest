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

@WebServlet("/playerList.do")
public class PlayerListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BaseballTeamService service;
	
	public PlayerListController() {
		service = new BaseballTeamServiceLogic();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BaseballTeamService service = new BaseballTeamServiceLogic();
		List<Player> players = new ArrayList<>();
		List<BaseballTeam> teams = service.findAllTeamsWithPlayers();
		HashMap<String, String> teamNames = new HashMap<>();
		
		if (request.getParameter("teamId") == null) {
			for (BaseballTeam tmp : teams) {
				players.addAll(tmp.getPlayers());
				teamNames.put(tmp.getTeamId(), tmp.getName());
			}
		} else {
			for (BaseballTeam tmp : teams) {
				if (tmp.getTeamId().equals(request.getParameter("teamId"))) {
					players = tmp.getPlayers();
					teamNames.put(tmp.getTeamId(), tmp.getName());
					break;
				}
			}
		}
		
		request.setAttribute("players", players);
		request.setAttribute("teamNames", teamNames);
		request.getRequestDispatcher("playerList.jsp").forward(request, response);
		
	}
	

}
