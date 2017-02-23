<%-- 
    Document   : blackJackMain
    Created on : 2017/02/16, 22:55:08
    Author     : Choir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.objectStudy2.Human" %>
<%@page import="org.objectStudy2.Dealer" %>
<%@page import="org.objectStudy2.User" %>
<%@page import="java.util.ArrayList" %>
<%
    out.println("ブラックジャック開始");
    
    out.println("初期化");
    out.println("<br>");
    Dealer dealer = new Dealer();
    User   user   = new User();
    out.println("カードを引く");
    out.println("<br>");
    ArrayList<Integer> cards = new ArrayList<Integer>();
    
    //Userが引く
    cards = dealer.deal();
    user.setCard(cards);
    cards.clear();
    
    //Dealerが引く
    cards = dealer.deal();
    dealer.setCard(cards);
    
    boolean pass = false;
    while(pass == false)
    {
        //checkSum
        boolean isHit = user.checkSum();
        
        //まだ引ける場合
        if(isHit)
        {
            //引くか引かないか判断
            //入力待ち
            user.setCard(dealer.hit());
        }
        else
        {
            pass = true;
        }
    }
    
    int userAns     = 21 - user.open();
    int dealerAns   = 21 - dealer.open();
    int judge = 0;      //0 引き分け　１：勝ち　２：負け
    
    //ブラックジャックの場合
    if(userAns == 0 || dealerAns == 0)
    {
        if(userAns == 0 && dealerAns == 0)
        {
            judge = 0;            //ドロー
        }
        else if(userAns == 0 )
        {
            judge = 1;           //勝ち
        }
        else if( dealerAns == 0)
        {
            judge = 2;          //負け
        }
    }
    //User:Burst  Dealer:Burst
    else if(userAns < 0 || dealerAns < 0)
    {
        //どっちもバースト
        if(userAns < 0 && dealerAns < 0)
        {
            judge = 0;      //ドロー
        }
        else if(userAns < 0)
        {
            judge = 2;      //負け
        }
        else if(dealerAns < 0)
        {
            judge = 1;       //勝ち
        }
    }
    //どちらも２１以下　の場合
    else 
    {
        //比較
        int cmpAns = userAns - dealerAns;
        if(cmpAns > 0)
        {
            judge = 1;  //勝ち
        }
        else
        {
            judge = 2;   //負け
        }
    }
    switch(judge)
    {
        case 0:
            out.println("ドロー");
            out.println("<br>");
            break;
        case 1:
            out.println("勝ち");
            out.println("<br>");
            break;
        case 2:
            out.println("負け");
            out.println("<br>");
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
    </body>
</html>

