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
public class Servlet_LoginCheck extends Servlet_Session {

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
        request.setCharacterEncoding("UTF-8");
        
        
        //フォームから送られた文字列の取得
        request.setCharacterEncoding("Shift_JIS");
        
        super.processRequest(request,response);
        
        String userID = "";
        String pass = "";
        
        //id = request.getParameter("ID");
        userID = request.getParameter("USER_ID");
        pass = request.getParameter("PASS");
  
        
        PrintWriter out = response.getWriter();
        //HttpSession session = request.getSession(true);
             

        boolean check = authUser(userID, pass);
        
        if(getLoginStat() == "Login_out")
        {
            response.sendRedirect("/Java_DB/Servlet_Login");
            return;
        }
  
        
        if (check)
        {
            
          /* 認証済みにセット */
          setLoginStat("Login_OK");
          
          /* 本来のアクセス先へ飛ばす */
          String target = "WEB/WEB-INF/jsp/registration.jsp/";
          target = "/WEB-INF/jsp/registration.jsp";
          RequestDispatcher rd = request.getRequestDispatcher(target);
          rd.forward(request, response);
          //response.sendRedirect(target);
        }
        else
        {
          /* 認証に失敗したら、ログイン画面に戻す */
          this.setLoginStat("Login_fail");
          
          response.sendRedirect("/Java_DB/Servlet_Login");

        }
        
    }
    
    //ID・パスワードの存在確認
    protected boolean authUser(String userID, String pass)
    {
        /* 取りあえずユーザー名とパスワードが入力されていれば認証する */
        if (userID == null || userID.length() == 0 || pass == null || pass.length() == 0)
        {
          return false;
        }
        //DB
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        
        String InUserID = "";
        String InPass = "";
        
        //id = request.getParameter("ID");
        InUserID    = userID;
        InPass      = pass;
        boolean login = false;
        
        //データベース読み込み
        try
        {
        
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db","root","root");
            
            if(!InUserID.equals("") && !InPass.equals(""))
            {
                String sql = "Select * from userInfo where UserID = "
                           + InUserID  + " and" + " Pass = " + "'" + InPass + "'" +  ";";

                db_st = db_con.prepareStatement(sql);
                db_data = db_st.executeQuery();
                
                while(db_data.next())
                {
                    Integer GetId = db_data.getInt("UserID");
                    String strGetPass = db_data.getString("Pass");
                    if(InUserID.equals(Integer.toString(GetId)) &&
                            InPass.equals(strGetPass))
                    {
                        login = true;
                    }
                }
                
                db_con.close();
                db_st.close();
                if(db_data != null)
                {
                    db_data.close();
                }
            }
        }
        catch(SQLException e_sql)
        {
            
        }
        catch(Exception e)
        {
            
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
                    //out.println("st:"+e.getMessage());
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
                    //out.println("data:"+e.getMessage());
                }
                 
            }
        }
        
        

        return login;
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
