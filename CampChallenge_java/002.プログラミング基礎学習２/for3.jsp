<%-- 
    Document   : for3
    Created on : 2017/02/09, 19:58:37
    Author     : Choir
    課題
    for文を利用して、0から100を全部足す処理を実現してください。
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int ans = 0;
    
    for(int i =0;i<101;i++)
    {
        ans += i;
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
