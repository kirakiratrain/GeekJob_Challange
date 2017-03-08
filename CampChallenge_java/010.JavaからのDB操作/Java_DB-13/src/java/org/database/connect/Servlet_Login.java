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
        /* 課題：在庫管理システムの作成
        以下の機能を満たすロジックを作成してください。
        在庫管理システムを作成します。
        まず、DBにユーザー情報管理テーブルと、商品情報登録テーブルを作成してください。
        その上で、下記機能を実現してください。
        1ユーザーのログイン・ログアウト機能
        2商品情報登録機能
        3商品一覧機能
        ※各テーブルの構成は各自の想像で作ってみてください。
        ユーザー情報管理テーブル　UserInfo
        ・ユーザ名 UserID
        ・パスワード Pass
        
        ユーザ情報登録テーブル:merchandise_info
        ・商品名 Name
        ・商品ID ID
        ・入庫 InItem
        ・出庫 OutItem
        ・在庫 Stock
        ・日付 Date
        */
      
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ログインページ</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>ログイン画面</h1>");

        //HttpSession session = request.getSession(true);

        /* 認証失敗から呼び出されたのかどうか */
        Object status = m_session.getAttribute("LoginStat");

        if (getLoginStat() == "Login_fail")
        {
          out.println("<p>認証に失敗しました</p>");
          out.println("<p>再度ユーザー名とパスワードを入力して下さい</p>");
          setLoginStat(null);
          
        }
        else if(getLoginStat() == "Login_out")
        {
            //ログアウトしている状態
            setLoginStat(null);
            //session.setAttribute("status", null);
            // セッションの無効化
            m_session.invalidate();
        }
        else if(getLoginStat() == null )
        {
            //初期画面
        }
        //ログインしていない状態
        out.println("<form method=\"POST\" action=\"Servlet_LoginCheck\" name=\"loginform\">");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>ユーザー名</td>");
        out.println("<td><input type=\"text\" name=\"USER_ID\" size=\"32\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>パスワード</td>");
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
