<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>
<jsp:include page="../header.jsp"/>
<h1>게시판 목록</h1>
<p><a href='form' class='btn btn-success btn-sm'>추가</a></p>
<form action="list" method="get">
<input type="text" name="nm" >
<button class='btn btn-primary btn-sm'>검색</button>
</form>
<form action="list" method="get" class="searchbox">
<input type="hidden" name="oc" value="regdt">
<input type="radio" name="al" value="desc">등록일내림차순
<input type="radio" name="al" value="asc">등록일오름차순
<button class="btn btn-info" style="font-size: 1px;">정렬</button>
</form>
<form action="list" method="get" class="searchbox">
<input type="hidden" name="oc" value="title">
<input type="radio" name="al" value="desc">제목내림차순
<input type="radio" name="al" value="asc">제목오름차순
<button class="btn btn-info" style="font-size: 1px;">정렬</button>
</form>
<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>제목</th><th>등록날짜</th><th>조회수</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="board">
<tr>
    <td>${board.no}</td
    ><td><a href='${board.no}'>${board.title}</a></td>
    <td>${board.regDate}</td>
    <td>${board.viewCount}</td>
</tr>
</c:forEach>
</tbody>
</table>
<jsp:include page="../footer.jsp"/>
</div>
<jsp:include page="../jslib.jsp"/>
</body>
</html>
    