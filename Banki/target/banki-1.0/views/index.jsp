<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bank</title>
</head>
<body>
<h1 align="center">Все исправил за вечер второго дня.<br> Enjoy yourself!!! <br> Все сделал за один день. <br> Дизайн отсутствует.</h1>
<div align="center">
    <form action="deposit/view" method='get'>
        <input type='submit' value='Enter to the Bank' style="font-size: x-large; color: crimson; background-color: cyan" />
    </form>
</div>
<br />
<h2>Задание: </h2>
<br />

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
