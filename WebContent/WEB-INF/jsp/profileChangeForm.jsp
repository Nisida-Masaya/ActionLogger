<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<meta name="theme-color" content="#563d7c">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

#enter-Room {
	text-align: center;
}
p{
color: red;
}
</style>
<!-- Custom styles for this template -->
<link href="/GuiWork/css/dashboard.css" rel="stylesheet">
</head>
<body>
	<div class="row">
		<div class="col"></div>
		<div class="col-8">
			<form class="form-adduser" action="/ActionLogger/ProfileChange"
				method="post">
				<h4 h3 mb-3 font-weight-normal>プロフィール変更</h4>
				<p>ユーザIDは変更できません</p>
				<div class="mb-3">
					<label for="name">氏名</label> <input type="text"
						class="form-control" id="name" name="name"
						value="${name}" placeholder="氏名">
				</div>
				<div class="mb-3">
					<label for="address">住所</label> <input type="text"
						class="form-control" id="address" name="address" value="${address}" placeholder="住所"
						>
				</div>
				<div class="mb-3">
					<label for="tel">電話番号</label> <input type="text"
						class="form-control" id="tel" name="tel" value="${tel}" >
				</div>
				<div class="mb-3">
					<label for="email">メールアドレス</label> <input type="text"
						class="form-control" id="email" name="email" value="${email}" >
				</div>
				<input type="submit" class="btn btn-secondary btn-block btn-lg"
					id="enterRoom" value="OK"></input>
			</form>
		</div>
		<div class="col"></div>
	</div>
</body>
</html>