<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Одинокий песик</title>
</head>
<body>
<h2>Осень. Идет ливень. Ты видишь бездомную собачку.
    <br>
    Так и хочется забрать ее к себе домой, ну хотя бы что бы отогреть бедняжку.
    <br>
    Подойдешь к ней поближе?</h2>
<form action="${pageContext.request.contextPath}/start" method="post">
    <c:forEach var="challengeAcceptance" items="${requestScope.challengeAcceptance}">
        <label>
            <input type="radio" name="challengeAcceptance"
                   value="${challengeAcceptance}">
        </label> ${challengeAcceptance.russianTranslation}
        <br>
    </c:forEach>
    <button type="submit">OK</button>
</form>
</body>
</html>
