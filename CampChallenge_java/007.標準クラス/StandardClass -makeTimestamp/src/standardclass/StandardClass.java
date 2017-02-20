/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package standardclass;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 *
 * @author Choir
 * 2016年1月1日 0時0分0秒のタイムスタンプを作成し、表示してください。
 */
public class StandardClass {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws ParseException
    {
        // TODO code application logic here
        //2016年1月1日 0時0分0秒のタイムスタンプを作成し、表示してください。
        System.out.println("開始");
        //System.out.println("¥r¥n");
        
        // 変換対象の日付文字列
        String dateStr = "20160101 00:00:00";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

        // Date型変換
        Date formatDate = sdf.parse(dateStr);
        System.out.println(formatDate.getTime());
        
        //現在の日時を「年-月-日 時:分:秒」で表示してください。
        Date now = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年mm月dd日　HH時:mm分:ss秒");
        System.out.println(sdf.format(now));
        
    }

    
}
