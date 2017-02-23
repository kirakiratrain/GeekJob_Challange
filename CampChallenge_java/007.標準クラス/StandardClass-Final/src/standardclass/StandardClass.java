/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package standardclass;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
//Logger
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.LogRecord;

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

        //課題：標準クラスを利用して処理を作成
        /*
        紹介していないJAVAの標準クラスを利用して、処理を作成してください。

        講義では紹介されていないJAVAの標準クラスはたくさん存在します。
        １つJAVAの標準クラスを選び、実際にロジックを作成してみてください。
        また、この処理を作成するに当たり、下記を必ず実装してください。
        ①処理の経過を書き込むログファイルを作成する。
        ②処理の開始、終了のタイミングで、ログファイルに開始・終了の書き込みを行う。
        ③書き込む内容は、「日時　状況（開始・終了）」の形式で書き込む。
        ④最後に、ログファイルを読み込み、その内容を表示してください。
        
        */
        
        //ログクラス作成
        String loggerName = StandardClass.class.getName();
        Logger logger = Logger.getLogger(loggerName);
        
        //ファイルハンドル作成
        try{
            String filepath = "/Users/Choir/NetBeansProjects/log.txt";
            //String filepath = "-/NetBeansProjects/log.txt";
            //引数true:追加書き込み許可　false:上書き
            FileHandler fileHandler = new FileHandler(filepath,false);
            //書式のデフォルトはXMLなので、見やすくするためにSimpleFormatter()で普通の出力を設定

            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
           
            logger.setUseParentHandlers(false);
            Date date_s = new Date();
            SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
            String strFormat = timeFormat.format(date_s); // format(d)のdは、Date d = new Date();のd
            //strFormat += strFormat +":開始";
            strFormat = ":開始";
            logger.log(Level.INFO, strFormat);
            
            
            Date date_e = new Date();
            strFormat = timeFormat.format(date_e); 
            //strFormat += strFormat +":終了";
            strFormat = ":終了";
            logger.log(Level.INFO,strFormat);
            
        }
        catch(IOException e)
        {
            logger.log(Level.FINER, "エラー発生", e);
            System.out.println("エラー");
        }
        
        try
        {
            FileReader file = new FileReader("/Users/Choir/NetBeansProjects/log.txt");
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
    
   private final SimpleDateFormat dateFormat =
         new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

   public String format(LogRecord logRecord) {
      final StringBuffer stringBuffer = new StringBuffer();

      stringBuffer.append(this.dateFormat.format(new Date(logRecord.getMillis())));
      stringBuffer.append(" ");

//      Level level = logRecord.getLevel();
//      if (level == Level.FINEST) {
//         stringBuffer.append("FINEST");
//      } else if (level == Level.FINER) {
//         stringBuffer.append("FINER ");
//      } else if (level == Level.FINE) {
//         stringBuffer.append("FINE ");
//      } else if (level == Level.CONFIG) {
//         stringBuffer.append("CONFIG");
//      } else if (level == Level.INFO) {
//         stringBuffer.append("INFO ");
//      } else if (level == Level.WARNING) {
//         stringBuffer.append("WARN ");
//      } else if (level == Level.SEVERE) {
//         stringBuffer.append("SEVERE");
//      } else {
//         stringBuffer.append(Integer.toString(logRecord.getLevel().intValue()));
//         stringBuffer.append(" ");
//      }
//      stringBuffer.append(" ");
      stringBuffer.append(" - ");
      stringBuffer.append(logRecord.getMessage());
      stringBuffer.append("\n");

      return stringBuffer.toString();
   }
}
