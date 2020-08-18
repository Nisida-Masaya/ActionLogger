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
.form-adduser {
	margin: 0px;
}

#password {
	margin-bottom: 20px;
}

.cols {
	width: 250px;
}
</style>
</head>
<body>
	<div class="row">
		<div class="cols"></div>
		<div class="col-8">
			<form class="form-adduser" action="/ActionLogger/changepassword"
				method="post">
				<h4 h3 mb-3 font-weight-normal>パスワード変更</h4>
				<div class="mb-3">
					<label for="password">新しいパスワード</label> <input type="password"
						class="form-control" id="password" name="password" placeholder=""
						required>
					<div class="invalid-feedback">必須</div>
					<label for="passwordconfirm">確認用パスワード</label> <input
						type="password" class="form-control" id="password"
						name="passwordconfirm" placeholder="" required>
					<div class="invalid-feedback">必須</div>
					<input type="submit" class="btn btn-secondary btn-block btn-lg"
						id="enterRoom" value="OK"></input>
			</form>
		</div>
		<div class="col"></div>
	</div>
</body>
</html>