<%-- 
    Document   : speachTestResult
    Created on : 2017/02/15, 6:24:45
    Author     : Choir
--%>
<%@page import="org.camp.servlet.methodTest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            methodTest speachData = (methodTest)request.getAttribute("SPEACH_DATA");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(speachData != null)
            {
                for(int i =0;i<10;i++)
                {
                    speachData.ShowProfile();
                }
            }
        %>
        
    </body>
</html>
