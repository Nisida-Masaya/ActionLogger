<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
		<h1 class="h2">Group Member List</h1>
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
						<h5 class="modal-title" id="exampleModalLabel">ユーザの絞り込み</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<form action="/ActionLogger/?" method="get">
						<div class="modal-body">
							<label for="day">ユーザ名</label> <input type="text" id= "name" name="name"
								placeholder="ユーザ名" value="">
						</div>
						<input type="hidden" name="view" value="groupmember" /> 
						<input type="hidden" name="search" value="search" />
						<input type="hidden" name="groupid" value="${groupid}"/>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary" id="enterRoom">search</button>
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
					<th>ユーザ名</th>
					<th>日付</th>
					<th>時刻</th>
					<th>場所</th>
					<th>理由</th>
					<th>備考</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="actionList" items="${userActionList}">
					<tr>
						<td><c:out value="${actionList.name}" /></td>
						<td><c:out value="${actionList.day}" /></td>
						<td><c:out value="${actionList.starttime}" />-<c:out
								value="${actionList.finishtime}" /></td>
						<td><c:out value="${actionList.place}" /></td>
						<td><c:out value="${actionList.reason}" /></td>
						<td><c:out value="${actionList.remark}" /></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

</body>
</html>