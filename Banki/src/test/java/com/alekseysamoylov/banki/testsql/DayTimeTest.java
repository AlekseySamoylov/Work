package com.alekseysamoylov.banki.testsql;

import com.alekseysamoylov.banki.Store.DepositData;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alekseysamoylov on 2/17/16.
 */
public class DayTimeTest {


    @Test
    public void testFormatTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy");

        String dateInString = "2015-01-10 00:00:00.0";
        Date date;
        try {

            date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter2.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dateInSql(){
        DepositData depositData = new DepositData();
        depositData.editDeposit(1, "2015-05-10 00:00:00.0", "16", "12");
    }
}