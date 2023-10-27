<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Одинокий песик</title>
</head>
<body>
<h2>
    Собака смотрит не отводя взгляд. Продолжишь смотреть?
</h2>
<form action="${pageContext.request.contextPath}/keep-looking" method="post">
<c:forEach var="keepLookingAcceptance" items="${requestScope.keepLookingAcceptance}">
    <label>
        <input type="radio" name="keepLookingAcceptance" value="${keepLookingAcceptance}">
    </label> ${keepLookingAcceptance.russianTranslation}
    <br>
</c:forEach>
    <br>
    <button type="submit">OK</button>
</form>
</body>
</html>
