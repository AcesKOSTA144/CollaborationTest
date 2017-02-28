package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BaseballTeam;
import service.BaseballTeamService;
import service.logic.BaseballTeamServiceLogic;

@WebServlet("/teamDetail.do")
public class TeamDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BaseballTeamService service = new BaseballTeamServiceLogic();
		List<BaseballTeam> teams = service.findAllTeamsWithPlayers();
		BaseballTeam team = new BaseballTeam();
		for (BaseballTeam tmp : teams) {
			if (tmp.getTeamId().equals(request.getParameter("teamId"))) {
				team = tmp;
				break;
			}
		}
		request.setAttribute("team", team);
		request.getRequestDispatcher("teamDetail.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
