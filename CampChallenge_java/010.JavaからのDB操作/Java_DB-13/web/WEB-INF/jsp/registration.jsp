<%-- 
    Document   : registration
    Created on : 2017/03/07, 16:36:34
    Author     : Choir
        ���[�U���o�^�e�[�u��:merchandise_info
        �E���i�� Name
        �E���iID ID
        �E���� InItem
        �E�o�� OutItem
        �E�݌� Stock
        �E���t Date
--%>

<%
//�u���E�U�̃L���b�V���𖳌��ɂ���B
// Last-Modified(�ŏI�X�V��) : �{��
// Expires(�L������)         : �ߋ���(1970/01/01)
// pragma no-cache           : HTTP1.0�d�l�Ɋ�Â��u�L���b�V�������w���v
// Cache-Control no-cache    : HTTP1.1�d�l�Ɋ�Â��u�L���b�V�������w���v

//java.util.Calendar objCal1=java.util.Calendar.getInstance();
//java.util.Calendar objCal2=java.util.Calendar.getInstance();
//objCal2.set(1970,0,1,0,0,0);
//response.setDateHeader("Last-Modified",objCal1.getTime().getTime());
//response.setDateHeader("Expires",objCal2.getTime().getTime());
    Object status = session.getAttribute("status");

    if(status == "Login_out")
    {
        response.sendRedirect("/Java_DB/Servlet_Login");
        return;
    }

%>


<%@page contentType="text/html" pageEncoding="Shift_JIS"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
        <title>JSP Page</title>
    </head>
    <body>
         <div>���i�̓o�^</div>
         <form action="Servlet_InsertData" method="post">
         ���i���F<input type="text" name="NAME">
         ���iID�F<input type="text" name="ID">
         ���ɁF<input type="text" name="INITEM">
         �o�ɁF<input type="text" name="OUTITEM">
         �݌ɁF<input type="text" name="STOCK">
         ���t�F<input type="text" name="DATE">
         <input type="submit" value="���M">
     </form>
     <div>���i�ꗗ�̕\��</div>
     <form action="Servlet_AllList" method="post">
         <input type="submit" value="�ꗗ�\��">
         <br>
     </form>
     <form action="Servlet_Logout" method="post">
         <input type="submit" value="���O�A�E�g">
     </form>
    </body>
</html>
