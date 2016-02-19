<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 2/16/16
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title></title>
    <meta charset="UTF-8">
</head>
<body>
<h2>
<a href="${pageContext.servletContext.contextPath}/views/bank/CreateBank.jsp">Добавить банк</a>
<a href="${pageContext.servletContext.contextPath}/views/client/CreateClient.jsp">Добавить клиента</a>
</h2>
<form action="${pageContext.servletContext.contextPath}/deposit/create" method="POST" oninput="amount.value=rangeInput.value">

    <h2>Клиенты:</h2>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Краткое название</td>
            <td>адрес</td>
            <td>Форма</td>
            <td>Выбор</td>
        </tr>
        <c:forEach items="${bigClass.clientListData.clients.values()}" var="client" varStatus="status">
            <tr valign="top">
                <td>${client.clientId}</td>
                <td>${client.shortName}</td>
                <td>${client.adress}</td>
                <td>${client.form}</td>
                <td><input type="radio" name="clientCId" checked="checked" value="${client.clientId}"> </td>

            </tr>
        </c:forEach>
    </table>

    <h2>Банки:</h2>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Название Банка/td>
            <td>БИК</td>
            <td>Выбор</td>
        </tr>
        <c:forEach items="${bigClass.bankListData.banks.values()}" var="bank" varStatus="status">
            <tr valign="top">
                <td>${bank.bankId}</td>
                <td>${bank.name}</td>
                <td>${bank.bik}</td>
                <td><input type="radio" name="bankId" checked="checked" value="${bank.bankId}"> </td>
            </tr>
        </c:forEach>
    </table>


    <table>
        <tr>
            <td align="right" >Дата открытия : </td>
            <td>
                <input type="date" name="dateTime" value="2016-01-02">
            </td>
        </tr>
        <tr>
            <td align="right" >Процент : </td>
            <td>
                <%--<input type="text" name="percent" value="10">--%>
                    <div>
                        <input type="range" id="rangeInput" name="percent" min="0" max="100" value="15">
                        <output name="amount" for="rangeInput">15</output>%
                    </div>
            </td>
        </tr>
        <tr>
            <td align="right" >Срок в месяцах : </td>
            <td>
                <input type="text" name="time" value="12">
            </td>
        </tr>
    </table>
    <input type="submit" align="center" value="Submit" style="font-size: x-large; color: chartreuse; background-color: crimson"/>
</form>

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
