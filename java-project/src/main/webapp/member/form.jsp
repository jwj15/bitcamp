<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link rel='stylesheet' href='../node_modules/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='../css/common.css'>
</head>
<body>
<div class='container'>
<jsp:include page="/header.jsp"/>
<h1>회원 등록</h1>
<form action='add.jsp' method='post'>
<div class='form-group row'>
<label class='col-sm-2 col-form-label' for='name'>이름</label>
<div class='col-sm-10'>
<input id='name' type='text' name='name'>
</div>
</div>
<div class='form-group row'>
<label class='col-sm-2 col-form-label' for='email'>이메일</label>
<div class='col-sm-10'>
<input id='email' type='email' name='email'>
</div>
</div>
<div class='form-group row'>
<label class='col-sm-2 col-form-label' for='password'>암호</label>
<div class='col-sm-10'>
<input id='password' type='password' name='password'>
</div>
</div>
<div class='form-group row'>
<div class='col-sm-10'>
<button class='btn btn-success btn-sm'>추가</button>
</div>
</div>
</form>
<jsp:include page="/footer.jsp"/>
</div>
<%@ include file="../jslib.txt" %>
</body>
</html>
