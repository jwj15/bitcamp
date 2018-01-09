<%@page import="java100.app.domain.Score"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<jsp:include page="../listToolbar.jsp"/>
<nav class="navbar navbar-light justify-content-between searchbox">
<div class="btn-group" >
  <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    정렬
  </button>
<div class="dropdown-menu">
    <a class="dropdown-item" href="list?oc=sum&al=desc">합계내림차순</a>
    <a class="dropdown-item" href="list?oc=sum&al=asc">합계오름차순</a>
    <a class="dropdown-item" href="list?oc=name&al=desc">이름내림차순</a>
    <a class="dropdown-item" href="list?oc=name&al=asc">이름오름차순</a>
  </div>
</div>
</nav>
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
       <td><fmt:formatNumber value="${score.aver}" pattern=".0"/></td>
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
    