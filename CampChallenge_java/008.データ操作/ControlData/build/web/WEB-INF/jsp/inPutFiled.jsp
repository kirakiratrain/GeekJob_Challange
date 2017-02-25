<%-- 
    Document   : inPutFiled
    Created on : 2017/02/25, 9:50:49
    Author     : Choir
--%>

<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
<%--
        以下の入力フィールドを持ったHTMLを、Javaで処理する想定で記述してください。
        ・名前（テキストボックス）、性別（ラジオボタン）、趣味（複数行テキストボックス）
--%>    
     <form action="/WEB-NIF/jsp/inPutFiled.jsp" method="post">
         名前：<input type="text" name="txtName">
         性別：<input type="radio" name="txtSex">
         <br>
         趣味：<textarea name="mulText"></textarea>
         <br>
         <input type="submit" value="送信">
     </form>
    </body>
</html>
