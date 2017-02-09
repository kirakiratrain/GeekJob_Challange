<%-- 
    Document   : renketuHairetu
    Created on : 2017/02/09, 20:26:51
    Author     : Choir
    課題
    以下の順で、連想配列を作成してください。
    "1"に"AAA", "hello"に"world", "soeda"に"33", "20"に"20"
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%
    ArrayList<String> stAray = new ArrayList<String>();
    stAray.add("1");
    stAray.add("AAA");
    stAray.add("hello");
    stAray.add("world");
    stAray.add("soeda");
    stAray.add("33");
    stAray.add("20");
    stAray.add("20");
    for(int i = 0;i<8;i++)
    {
        out.println(stAray.get(i));
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
