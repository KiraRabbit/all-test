package utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("YYYY-MM-DD");// 多态
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = (Date) calendar.getTime();
        String format = df.format(date);
        System.out.println(format);

    }


}
