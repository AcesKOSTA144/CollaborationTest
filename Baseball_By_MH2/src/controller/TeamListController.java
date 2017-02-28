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

@WebServlet("/teamList.do")
public class TeamListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BaseballTeamService service;
	
	public TeamListController() {
		service  = new BaseballTeamServiceLogic();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BaseballTeam> teams = service.findAllTeams();
		
		request.setAttribute("teams", teams);
		request.getRequestDispatcher("teamList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
