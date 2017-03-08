/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.database.connect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Choir
 */
public class Servlet_Login extends Servlet_Session 
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        
        response.setContentType("text/html;charset=UTF-8");
        
        super.processRequest(request,response);
        /* �ۑ�F�݌ɊǗ��V�X�e���̍쐬
        �ȉ��̋@�\�𖞂������W�b�N���쐬���Ă��������B
        �݌ɊǗ��V�X�e�����쐬���܂��B
        �܂��ADB�Ƀ��[�U�[���Ǘ��e�[�u���ƁA���i���o�^�e�[�u�����쐬���Ă��������B
        ���̏�ŁA���L�@�\���������Ă��������B
        1���[�U�[�̃��O�C���E���O�A�E�g�@�\
        2���i���o�^�@�\
        3���i�ꗗ�@�\
        ���e�e�[�u���̍\���͊e���̑z���ō���Ă݂Ă��������B
        ���[�U�[���Ǘ��e�[�u���@UserInfo
        �E���[�U�� UserID
        �E�p�X���[�h Pass
        
        ���[�U���o�^�e�[�u��:merchandise_info
        �E���i�� Name
        �E���iID ID
        �E���� InItem
        �E�o�� OutItem
        �E�݌� Stock
        �E���t Date
        */
      
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>���O�C���y�[�W</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>���O�C�����</h1>");

        //HttpSession session = request.getSession(true);

        /* �F�؎��s����Ăяo���ꂽ�̂��ǂ��� */
        Object status = m_session.getAttribute("LoginStat");

        if (getLoginStat() == "Login_fail")
        {
          out.println("<p>�F�؂Ɏ��s���܂���</p>");
          out.println("<p>�ēx���[�U�[���ƃp�X���[�h����͂��ĉ�����</p>");
          setLoginStat(null);
          
        }
        else if(getLoginStat() == "Login_out")
        {
            //���O�A�E�g���Ă�����
            setLoginStat(null);
            //session.setAttribute("status", null);
            // �Z�b�V�����̖�����
            m_session.invalidate();
        }
        else if(getLoginStat() == null )
        {
            //�������
        }
        //���O�C�����Ă��Ȃ����
        out.println("<form method=\"POST\" action=\"Servlet_LoginCheck\" name=\"loginform\">");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>���[�U�[��</td>");
        out.println("<td><input type=\"text\" name=\"USER_ID\" size=\"32\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>�p�X���[�h</td>");
        out.println("<td><input type=\"password\" name=\"PASS\" size=\"32\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><input type=\"submit\" value=\"login\"></td>");
        out.println("<td><input type=\"reset\" value=\"reset\"></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
       
  }

      
        

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
