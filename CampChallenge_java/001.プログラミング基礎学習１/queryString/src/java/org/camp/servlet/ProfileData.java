/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.util.Date;
/**
 *
 * @author Choir
 * 課題：引数２
 * 戻り値としてある人物のid(数値),名前,生年月日、住所を返却するメソッドを作成し、
 * 受け取った後はid以外の値を表示する
 */

public class ProfileData
{
    public int     id;
    public String  name;
    public Date    birthDay;
    public String  adress;
     
    public ProfileData(){};
    
    public int getID()
    {
          return this.id;
    }
    public void setID(int num)
    {
        this.id = num;
    }
    
    public String getName()
    {
          return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public Date getBirthday()
    {
        return birthDay;
    }
    public void setBirthday(Date date)
    {
        birthDay = date;
    }
    public String getAdress()
    {
          return adress;
    }
    public void setAdress(String adr)
    {
        this.adress = adr;
    }
    
}
