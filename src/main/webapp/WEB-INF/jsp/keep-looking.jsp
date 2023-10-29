<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="header.jsp"%>
<body>
<%@include file="name-panel.jsp" %>
<%@include file="counters-panel.jsp" %>
<div class="content">
    <img src="images/keep-looking-dog.jpg" alt="Собака смотрит">
    <div class="text-form-container">
<h4>
    Собака смотрит не отводя взгляд. Продолжишь смотреть?
</h4>
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
</div>
</div>
</body>
</html>
