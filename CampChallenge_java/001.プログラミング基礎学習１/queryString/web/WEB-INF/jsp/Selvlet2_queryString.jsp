<%-- 
    Document   : Selvlet2_queryString
    Created on : 2017/02/24, 21:20:13
    Author     : Choir
--%>

<%@page import="org.camp.servlet.ProfileData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            String  strTypeAll = (String)request.getAttribute("TypeNames");
            String strType = (String)request.getAttribute("Type");
            int CostAll = (Integer)request.getAttribute("AllCost");
            int cost = (Integer)request.getAttribute("Cost");
            int Num = (Integer)request.getAttribute("Num");
            
            out.println(strTypeAll);
            out.println("<br>");
            out.println("<br>");
            out.println("種別："+ strType + " 総額：" + CostAll+"　一個あたりの値段："+cost);
            out.println("<br>");
            /* ③3000円以上購入で4%、5000円以上購入で5%のポイントが付きます。
               購入額に応じたポイントの表示を行ってください。
            */
            int point = 0;
            if(CostAll >= 5000)
            {
                point = (CostAll /100)*5;
            }
            else if(CostAll >= 3000)
            {
                point = (CostAll /100)*3;
            }
            else
            {
                point = 0;
            }
            out.println("ポイント："+point);
            out.println("<br>");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

        %>

    </body>
</html>