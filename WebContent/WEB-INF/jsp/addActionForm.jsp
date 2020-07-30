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
</style>
<!-- Custom styles for this template -->
<link href="/GuiWork/css/dashboard.css" rel="stylesheet">

</head>
<body>
	<div class="row">
		<div class="col"></div>
		<div class="col-8">
			<form class="form-adduser" action="/ActionLogger/addaction"
				method="post">
				<h4 h3 mb-3 font-weight-normal>活動登録</h4>
				<div class="mb-3">
					<label for="day">日付</label> <input type="date" class="form-control"
						id="day" name="day" placeholder="日付" required>
					<div class="invalid-feedback">必須</div>
				</div>
				<div class="mb-3">
					<label for="starttime">開始時間</label> <input type="time"
						class="form-control" id="starttime" name="starttime"
						placeholder="開始時間" 　required>
					<div class="invalid-feedback">必須</div>
				</div>
				<div class="mb-3">
					<label for="finishtime">終了時間</label> <input type="time"
						class="form-control" id="finishtime" name="finishtime"
						placeholder="終了時間" required>
					<div class="invalid-feedback">必須</div>
				</div>
				<div class="mb-3">
					<label for="place">場所</label> <input type="text"
						class="form-control" id="place" name="place" placeholder="場所"
						required>
					<div class="invalid-feedback">必須</div>
				</div>
				<div class="mb-3">
					<label for="reason">理由</label> <input type="textarea"
						class="form-control" id="reason" name="reason" required>
				</div>
				<div class="mb-3">
					<label for="remark">備考</label> <input type="textarea"
						class="form-control" id="remark" name="remark" >
				</div>
				<input type="submit" class="btn btn-secondary btn-block btn-lg"
					id="enterRoom" value="登録"></input>
			</form>
		</div>
		<div class="col"></div>

	</div>
</body>
</html>