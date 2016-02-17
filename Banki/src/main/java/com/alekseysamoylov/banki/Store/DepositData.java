package com.alekseysamoylov.banki.Store;

import com.alekseysamoylov.banki.models.Deposit;
import com.alekseysamoylov.banki.service.ConnectionJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by alekseysamoylov on 2/16/16.
 */
public class DepositData {

	private static final DepositData INSTANCE = new DepositData();

	public static DepositData getInstance() {
		return INSTANCE;
	}


	private final ConcurrentHashMap<Integer, Deposit> deposits = new ConcurrentHashMap<Integer, Deposit>();


	public Collection<Deposit> values(){
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.deposits.values();
	}

	public Deposit getDeposit(int id){
		Deposit deposit = null;
		try(Connection connection = ConnectionJdbc.getConnection()){
			String sql =  "SELECT BANKCLIENTS.BANKCLIENTID, BANKS.BANKID, " +
					"BANKCLIENTS.SHORTNAME, " +
					"BANKS.NAME, DEPOSITS.DATETIME, " +
					"DEPOSITS.PERCENT, DEPOSITS.TIME " +
					"from DEPOSITS " +
					"JOIN BANKS " +
					"ON DEPOSITS.BANKID = BANKS.BANKID " +
					"JOIN BANKCLIENTS " +
					"ON DEPOSITS.CLIENTID = BANKCLIENTS.BANKCLIENTID " +
					"WHERE DEPOSITS.DEPOSITID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				deposit = new Deposit(id, resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5),resultSet.getInt(6), resultSet.getInt(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deposit;
	}

	public void editDeposit(int id, String dateTime, String percent, String time){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy");
		try(Connection connection = ConnectionJdbc.getConnection()){
			Date date = formatter.parse(dateTime);
			String sql = "UPDATE DEPOSITS SET DATETIME=?, PERCENT=?, TIME=? WHERE DEPOSITID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			System.out.println(formatter2.format(date));
			preparedStatement.setString(1, formatter2.format(date));
			preparedStatement.setInt(2, Integer.valueOf(percent));
			preparedStatement.setInt(3, Integer.valueOf(time));
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
	}


	public void createDeposit(int clientId, int bankId, String dateTime, int percent, int time){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy");
		try(Connection connection = ConnectionJdbc.getConnection()){
			Date date = formatter.parse(dateTime);
			String sql = "INSERT INTO DEPOSITS(CLIENTID, BANKID, DATETIME, PERCENT, TIME) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, clientId);
			preparedStatement.setInt(2, bankId);
			System.out.println(formatter2.format(date));
			preparedStatement.setString(3, formatter2.format(date));
			preparedStatement.setInt(4, percent);
			preparedStatement.setInt(5, time);
			preparedStatement.executeUpdate();
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
	}


	public void add(final Deposit deposit){
		this.deposits.put(deposit.getDepositId(), deposit);
	}
	public void edit(final Deposit deposit){
		this.deposits.replace(deposit.getDepositId(), deposit);
	}
	public void delete(final int id){
		this.deposits.remove(id);
	}
	public Deposit get(final int id){
		return this.deposits.get(id);
	}


}
