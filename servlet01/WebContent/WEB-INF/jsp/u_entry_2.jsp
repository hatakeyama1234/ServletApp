<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="scopedata.U_account" %>
<%
	U_account account = (U_account) session.getAttribute("RigisterUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/u_register.css">
<title>登録確認</title>
</head>
<body>
	<header>
		<span>登録確認</span>
		<nav>
			<ul>
				<li><a href="/servlet01/topmenu.html">トップメニューへ</a></li>
			</ul>
		</nav>
	</header>
	<h2>登録確認</h2>
	<table>
		<tr>
			<th>ログインID:</th> <td width="200"><%= account.getLogin_id() %></td>
		</tr>
	</table>
	<br>
	<a href="/AccountManagement/listdisplay">キャンセル</a>
	&emsp;
	<a href="/AccountManagement/RegisterServlet?action=go">登録する</a>
</body>
</html>