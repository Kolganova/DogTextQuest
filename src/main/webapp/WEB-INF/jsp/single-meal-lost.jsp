<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="header.jsp"%>
<%@include file="counters-panel.jsp" %>
<body>
<%@include file="name-panel.jsp" %>
<div class=content">
    <img src="images/dangerous-dog.jpg" alt="Злая собака">
    <div class="text-link-container">
<h4>Собака восприняла тебя как угрозу и... загрызла насмерть. Ты проиграл.</h4>
<%@include file="offer-replay.jsp"%>
    </div>
</div>
</body>
</html>
