/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package standardclass;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.sql.Timestamp;

/**
 *
 * @author Choir 2016年1月1日 0時0分0秒のタイムスタンプを作成し、表示してください。
 */
public class StandardClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        //2016年1月1日 0時0分0秒のタイムスタンプを作成し、表示してください。
        System.out.println("開始");
        //System.out.println(yy + "年-" + MM + "月-" + DD + "日 " + hh +"時:" +mm+ "分:" +ss+ "秒" );

        //2015年1月1日 0時0分0秒と2015年12月31日 23時59分59秒の差（ミリ秒）を表示してください。
        //SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //Date dateTo = null;
        //Date dateFrom = null;
        //try
        //{
        //    dateFrom = sdf4.parse("2015/01/01 00:00:00");
        //   dateTo =   sdf4.parse("2015/12/31 23:59:59");
        //}
        //catch(ParseException e)
        //{
        //   e.printStackTrace();     
        //}
        //long dateTimeTo = dateTo.getTime();
        //long dateTimeFrom = dateFrom.getTime();
        //long diff = ( dateTimeTo - dateTimeFrom);
        //System.out.println(diff);
        //課題：自分の氏名について、バイト数と文字数を取得して、表示してください。
        String strMyName = "伊藤雄一";
        int length = strMyName.length();
        System.out.println("伊藤雄一");
        System.out.println("長さ:" + "伊藤雄一".length());
        System.out.println("サイズ:" + "伊藤雄一".getBytes().length);

    }

}
