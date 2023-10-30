<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="header.jsp" %>
<body>
<%@include file="name-panel.jsp" %>
<%@include file="counters-panel.jsp" %>
<div class="content">
    <img src="images/start-dog.jpg" alt="Собака одиноко грустит">
    <div class="text-form-container">
        <h4>Осень. Идет ливень. Ты видишь бездомную собачку.
            <br>
            Так и хочется забрать ее к себе домой, ну хотя бы для того, чтобы отогреть бедняжку.
            <br>
        </h4>
        <p>
            Подойдешь к ней поближе?
        </p>
        <form action="${pageContext.request.contextPath}/start" method="post">
            <c:forEach var="challengeAcceptance" items="${requestScope.challengeAcceptance}">
                <label>
                    <input type="radio" name="challengeAcceptance"
                           value="${challengeAcceptance}" required>
                </label> ${challengeAcceptance.russianTranslation}
                <br>
            </c:forEach>
            <button type="submit">OK</button>
        </form>
    </div>
</div>
</body>
</html>
