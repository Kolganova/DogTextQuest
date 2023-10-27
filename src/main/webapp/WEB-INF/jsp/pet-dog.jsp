<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Одинокий песик</title>
</head>
<body>
<h2>
    Ты показал кто тут хозяин и грубо забрал колбасу
    Собака посмотрела на тебя с гордостью. Она поняла свое место.
</h2>
<p>Все таки хорошая собака, погладишь ее с одобрением?</p>
<br>
<form action="${pageContext.request.contextPath}/pet-dog" method="post">
    <c:forEach var="petDogAcceptance" items="${requestScope.petDogAcceptance}">
        <label>
            <input type="radio" name="petDogAcceptance" value="${petDogAcceptance}">
        </label> ${petDogAcceptance.russianTranslation}
        <br>
    </c:forEach>
    <br>
    <button type="submit">OK</button>
</form>
</body>
</html>