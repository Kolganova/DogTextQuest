<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Одинокий песик</title>
</head>
<body>
<h2>
    А вот это ты зря...
    <br>
    Пес понял что тобой можно управлять.
    <br>Он забирает из твоей сумки припрятанную на черный день колбаску и ест смотря прямо тебе в глаза.
    <br>Позволишь псу себя так вести?</h2>
<form action="${pageContext.request.contextPath}/give-food" method="post">
    <c:forEach var="giveFoodAcceptance" items="${requestScope.giveFoodAcceptance}">
        <label>
            <input type="radio" name="giveFoodAcceptance"
                   value="${giveFoodAcceptance}">
        </label> ${giveFoodAcceptance.russianTranslation}
        <br>
    </c:forEach>
    <button type="submit">OK</button>
</form>
</body>
</html>
