<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@include file="header.jsp"%>
<body>
<%@include file="name-panel.jsp" %>
<%@include file="counters-panel.jsp" %>
<div class="content">
    <img src="images/psy-dog.jpg" alt="Собака-психолог">
    <div class="text-link-container">
    <p>
    Это было проще, чем казалось. Ты стойкий и тебе совсем никто не нужен, что бы чувствовать себя полноценно. У тебя
    все хорошо, квартира, машина, отличная работа.
    <br>
    Только дома как-то пустовато...
    <br>
    и там совсем никто не ждет.
    <br>
    Никто радостно не бросается на руки и не улыбается от одного твоего взгляда.
    <br>
    А может Вам все таки кто-то нужен?
    <br>
    В общем собака заставила тебя серьезно задуматься над смыслом полноценности.
    <br>
    Нужно вернуться и подобрать беднягу.
</p>
<a href="${pageContext.request.contextPath}/start">
    <button type="button">Ладно</button>
</a>
    </div>
</div>
</body>
</html>
