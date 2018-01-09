<%@page import="java100.app.domain.Room"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>강의실관리</title>
<link rel='stylesheet' href='../../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../../css/common.css'>
</head>
<body>
<div class='container'>
<jsp:include page="../header.jsp"/>
<h1>강의실 목록</h1>

<jsp:include page="../listToolbar.jsp"/>
<nav class="navbar navbar-light justify-content-between searchbox">
<div class="btn-group">
  <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    정렬
  </button>
<div class="dropdown-menu">
    <a class="dropdown-item" href="list?oc=loc&al=desc">장소내림차순</a>
    <a class="dropdown-item" href="list?oc=loc&al=asc">장소오름차순</a>
    <a class="dropdown-item" href="list?oc=name&al=desc">강의실명내림차순</a>
    <a class="dropdown-item" href="list?oc=name&al=asc">강의실명오름차순</a>
  </div>
</div>
</nav>
<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>장소</th><th>강의실명</th><th>수용인원</th><th>삭제</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="room">
<tr>
    <td>${room.no}</td>
    <td>${room.location}</td>
    <td>${room.name}</td>
    <td>${room.capacity}</td>
    <td><a href='delete?no=${room.no}' class='btn btn-danger btn-sm'>삭제</a></td>
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
    