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
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/deposit/edit" method="POST" oninput="amount.value=rangeInput.value">
    <input type="hidden" name="id" value="${bigClass.deposit.depositId}">

    <table>
        <tr>
            <td align="right" >Изменить данные организации :</td>
            <td><a href="${pageContext.servletContext.contextPath}/client/edit?id=${bigClass.deposit.clientId}">${bigClass.deposit.clientShortName} </a></td>
        </tr>
        <tr>
            <td align="right" >Изменить данные Банка :</td>
            <td><a href="${pageContext.servletContext.contextPath}/bank/edit?id=${bigClass.deposit.bankId}">${bigClass.deposit.bankName} </a> </td>

        </tr>
        <tr>
            <td align="right" >Дата открытия : </td>
            <td>
                <input type="date" name="dateTime" value="${bigClass.deposit.dateTime}">
            </td>
        </tr>
        <tr>
            <td align="right" >Процент : </td>
            <td>
                <%--<input type="text" name="percent" value="${bigClass.deposit.percent}">--%>
                <div>
                    <input type="range" id="rangeInput" name="percent" min="0" max="100" value="${bigClass.deposit.percent}">
                    <output name="amount" for="rangeInput">${bigClass.deposit.percent}</output>%
                </div>

            </td>
        </tr>
        <tr>
            <td align="right" >Срок в месяцах : </td>
            <td>
                <input type="text" name="time" value="${bigClass.deposit.creditTime}">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit" style="font-size: x-large; color: chartreuse; background-color: crimson"/></td>
        </tr>
    </table>
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
