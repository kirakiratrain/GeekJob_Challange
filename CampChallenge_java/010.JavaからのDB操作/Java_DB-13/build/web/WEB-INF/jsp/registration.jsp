<%-- 
    Document   : registration
    Created on : 2017/03/07, 16:36:34
    Author     : Choir
        ユーザ情報登録テーブル:merchandise_info
        ・商品名 Name
        ・商品ID ID
        ・入庫 InItem
        ・出庫 OutItem
        ・在庫 Stock
        ・日付 Date
--%>

<%
//ブラウザのキャッシュを無効にする。
// Last-Modified(最終更新日) : 本日
// Expires(有効期限)         : 過去日(1970/01/01)
// pragma no-cache           : HTTP1.0仕様に基づく「キャッシュ無効指示」
// Cache-Control no-cache    : HTTP1.1仕様に基づく「キャッシュ無効指示」

//java.util.Calendar objCal1=java.util.Calendar.getInstance();
//java.util.Calendar objCal2=java.util.Calendar.getInstance();
//objCal2.set(1970,0,1,0,0,0);
//response.setDateHeader("Last-Modified",objCal1.getTime().getTime());
//response.setDateHeader("Expires",objCal2.getTime().getTime());
    Object status = session.getAttribute("status");

    if(status == "Login_out")
    {
        response.sendRedirect("/Java_DB/Servlet_Login");
        return;
    }

%>


<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
         <div>商品の登録</div>
         <form action="Servlet_InsertData" method="post">
         商品名：<input type="text" name="NAME">
         商品ID：<input type="text" name="ID">
         入庫：<input type="text" name="INITEM">
         出庫：<input type="text" name="OUTITEM">
         在庫：<input type="text" name="STOCK">
         日付：<input type="text" name="DATE">
         <input type="submit" value="送信">
     </form>
     <div>商品一覧の表示</div>
     <form action="Servlet_AllList" method="post">
         <input type="submit" value="一覧表示">
         <br>
     </form>
     <form action="Servlet_Logout" method="post">
         <input type="submit" value="ログアウト">
     </form>
    </body>
</html>
