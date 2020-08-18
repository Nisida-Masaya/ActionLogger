<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
.Heading{
text-align: right;
}

</style>
<!-- Custom styles for this template -->
<link href="/GuiWork/css/dashboard.css" rel="stylesheet">
</head>
<body>
<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">プロフィール確認</h1>
</div>
	<table>
		<tr>
			<td class="Heading">ユーザID:</td>
			<td>　<c:out value="${userid}"/></td>
		</tr>
		<tr>
			<td class="Heading">氏名:</td>
			<td>　<c:out value="${name}"/></td>
		</tr>
		<tr>
			<td class="Heading">パスワード:</td>
			<td>　********</td>
		</tr>
		<tr>
			<td class="Heading">住所:</td>
			<td>　<c:out value="${address}"/></td>
		</tr>
		<tr>
			<td class="Heading">電話番号:</td>
			<td>　<c:out value="${tel}"/></td>
		</tr>
		<tr>
			<td class="Heading">メールアドレス:</td>
			<td>　<c:out value="${email}"/></td>
		</tr>
	</table>
</body>
</html>