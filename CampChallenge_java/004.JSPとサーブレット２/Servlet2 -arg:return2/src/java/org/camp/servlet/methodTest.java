/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;
import static java.lang.System.out;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author Choir
 * 課題：自分のプロフィール(名前、生年月日、自己紹介)を3行に分けて表示するユーザー定義メソッドを作り、
 * メソッドを10回呼び出して下さい
 */
public class methodTest implements Serializable
{
    private String name;
    private Date birthday;
    private String speach;
    public methodTest(){};

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
        return birthday;
    }
    public void setBirthday(Date date)
    {
        birthday = date;
    }
    public String getSpeach()
    {
          return speach;
    }
    public void setSpeach(String speach)
    {
        this.speach = speach;
    }
    
    public void ShowProfile()
    {
      
        out.println(name+"<br>");
        out.println(birthday+"<br>");
        out.println(speach+"<br>");
    }
}
