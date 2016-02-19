<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 2/16/16
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Запись Банка</title>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8">
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/bank/create" method="POST">
    <table>
        <tr>
            <td align="right" >Наименование Банка : </td>
            <td>
                <input type="text" name="bankName">
            </td>
        </tr>
        <tr>
            <td align="right" >БИК : </td>
            <td>
                <input type="text" name="bik">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>
