<%--
  Created by IntelliJ IDEA.
  User: alekseysamoylov
  Date: 2/16/16
  Time: 11:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Изменение данных Банка</title>
    <meta charset="UTF-8">
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/client/edit" method="POST">
    <input type="hidden" name="id" value="${client.clientId}">
    <table>
        <tr>
            <td align="right" >Наименование Клиента : </td>
            <td>
                <input type="text" name="name" value="${client.name}">
            </td>
        </tr>
        <tr>
            <td align="right" >Сокращенное Наименование Клиента : </td>
            <td>
                <input type="text" name="shortName" value="${client.shortName}">
            </td>
        </tr>
        <tr>
            <td align="right" >Адрес : </td>
            <td>
                <input type="text" name="adress" value="${client.adress}">
            </td>
        </tr>
        <tr>
            <td align="right" >Организационно-правовая форма : </td>
            <td>
                <select size = "1" name = "form">
                    <option selected value = "${client.form}">${client.form}</option>
                    <option value = "OOO">ООО</option>
                    <option value = "ОAO">ОАО</option>
                    <option value = "3AO">ЗАО</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit" style="font-size: x-large; color: chartreuse; background-color: crimson" /></td>
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
