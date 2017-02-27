/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Servlet.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Choir
 * �ۑ�u�N�b�L�[�̋L�^�ƕ\���v�Ɠ����@�\���Z�b�V�����ō쐬���Ă��������B
 */
public class TestSessionServletMain extends HttpServlet
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
        response.setContentType("text/html;charset=UTF-8");
        
        //true�͌��݃Z�b�V���������݂��Ȃ��ꍇ�́A�V�����������ĕԂ�
        HttpSession session = request.getSession(true);
        
        
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            String result = "/WEB-INF/jsp/TestSession.jsp";
            Date date = new Date();
            SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            String strDate = timeFormat.format(date);
            
            if (session.isNew())
            {
                out.println("�Z�b�V��������<br>");
                session.setAttribute("Date", strDate);
            } else 
            {
                out.println("�Z�b�V�����擾<br>");
                String strReadDate = (String)session.getAttribute("Date");
                
                out.println("�ǂݍ��݂̕\��<br>");
                out.println(strReadDate);
            }
            
            //out.println("<a href=\"/session/deleteobject\">age�I�u�W�F�N�g�̍폜</a>");
            out.println("<a href=/TestSession//ServletDeleteSession>age�I�u�W�F�N�g�̍폜</a>");
            

//            RequestDispatcher rd = request.getRequestDispatcher(result);
//            rd.forward(request, response);
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
