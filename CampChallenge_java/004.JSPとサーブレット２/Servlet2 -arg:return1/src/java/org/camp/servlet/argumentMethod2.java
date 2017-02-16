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

/**
 *
 * @author Choir
 */
public class argumentMethod2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 課題：引き数が3つのメソッドを定義する。1つ目は適当な数値を、2つ目はデフォルト値が5の数値
     * を、最後はデフォルト値がfalse(boolean)のtypeを引き数として定義する。
     * 1つ目の引き数に2つ目の引き数を掛ける計算をするメソッドを作成し、typeがfalseの時は
     * その値を表示、trueのときはさらに2乗して表示する。
     * 例）Integer sample(Integer AAA, Integer BBB, boolean type) // 引数が３つのメソッド書き出し部分
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet argumentMethod2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>引数2 "+"</h1>");
            //int ans = calcTest(1);
            out.println(Integer.toString(calcTest(1,5,true)));
            out.println("</body>");
            out.println("</html>");
        }
    }
    public Integer calcTest(Integer num)
    {
        return calcTest(num,5,false);           //デフォルト
    }
    public Integer calcTest(Integer num ,Integer num2,boolean type) 
    {
        Integer ret;
        if(type)
        {
            ret = (num*num2);
            ret = ret*ret;     //二乗
        }
        else
        {
            ret = (num*num2);
        }
        return ret;
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
