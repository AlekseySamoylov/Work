<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 2/16/16
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Изменение данных Банка</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/bank/edit" method="POST">
    <input type="hidden" name="id" value="${bank.bankId}">
    <table>
        <tr>
            <td align="right" >Наименование : </td>
            <td>
                <input type="text" name="bankName" value="${bank.name}">
            </td>
        </tr>
        <tr>
            <td align="right" >БИК : </td>
            <td>
                <input type="text" name="bik" value="${bank.bik}">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>
