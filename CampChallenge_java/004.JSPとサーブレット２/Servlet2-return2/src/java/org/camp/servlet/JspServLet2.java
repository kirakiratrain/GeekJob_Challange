/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//import org.camp.servlet.ProfileData;
/**
 *
 * @author Choir
 */
public class JspServLet2 extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JspServLet2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet JspServLet2 at " + request.getContextPath() + "</h1>");
            ProfileData viewData = getProfileData();
            out.println(viewData.getName() + "<br>");
            out.println(viewData.getBirthday() + "<br>");
            out.println(viewData.getAdress() + "<br>");
            
            out.println();
            out.println("</body>");
            out.println("</html>");
        }
    }

    //課題：戻り値２
    //戻り値としてある人物のid(数値),名前,生年月日、住所を返却するメソッドを作成し、
    //受け取った後はid以外の値を表示する
    public ProfileData getProfileData()
    {
        ProfileData Data = new ProfileData();
        Data.setID(10);
        Data.setAdress("東京都");
        Data.setBirthday(new Date());
        Data.setName("いとう");
        
        return Data;
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

