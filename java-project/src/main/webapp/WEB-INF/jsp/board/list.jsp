<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
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

<jsp:include page="../listToolbar.jsp"/>
<nav class="navbar navbar-light justify-content-between searchbox">
<div class="btn-group">
  <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    정렬
  </button>
<div class="dropdown-menu">
    <a class="dropdown-item" href="list?oc=regdt&al=desc">등록일내림차순</a>
    <a class="dropdown-item" href="list?oc=regdt&al=asc">등록일오름차순</a>
    <a class="dropdown-item" href="list?oc=title&al=desc">제목내림차순</a>
    <a class="dropdown-item" href="list?oc=title&al=asc">제목오름차순</a>
  </div>
</div>
</nav>
<table class='table table-hover'>
<thead>
<tr>
<th>번호</th><th>제목</th><th>등록날짜</th><th>조회수</th><th>작성자</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="board">
<c:set var="title" value="${fn:length(board.title) == 0 ? '(제목이 없습니다)' : board.title}"/>
<tr>
    <td>${board.no}</td>
    <%-- <td><a href='${board.no}'>${fn:substring(title, 0, 10)}
        ${(fn:length(title) > 10) ? '...' : ''}</a></td> --%>
    <td><span class="d-inline-block text-truncate" style="max-width: 160px;">
        <a href='${board.no}'>${title}</a></span></td>
    <td>${board.regDate}</td>
    <td>${board.viewCount}</td>
    <td>${board.writer.name}</td>
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
    