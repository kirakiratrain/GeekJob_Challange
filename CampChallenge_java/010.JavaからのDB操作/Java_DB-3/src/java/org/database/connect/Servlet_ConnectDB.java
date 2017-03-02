/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.database.connect;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Calendar;
/**
 *
 * @author Choir
 */
public class Servlet_ConnectDB extends HttpServlet 
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        /* 課題：全情報の
        以下の課題を、JavaからのJDBCを用いて実現してください。
        前回の課題「テーブルの作成とinsert」で作成したテーブルからSELECT*により全件取得し、
        画面に取得した全情報を表示してください
        */
        
        //DB
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        try
        {
        
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db","root","root");
            
            String sql = "Select * FROM profiles;";
                
            db_st = db_con.prepareStatement(sql);
            db_data = db_st.executeQuery();
    
            while(db_data.next())
            {
                //profilesID, name,tell,age,birthday

                
                out.print("profilesID:" + db_data.getString("profilesID") + "<br>");
                String strName = db_data.getString("name");
                out.println("name:"   + strName   + "<br>");
                out.print("tell:"   + db_data.getString("tell")   + "<br>");
                out.print("age:"    + db_data.getString("age")    + "<br>");
                out.print("birthday:"    + db_data.getString("birthday")    + "<br>");
                
            }
  
            db_con.close();
            db_st.close();
            db_data.close();
        }
        catch(SQLException e_sql)
        {
            
            out.println("データベースの接続に失敗しました！"+e_sql.getMessage());
        }
        catch(Exception e)
        {
            out.println("データベースの接続に失敗しました！"+e.getMessage());
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
        
//        try (PrintWriter out = response.getWriter()) 
//        {
//            /* TODO output your page here. You may use following sample code. */
//            
//            
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Servlet_ConnectDB</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Servlet_ConnectDB at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
