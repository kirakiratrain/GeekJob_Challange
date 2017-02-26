<%-- 
    Document   : inPutFiled
    Created on : 2017/02/26, 22:30:22
    Author     : Choir
--%>

<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
<%
    request.setCharacterEncoding("Shift_JIS");
    String str = request.getParameter("txtName");
    String strID = request.getParameter("mulText");
    String strSex = request.getParameter("txtSex");
    out.println("名前："+str);
    out.println("<br>");
    out.println("趣味："+strID);
    out.println("<br>");
    out.println("性別"+strSex);
    out.println("<br>");
%>
        <h1>Hello World!!!</h1>
<%--
        以下の入力フィールドを持ったHTMLを、Javaで処理する想定で記述してください。
        ・名前（テキストボックス）、性別（ラジオボタン）、趣味（複数行テキストボックス）
--%>    
    </body>
</html>
