package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scopedata.U_account;
import scopedata.u_Login;

public class u_AccountDAO {
	public U_account findUserCheck( u_Login login ) {
		U_account account = null;
		Connection con = null;
		PreparedStatement pstmt;
		String login_id = login.getId();
		String pw = login.getPass();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/test","sa","1219555a");
			String sql ="select * from account where id = ? and pass = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString( 1, login_id );
			pstmt.setString( 2, pw );
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			account = new U_account( login_id , pw);
			
		}catch( Exception e ) {
			return null;
		}finally {
			try {
				if( con!= null ) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return account;
	}
}
