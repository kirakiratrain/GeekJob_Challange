/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.objectStudy.classMake;

/**
 *
 * @author Choir
 *課題　クラス作成：
 * 以下の機能を持つクラスを作成してください。
・パブリックな２つの変数
・２つの変数に値を設定するパブリックなメソッド
・２つの変数の中身をprintするパブリックなメソッド
 */
public class classMake 
{
    public int hdd;
    public String color;
    public classMake()
    {
        hdd =  120;
        color = "RED";
    };
    
    public void sethdd(int setNum)
    {
        this.hdd = setNum;
    }
    
    public void setcolor(String setColor)
    {
        this.color = setColor;
    }
    
    public void view()
    {
        System.out.println(hdd);
        System.out.println("<br>");
        System.out.println(color);
        System.out.println("<br>");
    }
    
}
