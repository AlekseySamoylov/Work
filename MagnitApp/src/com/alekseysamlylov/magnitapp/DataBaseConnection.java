package com.alekseysamlylov.magnitapp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.sql.*;

/*
 * Created by Aleksey Samoylov on 14.01.2016.
 */
public class DataBaseConnection {

    private static final String CLASSNAME = "oracle.jdbc.driver.OracleDriver";
    private static final String CONNECTIONPATH = "jdbc:oracle:thin:@172.20.10.7:1521:xe";
    private static final String LOGIN = "alekseysamoylov";
    private static final String PASSWORD = "89028035276";
    private static String connectionPath;
    private static String login;
    private static String password;
    private static int n;

    public static void setN(int a) {
        n = a;
    }

    public static void setConnectionPath(String connectionPath) {
        DataBaseConnection.connectionPath = connectionPath;
    }

    public static void setLogin(String login) {
        DataBaseConnection.login = login;
    }

    public static void setPassword(String password) {
        DataBaseConnection.password = password;
    }



    public void doThisExersizes2() throws ClassNotFoundException {
        System.out.println("Начал работать. Если были значения в базе, удаляю их...");
        Class.forName(CLASSNAME);
        try (Connection connection = DriverManager.getConnection(connectionPath, login, password)) {

            String sql1 = "DELETE FROM TEST";
            Statement statement = connection.createStatement();
            statement.execute(sql1);
            statement.close();

            System.out.println("Записываю значения в базу данных...");

            String sql3 = "BEGIN " +
                    "FOR v_Count IN 1..? LOOP " +
                    "INSERT INTO TEST(COLUMN1) " +
                    "VALUES (v_count); " +
                    "END LOOP; " +
                    "END;";
            CallableStatement callableStatement = connection.prepareCall(sql3);
            callableStatement.setInt(1, n);
            callableStatement.execute();

            System.out.println("Запись значений в базу данных завершена. \nНачинаю чтение данных из базы и формирование 1.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element rootElement = document.createElement("entries");
            document.appendChild(rootElement);

            Element childElement;

            Element fieldElement;

            String sql4 = "SELECT COLUMN1 FROM TEST ORDER BY COLUMN1";
            Statement statement4 = connection.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(sql4);
            while (resultSet4.next()) {
                childElement = document.createElement("entry");
                rootElement.appendChild(childElement);
                fieldElement = document.createElement("field");
                childElement.appendChild(fieldElement);
                fieldElement.appendChild(document.createTextNode(String.valueOf(resultSet4.getInt(1))));
            }
            System.out.println("Данные из базы данных прочитаны. Сохраняю 1.xml");


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");

            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("1.xml"));
            transformer.transform(domSource, streamResult);

            System.out.println("Файл 1.xml сохранен. \nНачинаю преобразование данных из 1.xml при помощи 1.xsl, для сохранения в файле 2.xml");

            Transformer transformer1 = transformerFactory.newTransformer(new StreamSource("1.xsl"));

            transformer1.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer1.setOutputProperty(OutputKeys.METHOD, "xml");

            StreamSource xmlSourse = new StreamSource("1.xml");
            StreamResult out = new StreamResult("2.xml");
            transformer1.transform(xmlSourse, out);

            System.out.println("Файл 2.xml сохранен. \nНачинаю складывать числа из 2.xml");

            XPath xPath = XPathFactory.newInstance().newXPath();
            InputSource inputSource = new InputSource("2.xml");
            Number shows = (Number) xPath.evaluate("sum(/entries/entry/@field)", inputSource, XPathConstants.NUMBER);
            System.out.println();
            System.out.println("Задание выполнено успешно!");
            System.out.println("Сумма чисел равна " + shows.intValue());
            System.out.println();
            System.out.println("Спасибо за внимание!");


        } catch (SQLException | ParserConfigurationException | TransformerException | XPathExpressionException e) {
            e.printStackTrace();
        }

    }


}
