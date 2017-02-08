/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Choir
 */
public class sisokuEnzan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        //課題
        //定数と変数を宣言し、それぞれに数値を入れて四則演算を行い、
        //四則演算の結果をそれぞれ表示してください。
        
        int aa = 10;
        int bb = 2;
        final int constCC = 20;
        int ans = 0;
        
        ans = aa + (bb * 10) - constCC/aa; 
        
        System.out.println(ans);
        
    }
    
}
