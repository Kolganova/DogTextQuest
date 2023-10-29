<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@include file="header.jsp"%>
<body>
<%@include file="name-panel.jsp" %>
<%@include file="counters-panel.jsp" %>
<div class=content">
    <img src="images/drinking-dog.jpg.webp" alt="Собака пьет">
    <div class="text-link-container">
<h4>
    Собака и так настрадалась, достать так же Фанту из кармана. Не есть же в сухомятку...
    <br>
</h4>
<a href="${pageContext.request.contextPath}/multiply-meal-lost">
    <button type="button">Ну да</button>
</a>
    </div>
</div>
</body>
</html>
