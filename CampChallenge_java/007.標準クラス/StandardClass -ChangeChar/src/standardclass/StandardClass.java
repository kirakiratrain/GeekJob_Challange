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
        
        //課題：文字の入れ替え
        //以下の文章の「I」⇒「い」に、「U」⇒「う」に入れ替える処理を作成し、
        //結果を表示してください。「きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます」
        String str = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        str.replace('I', 'い');
        str.replace('U', 'う');
        System.out.println(str);
        
    }

}
