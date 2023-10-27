<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Одинокий песик</title>
</head>
<body>
<h2>
    Собачка радостно запрыгнула к тебе на руки.
    <br>
    Теперь ты полностью в грязи.
    Сбросить ее с рук?
</h2>
<form action="${pageContext.request.contextPath}/jumping-dog" method="post">
    <c:forEach var="dogOnArmsAcceptance" items="${requestScope.dogOnArmsAcceptance}">
        <label>
            <input type="radio" name="dogOnArmsAcceptance" value="${dogOnArmsAcceptance}">
        </label> ${dogOnArmsAcceptance.russianTranslation}
        <br>
    </c:forEach>
    <br>
    <button type="submit">OK</button>
</form>
</body>
</html>

