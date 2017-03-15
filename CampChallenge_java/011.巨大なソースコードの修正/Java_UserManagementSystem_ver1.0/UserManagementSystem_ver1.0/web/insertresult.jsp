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
    
    hs.setAttribute("DispStat", "insertResult");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前:<%=userdataBeans.getName()%><br>
        生年月日:<%= userdataBeans.getBirthday()%><br>
        種別:<%= userdataBeans.getType()%><br>
        電話番号:<%= userdataBeans.getTell()%><br>
        自己紹介:<%= userdataBeans.getComment()%><br>
        以上の内容で登録しました。<br>
        <%=JumsHelper.getInstance().home()%>
    </body>
    
</html>
