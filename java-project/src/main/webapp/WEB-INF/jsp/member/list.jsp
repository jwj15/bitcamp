<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>
<jsp:include page="../header.jsp"/>
<h1>회원 목록</h1>

<jsp:include page="../listToolbar.jsp"/>
<nav class="navbar navbar-light justify-content-between searchbox">
<div class="btn-group">
  <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    정렬
  </button>
<div class="dropdown-menu">
    <a class="dropdown-item" href="list?oc=regdt&al=desc">등록일내림차순</a>
    <a class="dropdown-item" href="list?oc=regdt&al=asc">등록일오름차순</a>
    <a class="dropdown-item" href="list?oc=name&al=desc">이름내림차순</a>
    <a class="dropdown-item" href="list?oc=name&al=asc">이름오름차순</a>
  </div>
</div>
</nav>
<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>이름</th><th>이메일</th><th>등록날짜</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="member">
<tr>
	<td>${member.no}</td>
	<td><a href='${member.no}'>${member.name}</a></td>
	<td>${member.email}</td>
	<td>${member.createdDate}</td>
</tr>
</c:forEach>
</tbody>
</table>

<jsp:include page="../paging.jsp"/>

<jsp:include page="../footer.jsp"/>
</div>
<jsp:include page="../jslib.jsp"/>
</body>
</html>
    