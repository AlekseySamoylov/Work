<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 2/16/16
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<h1>
<a href="${pageContext.servletContext.contextPath}/deposit/create">Добавить депозит</a>
<a href="${pageContext.servletContext.contextPath}/views/bank/CreateBank.jsp">Добавить банк</a>
<a href="${pageContext.servletContext.contextPath}/views/client/CreateClient.jsp">Добавить клиента</a>
</h1>
    <table border="1">
        <tr>
            <td>Наименование клиента</td>
            <td>Наименование Банка</td>
            <td>Дата открытия</td>
            <td>Процент</td>
            <td>Срок в месяцах</td>
            <td>Действия</td>
        </tr>
        <c:forEach items="${deposits}" var="deposit" varStatus="status">
            <tr valign="top">
                <td><a href="${pageContext.servletContext.contextPath}/client/edit?id=${deposit.clientId}">${deposit.clientShortName} </a></td>
                <td><a href="${pageContext.servletContext.contextPath}/bank/edit?id=${deposit.bankId}">${deposit.bankName} </a> </td>
                <td>${deposit.dateTime} </td>
                <td>${deposit.percent} %</td>
                <td>${deposit.creditTime} м</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/deposit/edit?id=${deposit.depositId}">Редактировать</a>
                </td>
            </tr>
        </c:forEach>
    </table>

<p style="text-indent:100px; margin: 20px" align="left" >
    Реализовать пользовательский web-интерфейс по открытию вклада в банке.
    <br><br>
    На уровне базы данных (кандидат выбираем БД на свое усмотрение) должны быть реализованы следующие сущности:
    <br>1.	Клиенты
    <br>a.	Наименование;
    <br>b.	Краткое наименование;
    <br>c.	Адрес;
    <br>d.	Организационно-правовая форма (выбор из списка);
    <br>2.	Банки
    <br>a.	Наименование;
    <br>b.	БИК.
    <br>3.	Вклад
    <br>a.	Клиент(ссылка);
    <br>b.	Банк(ссылка);
    <br>c.	Дата открытия;
    <br>d.	Процент;
    <br>e.	Срок в месяцах.
    <br>Пользовательский интерфейс должен отображать общий список вкладов открытых всеми клиентами во всех банках. Должна быть возможность открыть на редактирование существующий вклад или создать новый.

</p>

</body>
</html>
