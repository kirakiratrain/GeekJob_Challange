<%-- 
    Document   : Hello
    Created on : 2017/02/07, 22:21:31
    Author     : Choir
--%>

<%@page import="jums.JumsHelper" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World.</h1>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
