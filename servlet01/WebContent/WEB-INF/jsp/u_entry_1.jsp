<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ登録</title>
<link rel="stylesheet" href="css/u_register.css">
</head>
<body>
	<header>
		<span>ユーザ登録</span>
		<nav>
			<ul>
				<li><a href="/servlet01/Topmenu">トップメニューへ</a></li>
			</ul>
		</nav>
	</header>
	<h3>ユーザ登録</h3>
	<form action="/servlet01/RegisterServlet" method="post">
		<table align="center">
			<tr>
				<td width="150" class="login">ログインID</td>
				<td width="200"><input type="text" name="login_id" required size="30"></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="text" name="pw" required size="30"></td>
			</tr>
		</table><br>
		<table align="center">
			<tr>
				<td colspan="2">
					<center><input type="submit" value="次へ" style="width:50px;height:30px; background-color:lightskyblue; border:solid black 1px"></center>
				</td>
			</tr>
		</table>

	</form>
</body>
</html>