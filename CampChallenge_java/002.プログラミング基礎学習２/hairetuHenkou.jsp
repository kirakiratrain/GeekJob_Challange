<%-- 
    Document   : hairetuHenkou
    Created on : 2017/02/09, 20:21:15
    Author     : Choir
    課題
    課題「配列の作成」で作成した配列の"soeda"を"33"に変更してください。
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
        if(str[i].equals("soeda"))
        {
            str[i] = "33";
        }
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
