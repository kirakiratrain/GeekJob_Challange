<%-- 
    Document   : hairetu
    Created on : 2017/02/09, 20:11:37
    Author     : Choir
    課題
    以下の順番で、要素が格納された配列を作成してください。
    "10", "100", "soeda", "hayashi", "-20", "118", "END"
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String[] str = new String[7];
    str[0] = "10";
    str[1] = "100";
    str[2] = "soeda";
    str[3] = "hayashi";
    str[4] = "-20";
    str[5] = "118";
    str[6] = "END";
    
    for(int i =0; i < 7; i++)
    {
            out.println(str[i]);
    }
    
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
