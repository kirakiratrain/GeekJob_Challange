/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Choir
 */
public class Servlet2_queryString extends HttpServlet
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
        //response.setContentType("text/html;charset=shift-jis");
        /*
        //�ۑ�
        //�N�G���X�g�����O�𗘗p���āA�ȉ��̏������������Ă��������B
        //�X�[�p�[�̃��W�Ń��V�[�g�����d�g�݂��쐬���܂��B
        //�N�G���X�g�����O�ő��z�E���E���i��ʂ��󂯎���ď������܂��B
        //?���i��ʂ́A�R�B�P�F�G�݁A�Q�F���N�H�i�A�R�F���̑�
        //�܂��́A���̏��i��ʂ�\�����Ă��������B
        //?���z�ƌ�����P������̒l�i���Z�o���Ă��������B
        //���z�ƂP������̒l�i��\�����Ă��������B
        //?3000�~�ȏ�w����4%�A5000�~�ȏ�w����5%�̃|�C���g���t���܂��B
        //�w���z�ɉ������|�C���g�̕\�����s���Ă��������B
        */
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            //String result = "/WEB-INF/jsp/Selvlet2_queryString.jsp";
            String result = "/WEB-INF/jsp/FortuneTellingResult.jsp";
            
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet JspServLet2</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>�ۑ�F�߂�l�Q" + request.getContextPath() + "</h1>");
            //out.println("�P�F�G�݁A�Q�F���N�H�i�A�R�F���̑�");
            //String strType1 = (String)request.getAttribute("Type1");
            String[] strTypeAll = request.getParameterValues("TypeAll");
            
            String[] strType1 = request.getParameterValues("Type1");
            String[] strType2 = request.getParameterValues("Type2");
            String[] strType3 = request.getParameterValues("Type3");
            String[] strAllCost = request.getParameterValues("AllCost");
            
            String str = strType1[0];
            Integer type1 = new Integer(str);
            request.setAttribute("TypeALL", strTypeAll);
            request.setAttribute("Type1", type1);
            request.setAttribute("Type1", type1);
            RequestDispatcher rd = request.getRequestDispatcher(result);
            rd.forward(request, response);
            
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
