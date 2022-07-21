package model;

import dao.u_AccountDAO;
import scopedata.U_account;
import scopedata.u_Login;


public class u_LoginLogic {
	public boolean execute( u_Login login ) {
		u_AccountDAO dao = new u_AccountDAO();
		U_account account = dao.findUserCheck( login );
		if( account  == null ) return false;
		else				   return true;
	}
}
