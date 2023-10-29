<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@include file="header.jsp"%>
<body>
<%@include file="name-panel.jsp" %>
<%@include file="counters-panel.jsp" %>
<div class="content">
    <img src="images/sad-dog.jpeg" alt="Собака уходит">
    <div class="text-link-container">
<h4>Ты грозно посмотрел в ответ что бы подтвердить свои действия.
    <br>
    Собака испугулась и убежала. Ты проиграл.
    <br>
</h4>
<%@include file="offer-replay.jsp" %>
</div>
</div>
</body>
</html>
