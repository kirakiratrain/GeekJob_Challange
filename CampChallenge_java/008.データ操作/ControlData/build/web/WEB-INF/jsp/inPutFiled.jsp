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
        �ȉ��̓��̓t�B�[���h��������HTML���AJava�ŏ�������z��ŋL�q���Ă��������B
        �E���O�i�e�L�X�g�{�b�N�X�j�A���ʁi���W�I�{�^���j�A��i�����s�e�L�X�g�{�b�N�X�j
--%>    
     <form action="/WEB-NIF/jsp/inPutFiled.jsp" method="post">
         ���O�F<input type="text" name="txtName">
         ���ʁF<input type="radio" name="txtSex">
         <br>
         ��F<textarea name="mulText"></textarea>
         <br>
         <input type="submit" value="���M">
     </form>
    </body>
</html>
