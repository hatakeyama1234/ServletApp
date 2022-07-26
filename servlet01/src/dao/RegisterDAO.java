package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import scopedata.U_account;

public class RegisterDAO {
	public int execute(U_account account) {
		int f=0;
		Connection con = null;

		try {
			Class.forName("org.h2.Driver");
			con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","tatu1927");
			String sql="insert into uuser values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account.getLogin_id());
			pstmt.setString(2, account.getPw());

			f=pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(con!=null)  con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return f;   //更新行数を返す 0の場合は登録されていないことを示す
	}
}
