<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード変更</title>
<!-- Bootstrap core CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<meta name="theme-color" content="#563d7c">
<!-- Custom styles for this template -->
<link href="/GuiWork/css/dashboard.css" rel="stylesheet">
<style>
.form-adduser{
	margin-left: 30px;
}
#password{
margin-bottom: 30px;
}
</style>
</head>
<body>
	<div class="row">
		<div class="col-8">
			<form class="form-adduser"
				action="/ActionLogger/changepasswordconfirm" method="post">
				<h4 h3 mb-3 font-weight-normal>パスワード変更</h4>
				<p>現在のパスワードを入力してください</p>
				<div class="mb-3">
					<label for="password">パスワード確認</label> <input type="password"
						class="form-control" id="password" name="password" placeholder="パスワード確認"
						required>
					<div class="invalid-feedback">必須</div>

					<input type="submit" class="btn btn-secondary btn-block btn-lg"
						id="enterRoom" value="OK"></input>
			</form>
		</div>
		<div class="col"></div>
	</div>
</body>
</html>