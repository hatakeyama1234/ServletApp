package servret;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CompanySearchDAO;
import scopedata.Company;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String path = null;

		HttpSession session = request.getSession();

		if( action.equals("menu_jyouken")) {  //ログインメニューからの呼び出し
			List<Company> list = new ArrayList<Company>();
			session.setAttribute("list",list);
			path = "WEB-INF/jsp/u_search.jsp";
			
		}else if(action.equals("menu_list")){  //メニューの一覧表示からの呼び出し
			CompanySearchDAO s = new CompanySearchDAO();
			List<Company> list = s.findList("", "", "");
			session.setAttribute("list", list);
			path = "WEB-INF/jsp/u_co_list.jsp";
			
		}else if(action.equals("search")) {    //検索ボタンからの呼び出し
			String area = request.getParameter("area");
			String industry = request.getParameter("industry");
			String year = request.getParameter("year");

			CompanySearchDAO s = new CompanySearchDAO();
			List<Company> list = s.findList(area,industry,year);
			session.setAttribute("list", list);
			path = "WEB-INF/jsp/u_search.jsp";
			
		}else if(action.equals("menu")) {      //メニューに戻るからの呼び出し
			path = "WEB-INF/jsp/u_menu.jsp";
		}else {
			
		}
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
