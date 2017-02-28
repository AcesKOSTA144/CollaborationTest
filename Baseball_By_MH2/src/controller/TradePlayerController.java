package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseballTeamService;
import service.logic.BaseballTeamServiceLogic;

@WebServlet("/tradePlayer.do")
public class TradePlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BaseballTeamService service = new BaseballTeamServiceLogic();
			
		String sourcePlayerId = request.getParameter("sourcePlayer");
		String targetPlayerId = request.getParameter("targetPlayer");
		service.tradePlayer(sourcePlayerId, targetPlayerId);
		
		response.sendRedirect("playerList.do");
	}

}
