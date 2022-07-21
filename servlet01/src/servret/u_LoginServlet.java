package servret;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.u_LoginLogic;
import scopedata.u_Login;

@WebServlet("/u_LoginServlet")
public class u_LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/u_login.jsp");
		dispatcher.forward(request, response);
	
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path;
		request.setCharacterEncoding("UTF-8");
		
		String login_id = request.getParameter("login_id");
		String pw = request.getParameter("pw");
		HttpSession session = request.getSession();
		u_Login login = new u_Login( login_id , pw );
		session.setAttribute( "login" , login );
		
		u_LoginLogic bo = new u_LoginLogic( );
		boolean r = bo.execute( login );
		if( r == true ) {
			path ="/WEB-INF/jsp/u_entry.jsp";
	}else {
			path ="/WEB-INF/jsp/u_loginErr.jsp";
	}
		RequestDispatcher dispatcher =
				request.getRequestDispatcher( path );
		dispatcher.forward(request, response);
		}

}
