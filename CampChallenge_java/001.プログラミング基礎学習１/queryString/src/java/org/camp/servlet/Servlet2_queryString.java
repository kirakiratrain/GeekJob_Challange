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
        クエリストリングを利用して、以下の処理を実現してください。
        スーパーのレジでレシートを作る仕組みを作成します。
        クエリストリングで総額・個数・商品種別を受け取って処理します。
        ①商品種別は、３つ。１：雑貨、２：生鮮食品、３：その他
        まずは、この商品種別を表示してください。
        ②総額と個数から１個当たりの値段を算出してください。
        総額と１個当たりの値段を表示してください。
        ③3000円以上購入で4%、5000円以上購入で5%のポイントが付きます。
        購入額に応じたポイントの表示を行ってください。
        */
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            String result = "/WEB-INF/jsp/Selvlet2_queryString.jsp";
            //String result = "/WEB-INF/jsp/FortuneTellingResult.jsp";
            
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet JspServLet2</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>‰Û‘èF–ß‚è’l‚Q" + request.getContextPath() + "</h1>");
            //out.println("１：雑貨、２：生鮮食品、３：その他");
            //String strType1 = (String)request.getAttribute("Type1");
            
            String[] strType = request.getParameterValues("Type");
            String[] strCost = request.getParameterValues("Cost");
            String[] strNum = request.getParameterValues("Num");
            String[] strAllCost = request.getParameterValues("AllCost");
            
            //種別の表示
            String strTypeNames = "１：雑貨、２：生鮮食品、３：その他";
            request.setAttribute("TypeNames", strTypeNames);
            
            //種別の取得
            String str = strType[0];
            Integer intType = new Integer(str);
            
            String  strSetType = "";
            switch(intType)
            {
                case 1:
                    strSetType = "雑貨";
                    break;
                case 2:
                    strSetType = "生鮮食品";
                    break;
                case 3:
                    strSetType = "その他";
                    break;
            }
            
            //種別のセット
            request.setAttribute("Type", strSetType);
            //コスト
            str = strAllCost[0];
            Integer intAllCost  =new Integer(str);
            request.setAttribute("AllCost", intAllCost);
            
            //個数
            str = strNum[0];
            Integer intCostNum  = new Integer(str);
            request.setAttribute("Num", intCostNum);
            
            //単価
            int cost = CalcCost((int)intAllCost,(int)intCostNum);
            request.setAttribute("Cost", cost);
 
//            //雑貨
//            Integer number = new Integer(str);
//            request.setAttribute("Type1", number);
//            
//            //生鮮食品
//            str = strType2[0];
//            number = Integer.getInteger(str);
//            request.setAttribute("Type2", number);
//            //その他
//            str = strType3[0];
//            number = Integer.getInteger(str);
//            request.setAttribute("Type3", number);
//            
//            //総額
//            str = strAllCost[0];
//            number = Integer.getInteger(str);
//            request.setAttribute("AllCost", number);
            
            RequestDispatcher rd = request.getRequestDispatcher(result);
            rd.forward(request, response);
            
        }
    }
    //総額と個数から単価を計算します
    Integer CalcCost(int AllCost ,int num)
    {
        int ret = 0;
        ret = AllCost /num;
        
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
