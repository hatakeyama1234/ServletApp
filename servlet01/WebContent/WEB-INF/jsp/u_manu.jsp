<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="scopedata.U_account" %>
<%
	U_account account = (U_account)session.getAttribute("account");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザーメニュー</title>
<link rel="stylesheet" href="">
</head>
<body>
	<header>
		<h2>利用者メニュー</h2>
		<div class="text_right"><span class="font20">
						ログインID：<%= account.getLogin_id() %></span>
			&emsp;&emsp;<a href="/servlet01/LoginServlet">ログアウト</a>
		</div>
	</header>
	<div class="block_center">
		<br><br>
		<h2>企業の表示方法選択</h2>
		<form action="/servlet01/SearchServlet" methods="get">
			<input type="hidden" name="action" value="menu_jyouken">
			<input type="submit" value="検索表示" class="find_button">
		</form>
		<form action="/servlet01/SearchServlet" methods="get">
			<input type="hidden" name="action" value="menu_list">
			<input type="submit" value="一覧表示" class="list_button">
		</form>
	</div>
</body>
</html>