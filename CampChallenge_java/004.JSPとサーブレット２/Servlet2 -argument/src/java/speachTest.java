/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;        //追加
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;     //追加
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import javax.servlet.RequestDispatcher;
import org.camp.servlet.methodTest;
/**
/**
 *
 * @author Choir
 */
public class speachTest extends HttpServlet {

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
        
        final String result = "/WEB-INF/jsp/speachTestResult.jsp";
        
        //リクエストスコープへ結果を設定
        methodTest speachData = new methodTest();
        speachData.setBirthday(new Date());
        
        speachData.setName("YUICHI ITO");
        speachData.setSpeach("私は退職します");
        request.setAttribute("SPEACH_DATA",speachData );
        
        
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServLet</title>");            
            out.println("</head>");
            out.println("<body>");
           // out.print("<h1>");
            
            //out.println("<h1>Servlet TestServLet at " + request.getContextPath() + "</h1>");
            for(int i = 0;i<10;i++)
            {
                //showProfile(response,speachData);
                showProfile(out,speachData);
            }

            out.println("</body>");
            out.println("</html>");
        }

       
        
    }
    public void showProfile(HttpServletResponse response,methodTest Data)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        
        out.println(Data.getName()      );
        out.println("<br>");
        out.println(Data.getBirthday()  );
        out.println("<br>");
        out.println(Data.getSpeach()    );
        out.println("<br>");
        
    }
    public void showProfile(PrintWriter out,methodTest Data) 
    {
        
        out.println(Data.getName()      );
        out.println("<br>");
        out.println(Data.getBirthday()  );
        out.println("<br>");
        out.println(Data.getSpeach()    );
        out.println("<br>");
        
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
