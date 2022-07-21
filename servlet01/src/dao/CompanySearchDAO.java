package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import scopedata.Company;

public class CompanySearchDAO {
	public List<Company> findList(
			String _area , String _industry , String _year){
		List<Company> dlist = new ArrayList<Company>();
		Connection con = null;
		PreparedStatement pstmt;
		String sql = null;
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection(
					"jdbc:h2:tcp://localhost/~/company","sa","pass");
			if(!_area.equals("") && _industry.equals("") && _year.equals("")) {
				//地域からの抽出
				sql ="select * from Company where area = ? order by id asc";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, _area);
			}else if(_area.equals("") && !_industry.equals("") && _year.equals("")) {
				//業種から抽出
				sql ="select * from Company where industry = ? order by id asc";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, _industry);
			}else if(_area.equals("") && _industry.equals("") && !_year.equals("")) {
				//年から抽出
				sql ="select * from Company where year = ? order by id asc";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, _year);
			}else if(!_area.equals("") && !_industry.equals("") && _year.equals("")) {
				//地域と業種から抽出
				sql ="select * from Company where area = ? and industry = ? order by id asc";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, _area);
				pstmt.setString(2, _industry);
			}else if(!_area.equals("") && _industry.equals("") && !_year.equals("")) {
				//地域と年度から抽出
				sql ="select * from Company where area = ? and year = ? order by id asc";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, _area);
				pstmt.setString(2, _year);
			}else if(_area.equals("") && !_industry.equals("") && !_year.equals("")) {
				//業種と年度から抽出
				sql ="select * from Company where industry = ? and year = ? order by id asc";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, _industry);
				pstmt.setString(2, _year);
			}else {
				//何も設定なしは全データ抽出
				sql = "select * from Company";
				pstmt = con.prepareStatement(sql);
			}
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id       = rs.getString("id");
				String com      = rs.getString("company");
				String area     = rs.getString("area");
				String industry = rs.getString("industry");
				String year     = rs.getString("year");
				String pdf      = rs.getString("pdf");
				Company company = new Company(id,com,area,industry,year,pdf);
				dlist.add(company);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				if(con!=null)   con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dlist;
	}
}
