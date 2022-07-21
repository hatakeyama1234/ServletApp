<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/servlet01/css/u_login.css?v=2">
<title>ログイン画面</title>
</head>
<body>
	<h2>利用者ログイン</h2>
	<a href="/servlet01/Topmenu">トップメニューへ</a><br><br>
	<button class="button-1" role="button" onclick="location.href='/servlet01/listdisplay'">ユーザー登録はここから</button>
	<h1>利用者ログイン</h1>
	<form action="/servlet01/u_LoginServlet" method="post">
		ログインID&nbsp;:<input type = "text" name = "login_id"><br><br>
		パスワード:<input type = "text" name = "pw"><br><br>
		<button class="button-2" role="button" onclick="location.href='/servlet01/u_LoginServlet'">ログイン</button>
	</form>
</body>
</html>