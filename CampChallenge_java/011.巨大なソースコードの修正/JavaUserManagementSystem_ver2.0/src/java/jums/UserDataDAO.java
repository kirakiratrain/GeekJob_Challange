package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try
        {
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }
        finally
        {
            if(con != null)
            {
                con.close();
            }
        }

    }
    /**
     * データの更新を行う
     * 
     * 
     * 
     */
        //profilesID, name,tell,age,birthday
    UserDataDTO updateDataAll(UserDataDTO updateData
                       )throws SQLException
    {
        String ret;

       
        Connection con = null;
        PreparedStatement st = null;
        try
        {
            con = DBManager.getConnection();
            
            String sql = "update user_t set name = " + "'" + updateData.getName() + "'";
            java.sql.Date sqlDate = new java.sql.Date(updateData.getBirthday().getTime());
            sql += ",birthday = " +  "'" + sqlDate.toString() + "'";
            sql += ",tell = " + "'" + updateData.getTell()+ "'";
            sql += ",type = " + updateData.getType();
            sql += ",comment = "  + "'" + updateData.getComment()+ "'";
            String strNewDate = new Timestamp(System.currentTimeMillis()).toString();
            sql += ",newDate = "  + "'" + new Timestamp(System.currentTimeMillis()).toString()+ "'";
            sql += " where userID = " + updateData.getUserID() + ';';
            st =  con.prepareStatement(sql);
            int num = st.executeUpdate();
//            String sql = "update user_t set name = " + "'?'";
//            java.sql.Date sqlDate = new java.sql.Date(updateData.getBirthday().getTime());
//            sql += ",birthday = " +  "?";
//            sql += ",tell = " + "'?'";
//            sql += ",type = ?";
//            //sql += ",comment = " + "'?'";
//            sql += ",comment = ?";
//            sql += ",newDate = ?";
//            sql += " where userID = ?";
//            
//            
//            st =  con.prepareStatement(sql);
//            st.setString(1, updateData.getName());
//            st.setDate(2, sqlDate);
//            st.setString(3, updateData.getTell());
//            st.setInt(4, updateData.getType());
//            st.setString(5,updateData.getComment());
//            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
//            st.setInt(7, updateData.getUserID());

            //int num = st.executeUpdate();
            
            sql = "SELECT * FROM user_t where userID =" + updateData.getUserID() ;
            st =  con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("Update completed");

            return resultUd;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }
        finally
        {
            if(con != null){
                con.close();
            }
        }
    }
    
    
    /**
     * データの削除を行う
    
    */
     public void delete(UserDataDTO deleteData) throws SQLException
     {
        UserDataDTO resultUd = new UserDataDTO();
        String sql = "delete from  user_t where userID =" + deleteData.getUserID() + ';';
        Connection con = null;
        PreparedStatement st = null;
        try
        {
            con = DBManager.getConnection();
           
            st =  con.prepareStatement(sql);
            int num = st.executeUpdate();
            
            
            System.out.println("Update completed");

        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }
        finally
        {
            if(con != null)
            {
                con.close();
            }
        }
            
     }
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO search(UserDataDTO ud) throws SQLException
    {
        Connection con = null;
        PreparedStatement st = null;
        try
        {
            con = DBManager.getConnection();
            //
            String sql = "SELECT * FROM user_t";
            boolean flag = false;
            int[] saerchTarget = {0,0,0};
            
            //修正箇所2 対策
            if (!ud.getName().equals("")) 
            {
                sql += " WHERE name like ?";
                flag = true;
                saerchTarget[0] = 1;
            }
            if (ud.getBirthday()!=null) 
            {
                if(!flag)
                {
                    sql += " WHERE birthday like ?";
                    flag = true;
                }
                else
                {
                    sql += " AND birthday like ?";
                }
                saerchTarget[1] = 1;
            }
            if (ud.getType()!=0)
            {
                if(!flag)
                {
                    sql += " WHERE type like ?";
                }
                else
                {    
                    sql += " AND type like ?";
                }
                saerchTarget[2] = 1;
            }
             //修正箇所2  ここで例外が発生する　?が一個なのに変換しようとしているため
             
            st =  con.prepareStatement(sql);
            //コメントアウト
//            st.setString(1, "%"+ud.getName()+"%");
//            st.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
//            st.setInt(3, ud.getType());
            
            int cnt = 1;
            if(saerchTarget[0]== 1) 
            {
               st.setString(cnt, "%"+ud.getName()+"%");
               cnt++;
            }
            if(saerchTarget[1]== 1)
            {
                st.setString(cnt, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                cnt++;
            }
            if(saerchTarget[2]== 1)
            {
                st.setInt(cnt, ud.getType());
            }

            
            //修正箇所3 複数の検索対象があった場合に最初の一人しか表示しない様になっている
            ResultSet rs = st.executeQuery();
            UserDataDTO resultUd = new UserDataDTO();
            while(rs.next())
            {
                //UserDataDTO resultUd = new UserDataDTO();
                resultUd.setUserID(rs.getInt(1));
                resultUd.setName(rs.getString(2));
                resultUd.setBirthday(rs.getDate(3));
                resultUd.setTell(rs.getString(4));
                resultUd.setType(rs.getInt(5));
                resultUd.setComment(rs.getString(6));
                resultUd.setNewDate(rs.getTimestamp(7));
            }
            
            System.out.println("search completed");

            return resultUd;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }
        finally
        {
            if(con != null)
            {
                con.close();
            }
        }

    }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
}
