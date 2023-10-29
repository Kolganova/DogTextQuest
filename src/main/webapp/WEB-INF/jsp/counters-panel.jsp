<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<p>
  Общее количество попыток: ${sessionScope.counter}
  <br>
  Количество побед: ${sessionScope.winsCounter}
</p>