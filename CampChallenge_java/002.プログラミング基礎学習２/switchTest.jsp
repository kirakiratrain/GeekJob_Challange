<%-- 
    Document   : switchTest
    Created on : 2017/02/08, 20:47:32
    Author     : Choir
    課題        :switch文を利用して、以下の処理を実現してください。
                値が1なら「one」、値が2なら「two」、それ以外は
                「想定外」と表示する処理
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int aa = 2;
    switch(aa) 
    {
        case 1:
            out.println("one");
            break;
        case 2:
            out.println("two");
            break;
        default:
            out.println("想定外");
            break;
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
