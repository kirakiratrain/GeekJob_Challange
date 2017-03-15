<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans"%>
<%
    HttpSession hs = request.getSession();
    //タスク3
    UserDataBeans userdataBeans = new UserDataBeans();
            
    userdataBeans.setName((String)hs.getAttribute("name"));
    userdataBeans.setBirthday(hs.getAttribute("year")+"年"+hs.getAttribute("month")+"月"+hs.getAttribute("day")+"日");
    userdataBeans.setType((String)hs.getAttribute("type"));
    userdataBeans.setTell((String)hs.getAttribute("tell"));
    userdataBeans.setComment((String)hs.getAttribute("comment"));
    
    //タスク5
    hs.setAttribute("DispStat", "insertConfirm");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <% if(!userdataBeans.getName().equals("")){ %>
        <h1>登録確認</h1>
        名前:<%=userdataBeans.getName()%><br>
        生年月日:<%= userdataBeans.getBirthday()%><br>
        種別:<%= userdataBeans.getType()%><br>
        電話番号:<%= userdataBeans.getTell()%><br>
        自己紹介:<%= userdataBeans.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="submit" name="yes" value="はい">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
            </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
        </form>
    </body>
</html>
