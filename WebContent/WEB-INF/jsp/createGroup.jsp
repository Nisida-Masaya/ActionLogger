<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>グループ作成</title>
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

.Heading {
	text-align: right;
}
</style>
<!-- Custom styles for this template -->
<link href="/GuiWork/css/dashboard.css" rel="stylesheet">
</head>
<body>
	<div class="row">
		<div class="col"></div>
		<div class="col-8">
			<form class="form-adduser" action="/ActionLogger/creategroup"
				method="post">
				<h4 h3 mb-3 font-weight-normal>グループ作成</h4>
				<div class="mb-3">
					<label for="groupid">グループID</label> <input type="text"
						class="form-control" id="groupid" name="groupid"
						value="" placeholder="グループID" required>
				</div>
				<div class="mb-3">
					<label for="groupname">グループ名</label> <input type="text"
						class="form-control" id="groupname" name="groupname"
						value="" placeholder="グループ名" required>
				</div>
				<input type="submit" class="btn btn-secondary btn-block btn-lg"
					id="enterRoom" value="作成"></input>
			</form>
		</div>
		<div class="col"></div>
	</div>
</body>
</html>