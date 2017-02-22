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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

        //課題：ファイルの書き出しと保存
        //ファイルに自己紹介を書き出し、保存してください。
        try
        {
            File file = new File("/Users/Choir/NetBeansProjects/test.txt");
            //File file = new File("-/");
            FileWriter filewriter = new FileWriter(file);
            if(checkFileexists(file))
            {
                filewriter.write("名前：伊藤雄一");
                String strBR = System.getProperty("line.separator");
                filewriter.write(strBR);
                filewriter.write("出身：宮城");
                filewriter.write(strBR);
                filewriter.write("年齢：28¥n");
                filewriter.write("年齢：28¥n");
                
                filewriter.close();
            }
            else
            {
                System.out.println("write Error");
            }
            
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        


    }
    
    private static boolean checkFileexists(File file)
    {
        if(file.exists())
        {
            //ファイルである事、書き込み可能である事を確認する
            if(file.isFile() && file.canWrite())
            {
                return true;
            }
        }
        
        return false;
    }
}
