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
import java.io.FileReader;
import java.io.BufferedReader;
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

        //課題：ファイルの読み出しと表示
        //ファイルから自己紹介を読み出し、表示してください。
        try
        {
            FileReader file = new FileReader("/Users/Choir/NetBeansProjects/test.txt");
            BufferedReader br = new BufferedReader(file);
            
            String readline;
            int cnt = 0;
            while((readline = br.readLine())!= null)
            {
                System.out.println(readline);
            }
          
            br.close();
            file.close();
            
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
