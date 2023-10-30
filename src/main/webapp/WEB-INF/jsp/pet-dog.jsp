<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="header.jsp"%>
<body>
<%@include file="name-panel.jsp" %>
<%@include file="counters-panel.jsp" %>
<div class="content">
    <img src="images/look-in-awe-dog.jpg" alt="Собака тебя боготворит">
    <div class="text-form-container">
<h4>
    Ты показал кто тут хозяин и грубо забрал колбасу.
    <br>
    Собака посмотрела на тебя с благовением. Она поняла свое место.
    <br>
</h4>
<p>Все таки хорошая собака, погладишь ее с одобрением?</p>
<form action="${pageContext.request.contextPath}/pet-dog" method="post">
    <c:forEach var="petDogAcceptance" items="${requestScope.petDogAcceptance}">
        <label>
            <input type="radio" name="petDogAcceptance" value="${petDogAcceptance}" required>
        </label> ${petDogAcceptance.russianTranslation}
        <br>
    </c:forEach>
    <br>
    <button type="submit">OK</button>
</form>
</div>
</div>
</body>
</html>