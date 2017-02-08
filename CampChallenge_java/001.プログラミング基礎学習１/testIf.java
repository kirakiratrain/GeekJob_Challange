/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Choir
 */
public class testIf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        //変数を宣言し、その変数の中身によって以下の表示を行ってください。
        //⇒値が 1 なら「１です！」
        //⇒値が 2 なら「プログラミングキャンプ！」
        //⇒それ以外なら「その他です！」
        
        int val = 3;
        
        if(val == 1)
        {
            System.out.println("1です");
        }
        else if(val == 2)
        {
            System.out.println("プログラミングキャンプ！");   
        }
        else
        {
            System.out.println("その他です");   
        }
       
        
    }
    
}
