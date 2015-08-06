<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User Info</title>
</head>

<body>

<%--<h2>
    User name:
    <c:out value="${user.firstName} ${user.surname}"/>
</h2>--%>


<h2>
    User name:
    <c:out value="${user.firstName} ${user.surname}"/>
</h2>

<br/>
<table border="1">
    <tr>
        <th colspan="2">List of Accounts</th>
    </tr>
    <c:forEach var="account" items="${accounts}">
        <tr>
            <th colspan="2">Account</th>
        </tr>
        <tr>
            <th>Number</th>
            <th>Balance</th>
        </tr>
        <tr>
            <td><c:out value="${account.number}"/></td>
            <td><c:out value="${account.balance} USD"/></td>
        </tr>
        <c:forEach items="${transactions}" var="transactions">
            <c:forEach var="transaction" items="${transactions.value}">
                <c:if test="${account==transactions.key}">
                    <tr>
                        <th colspan="2">List of Transactions</th>
                    </tr>
                    <tr>
                        <th>Date</th>
                        <th>Amount</th>
                    </tr>
                    <tr>
                        <td><c:out value="${transaction.date}"/></td>
                        <td><c:out value="${transaction.amount}"/></td>
                    </tr>
                </c:if>
            </c:forEach>
        </c:forEach>
    </c:forEach>
</table>


<!-- 	<h2> -->
<!-- 		Account number: -->
<%-- 		<c:out value="${user.accountInfo.accountNumber}" /> --%>
<!-- 	</h2> -->
<!-- 	<h2> -->
<!-- 		Account balance: -->
<%-- 		<c:out value="${user.accountInfo.balance}" /> --%>
<!-- 	</h2> -->
<!-- 	<br /> -->

<!-- 	<table border="1"> -->
<!-- 		<tr> -->
<!-- 			<th colspan="2">List of Transactions</th> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<th>Date</th> -->
<!-- 			<th>Amount</th> -->
<!-- 		</tr> -->
<%-- 		<c:forEach var="transaction" items="${user.transactionList}"> --%>
<!-- 			<tr> -->
<%-- 				<td><c:out value="${transaction.date}" /></td> --%>
<%-- 				<td><c:out value="${transaction.amount} USD" /></td> --%>
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->
</body>
</html>
