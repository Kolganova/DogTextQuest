<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@include file="header.jsp" %>
<body>
<%@include file="name-panel.jsp" %>
<%@include file="counters-panel.jsp" %>
<div class="content">
    <img src="images/happy-dog.webp" alt="Собака довольна">
    <div class="text-link-container">
        <h4>Ты погладил собаку.</h4>
        <p>Собака тебе благодарна. Ты правда хороший и щедрый человек.
            <br>Она аккуратно облизнула твою щеку и убежала в закат. Ты победил.</p>
        <%@include file="offer-replay.jsp" %>
    </div>
</div>
</body>
</html>
