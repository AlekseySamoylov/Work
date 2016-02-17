package com.alekseysamoylov.banki.testsql;

import com.alekseysamoylov.banki.Store.DepositData;
import com.alekseysamoylov.banki.models.Deposit;
import com.alekseysamoylov.banki.service.ConnectionJdbc;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by alekseysamoylov on 2/16/16.
 */
public class GetDepositsTest {

    @Test
    public void values(){
        ConcurrentHashMap<Integer, Deposit> deposits = new ConcurrentHashMap<Integer, Deposit>();
        try(Connection connection = ConnectionJdbc.getConnection()){
            String sql = "SELECT DEPOSITS.DEPOSITID, BANKCLIENTS.BANKCLIENTID, BANKS.BANKID, " +
                    "BANKCLIENTS.SHORTNAME, " +
                    "BANKS.NAME, DEPOSITS.DATETIME, " +
                    "DEPOSITS.PERCENT, DEPOSITS.TIME " +
                    "from DEPOSITS " +
                    "JOIN BANKS " +
                    "ON DEPOSITS.BANKID = BANKS.BANKID " +
                    "JOIN BANKCLIENTS " +
                    "ON DEPOSITS.CLIENTID = BANKCLIENTS.BANKCLIENTID";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                deposits.put(resultSet.getInt(1), new Deposit(resultSet.getInt(1),
                        resultSet.getInt(2), resultSet.getInt(3),
                        resultSet.getString(4), resultSet.getString(5),
                        resultSet.getDate(6).toString(), resultSet.getInt(7),
                        resultSet.getInt(8)));
                System.out.println(resultSet.getInt(1) + " " +
                        resultSet.getInt(2) + " " + resultSet.getInt(3) + " " +
                        resultSet.getString(4) + " " + resultSet.getString(5) + " " +
                        resultSet.getDate(6).toString() + " " + resultSet.getInt(7) + " " +
                        resultSet.getInt(8));
                System.out.println(deposits.values().toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DepositData INSTANCE = DepositData.getInstance();
        Collection<Deposit> collection = INSTANCE.values();
        for (Deposit deposit :
                collection) {
            System.out.println(deposit.getBankName());
        }
    }
}
