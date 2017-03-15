<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans"%>
<%
    HttpSession hs = request.getSession();
    UserDataBeans userdataBeans = new UserDataBeans();
    
    if(hs.getAttribute("DispStat").equals("Err") || hs.getAttribute("DispStat").equals("insertConfirm"))
    {
        if(hs.getAttribute("name") != null) userdataBeans.setName((String)hs.getAttribute("name"));
        if(hs.getAttribute("year") != null ) userdataBeans.setYear((String)hs.getAttribute("year"));
        if(hs.getAttribute("month") != null) userdataBeans.setMonth((String)hs.getAttribute("month"));
        if(hs.getAttribute("day") != null) userdataBeans.setDay((String)hs.getAttribute("day"));

        if(hs.getAttribute("year") != null && hs.getAttribute("month") != null && hs.getAttribute("day") != null)
        {
            userdataBeans.setBirthday(hs.getAttribute("year")+"年"+hs.getAttribute("month")+"月"+hs.getAttribute("day")+"日");
        }
        if(hs.getAttribute("type") != null) userdataBeans.setType((String)hs.getAttribute("type"));
        if(hs.getAttribute("tell") != null) userdataBeans.setTell((String)hs.getAttribute("tell"));
        if(hs.getAttribute("comment") != null)
        {
            userdataBeans.setComment((String)hs.getAttribute("comment"));
        }
    }
    hs.setAttribute("DispStat", "insert");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<%=userdataBeans.getName()%>">
        <br><br>

        生年月日:　
        <select name="year">
            <%
            String valueYear = "----";
            if(!userdataBeans.getYear().equals(""))
            {
                valueYear = userdataBeans.getYear();
            }
            %>
            <option value="<%=valueYear%>"><%=valueYear%></option>
1            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"> <%=i%> </option>
            <% } %>
        </select>年
        <select name="month">
            <%
            String valueMonth = "--";
            if(!userdataBeans.getMonth().equals(""))
            {
                valueMonth = userdataBeans.getMonth();
            }
            %>
            <option value="<%=valueMonth%>"><%=valueMonth%></option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <%
            String valueDay = "--";
            if(!userdataBeans.getDay().equals(""))
            {
                valueDay = userdataBeans.getDay();
            }
            %>
            <option value="<%=valueDay%>"><%=valueDay%></option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <%
            String chkVal1,chkVal2,chkVal3;
            chkVal1 = chkVal2 = chkVal3 = "";   //初期化
            if(userdataBeans.getType().equals("1"))     chkVal1 = "checked";
            else if(userdataBeans.getType().equals("2"))     chkVal2 = "checked";
            else if(userdataBeans.getType().equals("3"))   chkVal3 = "checked";
            else chkVal1 = "checked";
        %>
        <input type="radio" name="type" value="1" <%=chkVal1%>>エンジニア<br>
        <input type="radio" name="type" value="2" <%=chkVal2%>>営業<br>
        <input type="radio" name="type" value="3" <%=chkVal3%>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%=userdataBeans.getTell()%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" value="" rows=10 cols=50 style="resize:none" wrap="hard"><%=userdataBeans.getComment()%></textarea><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
