/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

/**
 *
 * @author Choir
 */
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

public class DateUtil 
{
    
    public static java.sql.Date toSqlDate(Date date) 
    {
        return new java.sql.Date(date.getTime());
    }
    public static Date toDate(String str) throws ParseException
    {
        Date  date = DateFormat.getDateInstance().parse(str);
        return date;
    }
}
