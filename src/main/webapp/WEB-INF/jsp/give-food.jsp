<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="header.jsp"%>
<body>
<%@include file="name-panel.jsp"%>
<%@include file="counters-panel.jsp" %>
<div class="content">
    <img src="images/eating-dog.jpg" alt="Собака кушает">
    <div class="text-form-container">
        <h4>
            А вот это ты зря...
            <br>
            Пес понял что тобой можно управлять, это была проверка...
            <br>
            Он задорно спрыгивает сам и забирает из твоей сумки припрятанную на черный день колбаску и ест смотря прямо тебе в глаза.
            <br>
            Позволишь псу себя так вести?
        </h4>
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
    </div>
</div>
</body>
</html>
