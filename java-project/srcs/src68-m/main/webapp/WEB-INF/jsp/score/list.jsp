<%@page import="java100.app.domain.Score"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>성적관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>
<jsp:include page="../header.jsp"/>
<h1>성적 목록</h1>

<div class='toolbar'>
<p><a href='form' class='btn btn-success btn-sm'>추가</a></p>

<form action="list" method="get">
<input type="text" name="nm" >
<button class='btn btn-primary btn-sm'>검색</button>
</form>
</div>
<form action="list" method="get" class="searchbox">
<input type="hidden" name="oc" value="sum">
<input type="radio" name="al" value="desc">합계내림차순
<input type="radio" name="al" value="asc">합계오름차순
<button class="btn btn-info" style="font-size: 1px;">정렬</button>
</form>

<form action="list" method="get"  class="searchbox">
<input type="hidden" name="oc" value="name">
<input type="radio" name="al" value="desc">이름내림차순
<input type="radio" name="al" value="asc">이름오름차순
<button class="btn btn-info" style="font-size: 1px;">정렬</button>
</form>
<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>이름</th><th>합계</th><th>평균</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="score">
    <tr>
       <td>${score.no}</td>
       <td><a href='${score.no}'>${score.name}</a></td>
       <td>${score.sum}</td>
       <td>${score.aver}</td>
    </tr>
</c:forEach>
</tbody>
</table>
<jsp:include page="../footer.jsp"/>
</div>
<jsp:include page="../jslib.jsp"/>
</body>
</html>
    