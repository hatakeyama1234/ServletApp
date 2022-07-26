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
				<li><a href="/servlet01/Topmenu">トップメニューへ</a></li>
			</ul>
		</nav>
	</header>
	<h2>登録確認</h2>
	<table align="center">
		<tr>
			<th>ログインID:</th> <td width="100"><%= account.getLogin_id() %></td>
		</tr>
	</table>
	<br>
	<p>上記の内容で登録しますか？</p>
	<a href="/servlet01/RegisterServlet?action=go" class="tou">登録</a>
	&emsp;
	<a href="/servlet01/RegisterServlet">キャンセル</a>
</body>
</html>