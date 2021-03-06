<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>活動記録</title>
<!-- Bootstrap core CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<meta name="theme-color" content="#563d7c">
<!-- Custom styles for this template -->
<link href="/GuiWork/css/dashboard.css" rel="stylesheet">
</head>
<body>
	<nav
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">Action
			Logger</a>
	</nav>
	<div class="row">
		<div class="col"></div>
		<div class="col-8">
			<form class="form-adduser"
				action="/ActionLogger/addactionconfirm" method="post">

				<h4 h3 mb-3 font-weight-normal>活動記録</h4>
				<div class="mb-3">日付 : ${actionToAdd.day}</div>
				<div class="mb-3">開始時間 : ${actionToAdd.starttime }</div>
				<div class="mb-3">終了時間 : ${actionToAdd.finishtime}</div>
				<div class="mb-3">場所 : ${actionToAdd.place}</div>
				<div class="mb-3">理由 : ${actionToAdd.reason}</div>
				<div class="mb-3">備考 : ${actionToAdd.remark}</div>
				<%-- フォームの正当性確認データ --%>
				<input type="hidden" name="vKey" value="${validationKey.value}">
				<input type="hidden" name="status" value="confirmed"></input> <input
					type="submit" class="btn btn-secondary btn-block btn-lg"
					id="enterRoom" value="OK"></input>
			</form>
		</div>
		<div class="col"></div>
	</div>
</body>
</html>