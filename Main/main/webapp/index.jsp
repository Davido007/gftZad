<%@ page import="com.example.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<%--<h2>Hello World!</h2>--%>

<form action="home" method="post">
    <p>${user.name}   ${user.surname}</p>
    <p>${user.accData.accNumber}   ${user.accData.balance}</p>
    <c:forEach var="transaction" items="${user.transactions}">
        <c:out value="${transaction.date}"/>
        <c:out value="${transaction.amount}"/>
        <% out.println("<BR>"); %>
    </c:forEach>
   <%-- <p>
        Name: <input type="text" name="name"/>
    </p>

    <p>
        <input type="submit" value="Enter name">
    </p>--%>
</form>
</body>
</html>
