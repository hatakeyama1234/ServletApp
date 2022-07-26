package servret;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;
import scopedata.U_account;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=null;
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
		if(action==null) {           //管理画面からの「新規」ボタン時
			path="WEB-INF/jsp/u_entry_1.jsp";  //入力画面表示
		}else if(action.equals("go")) {
			//確認画面からの「登録する」クリック時
			HttpSession session=request.getSession();
			U_account account=(U_account)session.getAttribute("RigisterUser");

			RegisterDAO rg=new RegisterDAO();
			int f=rg.execute(account);
			if(f==0)           //登録失敗時
				path="WEB-INF/jsp/registerErr.jsp";
			else               //登録成功時
				path="WEB-INF/jsp/u_entry_3.jsp";
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//入力画面から「次へ」のボタンが押されたとき
			request.setCharacterEncoding("UTF-8");
			String login_id = request.getParameter("login_id");
			String pw = request.getParameter("pw");
			MakeHash mh = new MakeHash( pw );
	        pw = mh.getHash();

			HttpSession session = request.getSession();  //セッションスコープ取得
			U_account account = new U_account (login_id,pw);
			session.setAttribute("RigisterUser",account);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/u_entry_2.jsp");
			dispatcher.forward(request,response);
		}

}
