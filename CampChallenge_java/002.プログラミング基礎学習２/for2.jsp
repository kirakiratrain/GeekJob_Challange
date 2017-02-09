<%-- 
    Document   : for2
    Created on : 2017/02/09, 19:49:52
    Author     : Choir
    課題
    for文を利用して、"A"を30個連結する処理を実現してください。
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String ans = "A";
    
    for(int i =0;i<30;i++)
    {
        ans += "A";
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
