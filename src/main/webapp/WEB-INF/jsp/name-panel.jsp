<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div>
    <c:choose>
        <c:when test="${not empty sessionScope.name}">
            <h3>${sessionScope.name}</h3>
            <div id="logout">
                <form action="${pageContext.request.contextPath}/logout" method="get">
                    <button type="submit">Зайти за другого пользователя</button>
                </form>
            </div>
        </c:when>
        <с:otherwise>
            <h3>Anonymou$$</h3>
            <div id="login">
                <form action="${pageContext.request.contextPath}/greeting" method="get">
                    <button type="submit">Представиться</button>
                </form>
            </div>
        </с:otherwise>
    </c:choose>
</div>
<br>