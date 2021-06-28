<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/WEB-INF/views/templates/head.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
<h1>Division Insert</h1>
<form action="divInsert" method="post" id="frm">
<input type="text" name="collab" id="collab"><a id="duplCheck">중복 확인</a>
<p id="divCheckText"></p>
</form>
<button id="addBtn">추가</button>
<script type="text/javascript" src="/js/product/divisionInsert.js"></script>
</body>
</html>