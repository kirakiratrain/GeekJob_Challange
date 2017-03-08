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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Choir ���i�̈ꗗ��\�����܂�
 */
public class Servlet_AllList extends Servlet_Session
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

         ���[�U���o�^�e�[�u��:merchandise_info
        �E���i�� Name
        �E���iID ID
        �E���� InItem
        �E�o�� OutItem
        �E�݌� Stock
        �E���t Date
         */
        //DB
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;

        response.setContentType("text/html;charset=UTF-8");
        
        request.setCharacterEncoding("UTF-8");

        //�t�H�[�����瑗��ꂽ������̎擾
        //request.setCharacterEncoding("Shift_JIS");

        PrintWriter out = response.getWriter();
        
        if(getLoginStat() != "Login_OK")
        {
            response.sendRedirect("/Java_DB/Servlet_Login");
            return;
        }
        
        try 
        {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db", "root", "root");

            String sql = "Select * from merchandise_info";

            db_st = db_con.prepareStatement(sql);
            db_data = db_st.executeQuery();
            /*
            ���[�U���o�^�e�[�u��:merchandise_info
            �E���i�� Name
            �E���iID ID
            �E���� InItem
            �E�o�� OutItem
            �E�݌� Stock
            �E���t Date
             */

            while (db_data.next()) 
            {
                out.print("���i��:" + db_data.getString("Name") + "<br>");
                String strID = db_data.getString("ID");
                out.println("���iID:" + strID + "<br>");
                out.print("InItem:" + db_data.getString("InItem") + "<br>");
                out.print("OutItem:" + db_data.getString("OutItem") + "<br>");
                out.print("Date:" + db_data.getString("Date") + "<br>");
                out.print("<br>");
            }
            //TODO �߂�{�^�����쐬�G�@�o�^��ʂɖ߂�B

            db_con.close();
            db_st.close();
            db_data.close();
        } catch (SQLException e_sql) {

            out.println("�f�[�^�x�[�X�̐ڑ��Ɏ��s���܂����I" + e_sql.getMessage());
        } catch (Exception e) {
            out.println("�f�[�^�x�[�X�̐ڑ��Ɏ��s���܂����I" + e.getMessage());
        } finally {
            if (db_con != null) {
                try {
                    db_con.close();
                } catch (Exception e) {
                    System.out.print("con:" + e.getMessage());
                }
            }
            if (db_st != null) {
                try {
                    db_st.close();
                } catch (Exception e) {
                    out.println("st:" + e.getMessage());
                }
            }
            if (db_data != null) {
                try {
                    db_data.close();
                } catch (Exception e) {
                    out.println("data:" + e.getMessage());
                }
            }
        }
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
