<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@include file="header.jsp" %>
<body>
<div class=content">
    <img src="images/greeting-dog.png" alt="Собака приветствует">
    <div class="text-link-container">
        <h4>Квест-игра "Одинокий песик"</h4>
        <p>
            Приветствуем на странице нашего текстового квеста!
            <br>
            Вам предстоит пройти небольшой квест (сложность 4/ 10) в котором будет оценены ваши качества как человека.
            <br>
        </p>
        <form action="${pageContext.request.contextPath}/greeting" method="post">
            <label for="nameId">Введите свое имя:</label>
            <input type="text" name="name" id="nameId">
            <button type="submit">Поехали!</button>
        </form>
    </div>
</div>
</body>
</html>
