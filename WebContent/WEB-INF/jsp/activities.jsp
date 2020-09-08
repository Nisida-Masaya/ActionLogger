<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メンバー一覧</title>
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
	<div
		class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		<h1 class="h2">行動記録</h1>
		<%-- モーダル --%>
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModal">絞り込み</button>

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">活動記録の絞り込み</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<!-- 入力欄 -->
					<form action="/ActionLogger/?" method="get">
					<div class="modal-body">
					<label for="day">日付</label> <input type="date" name="day" placeholder="日付" value="">
					<label for="place"> 場所</label> <input type="text" name="place" placeholder="場所" value="">
					</div>
					<input type="hidden" name="view" value="activities"/>
					<input type="hidden" name="search" value="search"/>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary" id="enterRoom" >search</button>
					</div>
					</form>
				</div>
			</div>
		</div>
		<script>
			$('#myModal').on('shown.bs.modal', function() {
				$('#myInput').trigger('focus')
			})
		</script>
	</div>

	<div class="table-responsive">
		<table class="table table-striped table-sm">
			<thead>
				<tr>
					<th>日付</th>
					<th>時刻</th>
					<th>場所</th>
					<th>理由</th>
					<th>備考</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="action" items="${actionhistory}">
					<tr>
						<td><c:out value="${action.day}" /></td>
						<td><c:out value="${action.starttime}" />-<c:out
								value="${action.finishtime}" /></td>
						<td><c:out value="${action.place}" /></td>
						<td><c:out value="${action.reason}" /></td>
						<td><c:out value="${action.remark}" /></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>