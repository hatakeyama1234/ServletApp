<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="scopedata.U_account" %>
<%@ page import="scopedata.Company" %>
<%@ page import="java.util.List" %>
<%
	U_account account = (U_account)session.getAttribute("account");
	List<Company> list = (List<Company>)session.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧表示</title>
<link rel="stylesheet" href="">
</head>
<body>
	<header>
		<h2>利用者メニュー</h2>
		<div class="text_right"><span class="font20">
						ログインID：<%= account.getLogin_id() %></span>
			&emsp;&emsp;<a href="/servlet01/LogoutServlet">ログアウト</a>
		</div>
	</header>
	<div class="block_center">
		<h1>登録企業一覧表示</h1>
		<table>
			<tr>
				<th>企業名</th>
				<th>地域</th>
				<th>業種</th>
				<th>年度</th>
				<th>PDF</th>
			</tr>
			<% for (Company w : list) { %>
				<tr>
					<td><%= w.getCompany() %></td>
					<td><%= w.getArea() %></td>
					<td><%= w.getIndustry() %></td>
					<td><%= w.getYear() %></td>
				</tr>
			<%} %>
		</table>
		<br>
		<p><a href="/servlet01/SearchServlet?action=menu">利用者メニューに戻る</a></p>
	</div>
</body>
</html>