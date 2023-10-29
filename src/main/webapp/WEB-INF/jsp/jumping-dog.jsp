<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="header.jsp"%>
<body>
<%@include file="name-panel.jsp"%>
<%@include file="counters-panel.jsp" %>
<div class="content">
    <img src="images/dirty-dog.jpg" alt="Собака кушает">
    <div class="text-form-container">
<h4>
    Собачка радостно запрыгнула к тебе на руки.
    <br>
    Теперь ты полностью в грязи.
    Сбросить ее с рук?
</h4>
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
    </div>
</div>
</body>
</html>

