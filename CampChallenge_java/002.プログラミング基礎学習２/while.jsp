<%-- 
    Document   : while
    Created on : 2017/02/09, 20:02:29
    Author     : Choir
    課題
    while文を利用して、以下の処理を実現してください。
    1000を2で割り続け、100より小さくなったらループを抜ける処理
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int ans = 1000;
    
    while(ans > 100)
    {
        ans /= 2;
        
    }
    
    out.println(ans);
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
