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
import javax.servlet.RequestDispatcher;

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
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        /*
        //課題
        //クエリストリングを利用して、以下の処理を実現してください。
        //スーパーのレジでレシートを作る仕組みを作成します。
        //クエリストリングで総額・個数・商品種別を受け取って処理します。
        //①商品種別は、３つ。１：雑貨、２：生鮮食品、３：その他
        //まずは、この商品種別を表示してください。
        //②総額と個数から１個当たりの値段を算出してください。
        //総額と１個当たりの値段を表示してください。
        //③3000円以上購入で4%、5000円以上購入で5%のポイントが付きます。
        //購入額に応じたポイントの表示を行ってください。
        */
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            String result = "/WEB-INF/jsp/FortuneTellingResult.jsp";
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JspServLet2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>課題：戻り値２" + request.getContextPath() + "</h1>");
            out.println("１：雑貨、２：生鮮食品、３：その他");
            //String strType1 = (String)request.getAttribute("Type1");
            String[] strType1 = request.getParameterValues("Type1");
            String str = strType1[0];
            Integer type1 = new Integer(str);
           
            request.setAttribute("Type1", type1);
            RequestDispatcher rd = request.getRequestDispatcher(result);
            rd.forward(request, response);
            
        }
//        try (PrintWriter out = response.getWriter()) 
//        {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet JspServLet2</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>課題：戻り値２" + request.getContextPath() + "</h1>");
//            
//            request.setAttribute("", out);
//            for (int i = 0; i < 3; i++) {
//                ProfileData viewData = getProfileData4(i);
//
//                out.println(viewData.getName() + "<br>");
//                out.println(viewData.getBirthday() + "<br>");
//                if (viewData.getAdress().equals(null)) {
//                    continue;
//                }
//                out.println(viewData.getAdress() + "<br>");
//            }
//            out.println();
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    //課題：戻り値２
    //戻り値としてある人物のid(数値),名前,生年月日、住所を返却するメソッドを作成し、
    //受け取った後はid以外の値を表示する
    public ProfileData getProfileData1() {
        ProfileData Data = new ProfileData();
        Data.setID(10);
        Data.setAdress("東京都");
        Data.setBirthday(new Date());
        Data.setName("いとう");

        return Data;
    }

    //課題：引数・戻り値
    //引き数に1つのid(数値)をとり、3人分のプロフィール(項目は課題5参照)を
    //あらかじめメソッド内で定義しておく。引き数のid値により戻り値として返却するプロフィールを
    //誰のものにするか選択する。それ以降などは課題「戻り値2」と同じ扱いにする。
    public ProfileData getProfileData2(int select_id) {
        ProfileData[] profiledata = new ProfileData[3];

        for (int i = 0; i < 3; i++) {
            profiledata[i] = new ProfileData();
            profiledata[i].setBirthday(new Date());
            profiledata[i].setID(i);
        }
        profiledata[0].setName("いとう");
        profiledata[1].setName("さとう");
        profiledata[2].setName("かとう");

        profiledata[0].setAdress("東京");
        profiledata[1].setAdress("宮城");
        profiledata[2].setAdress("北海道");

        return profiledata[select_id];
    }

    /**
     * 課題3「引数、戻り値1」の3人分のプロフィールのうち1人だけ住所が値nullの状態で定義し、
     * ループ処理で全員分のプロフィールをid以外表示する処理を実行する。 この際、歯抜けになっているデータはcontinueで飛ばす
     */
    public ProfileData getProfileData3(int select_id) {
        ProfileData[] profiledata = new ProfileData[3];

        for (int i = 0; i < 3; i++) {
            profiledata[i] = new ProfileData();
            profiledata[i].setBirthday(new Date());
            profiledata[i].setID(i);
        }
        profiledata[0].setName("いとう");
        profiledata[1].setName("さとう");
        profiledata[2].setName("かとう");

        profiledata[0].setAdress("東京");
        profiledata[1].setAdress("宮城");
        profiledata[2].setAdress(null);

        return profiledata[select_id];
    }

    /**
     * 課題3：先にInteger limit=2を定義しておき、課題7の処理のうち2人目(limitで定義した
     * 値の人数)まででループ処理を抜けるようにする
     */
    public ProfileData getProfileData4(int select_id) {
        ProfileData[] profiledata = new ProfileData[3];
        Integer limit = 2;

        for (int i = 0; i < 3; i++) 
        {
            if (i == limit) 
            {
                break;
            }
            profiledata[i] = new ProfileData();
            profiledata[i].setBirthday(new Date());
            profiledata[i].setID(i);
        }
        profiledata[0].setName("いとう");
        profiledata[1].setName("さとう");
        profiledata[2].setName("かとう");

        profiledata[0].setAdress("東京");
        profiledata[1].setAdress("宮城");
        profiledata[2].setAdress(null);

        return profiledata[select_id];
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
