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
public class Servlet_InsertData extends Servlet_Session {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        ?���[�U�[�̃��O�C���E���O�A�E�g�@�\
        ?���i���o�^�@�\�@��
        ?���i�ꗗ�@�\ �@�@�@��
        ���e�e�[�u���̍\���͊e���̑z���ō���Ă݂Ă��������B
        ���[�U�[���Ǘ��e�[�u��
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
        
        //DB
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        
        //�t�H�[�����瑗��ꂽ������̎擾
        //request.setCharacterEncoding("Shift_JIS");
        super.processRequest(request,response);
        
        String name;
        String ID;
        String inItem;
        String outItem;
        String stock;
        String date;
        
        name    = request.getParameter("NAME");
        ID      = request.getParameter("ID");
        inItem  = request.getParameter("INITEM");
        outItem = request.getParameter("OUTITEM");
        stock   = request.getParameter("STOCK");
        date    = request.getParameter("DATE");
        
        
        
        if(getLoginStat() != "Login_OK")
        {
            response.sendRedirect("/Java_DB/Servlet_Login");
            return;
        }
        
        PrintWriter out = response.getWriter();
        try
        {
        
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db","root","root");
            
            String sql ="INSERT INTO merchandise_info(Name,ID,InItem,OutItem,Stock,Date)";
            String sqlVal ="VALUES(?,?,?,?,?,?);";    
            
            sql += sqlVal;      
            db_st = db_con.prepareStatement(sql);
            
            //NAME
            db_st.setString(1, name);
            //ID
            db_st.setInt(2, Integer.parseInt(ID));

            //InItem
            db_st.setInt(3, Integer.parseInt(inItem));
            //OutItem
            db_st.setInt(4, Integer.parseInt(outItem));
            //Stock
            db_st.setInt(5, Integer.parseInt(stock));
            //Date
            db_st.setString(6, date);
            //�X�V
            int num = db_st.executeUpdate();
              
            db_con.close();
            db_st.close();
            if(db_data != null)
            {
                db_data.close();
            }
        }
        catch(SQLException e_sql)
        {
            out.println("�f�[�^�x�[�X�̐ڑ��Ɏ��s���܂����I"+e_sql.getMessage());
        }
        catch(Exception e)
        {
            out.println("�f�[�^�x�[�X�̐ڑ��Ɏ��s���܂����I"+e.getMessage());
        }
        finally
        {
            if(db_con != null)
            {
                try
                {
                    db_con.close();
                }
                catch(Exception e)
                {
                    System.out.print("con:"+e.getMessage());
                }
            }
            if(db_st != null)
            {
                try
                {
                    db_st.close();
                }
                catch(Exception e)
                {
                    out.println("st:"+e.getMessage());
                }
            }
            if(db_data != null)
            {
                try
                {
                    db_data.close();
                }
                catch(Exception e)
                {
                    out.println("data:"+e.getMessage());
                }
                 
            }
        }
        
        String target = "/WEB-INF/jsp/registration.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request, response);
        
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Servlet_InsertData</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Servlet_InsertData at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        
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
