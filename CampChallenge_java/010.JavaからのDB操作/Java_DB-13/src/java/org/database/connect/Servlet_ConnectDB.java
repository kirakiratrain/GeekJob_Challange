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
        
        /* 課題：在庫管理システムの作成
        以下の機能を満たすロジックを作成してください。
        在庫管理システムを作成します。
        まず、DBにユーザー情報管理テーブルと、商品情報登録テーブルを作成してください。
        その上で、下記機能を実現してください。
        ?ユーザーのログイン・ログアウト機能
        ?商品情報登録機能
        ?商品一覧機能
        ※各テーブルの構成は各自の想像で作ってみてください。
        ユーザー情報管理テーブル
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
        
        //DB
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        
        //フォームから送られた文字列の取得
        request.setCharacterEncoding("Shift_JIS");
        String id = "";
        String name = "";
        String pass = "";
        String birthday = "";
        String tell = (java.lang.String)"";
        
        //id = request.getParameter("ID");
        name = request.getParameter("NAME");
        pass = request.getParameter("PASS");
        birthday = request.getParameter("BIRTHDAY");
        
        
        PrintWriter out = response.getWriter();
        try
        {
        
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Challenge_db","root","root");
            
            //update profiles set name = '吉田 茂' where profilesID = 2;
            //SQL 例)
            //select * from user where id >= 3 and username  like ‘ta%’;
            /*
            //テーブルにカラムを追加
            //INSERT INTO テーブル名(カラム名１、カラム名２、カラム名３、、、)
            //VALUES(カラム１値、カラム２値、カラム３値、、、);
            例)
            INSERT INTO profiles(profilesID, name,tell,age,birthday) 
            VALUES
            (1,'田中 実','012-345-6789',30,'1994-02-01')
            */
            //String sql ="INSERT INTO profiles(profilesID,name,tell,age,birthday)";
            //String sqlVal ="VALUES(?,?,?,?,?);";    
            //String sqlVal ="VALUES"+'('+id+name+tell+age+birthday+')';
            //sql += sqlVal;      
//            db_st = db_con.prepareStatement(sql);
//            db_st.setInt(1, Integer.parseInt(id));
//            //NAME
//            db_st.setString(2, name);
//            //tell
//            db_st.setString(3, tell);
//            //age
//            db_st.setInt(4, Integer.parseInt(age));
//            //birthday
//            db_st.setString(5, birthday);
//            int num = db_st.executeUpdate();
            
            //データの削除
//            String sql = deleteData(id);
//            db_st = db_con.prepareStatement(sql);
//            int num = db_st.executeUpdate();
//            
//            sql = "select * from profiles;";
//            db_st = db_con.prepareStatement(sql);
//            db_data = db_st.executeQuery();
//            
//            out.println("ID"+id+"を削除しました");
            
            //データの更新
            //profilesID, name,tell,age,birthday
            //String sql = updateDataAll(id,name,tell,age,birthday);
            //db_st = db_con.prepareStatement(sql);
            //int num = db_st.executeUpdate();
            String sql = "";
//            String[] key = {"name","tell","age","birthday"};
//            String[] val = {name,tell,age,birthday};
//            for(int i = 0; i<4;i++)
//            {
//                sql = updateData(id,key[i],val[i]);
//                db_st = db_con.prepareStatement(sql);
//                int num = db_st.executeUpdate();
//            }
            
            //sql = search(id,name,tell,age,birthday);
            
            db_st = db_con.prepareStatement(sql);
            db_data = db_st.executeQuery();
            
            while(db_data.next())
            {
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
    String deleteData(String idVal)
    {
        String ret;
        String sql = "delete from profiles where profilesID = " + idVal +';';
        
        ret = sql;
        return ret;
    }
    //profilesID, name,tell,age,birthday
    String updateDataAll(String id  ,String name,
                      String tell,String age,
                      String birthday)
    {
        String ret;
        String sql = "update profiles set name = " + name;
        sql += " and set tell = " + tell;
        sql += " and set age = " + age;
        sql += " and set birthday = " + birthday;
        sql += " where profilesID = " + id +';';
        
        ret = sql;
        return ret;
    }
    
    String updateData(String id  ,String key, String val)
    {
        String ret;
        if(key.equals("name") || key.equals("tell") || key.equals("birthday"))
        {
            val = "'" + val +"'";
        }
        String sql = "update profiles set " + key +" = " + val;
        sql += " where profilesID = " + id +';';
        
        ret = sql;
        return ret;
    }
    
    String search(String id  ,String name,
                  String tell,String age,
                  String birthday)
    {
        String ret="";
        
        boolean flgAnd = false;
        String sql ="Select * from profiles";
        if(id.equals("") 
                && name.equals("") 
                && tell.equals("")
                && age.equals("") 
                && birthday.equals(""))
        {
            return sql;
        }
        else
        {
             sql += " where";
        }
        
        //name
        if(!name.equals(""))
        {
            name = "'" + name + "'";
            sql += " name = " + name;
            flgAnd = true;
        }
        //tell
        if(!tell.equals(""))
        {
            tell = "'" + tell + "'";
            if(flgAnd) sql += " and";
            sql += " tell = " + tell;
            flgAnd = true;
        }
        //age
        if(!age.equals(""))
        {
            age = "'" + age + "'";
            if(flgAnd) sql += " and";
            sql += " age = " + age;
            flgAnd = true;
        }
        //birthday
        if(!birthday.equals(""))
        {
            birthday = "'" + birthday + "'";
            if(flgAnd) sql += " and";
            sql += " birthday = " + birthday;
            flgAnd = true;
        }
        
        ret = sql + ";";
        
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
