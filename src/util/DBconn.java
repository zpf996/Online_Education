package util;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.*;
public class DBconn {
    static String url="jdbc:mysql://localhost:3306/education?useSSL=false&serverTimezone=UTC";//sqlpath
    static String username="root";
    static String password="root";
    static Connection conn=null;
    static ResultSet rs=null;
    static PreparedStatement ps=null;
    public static void init(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url,username,password);
            System.out.println("mysql driver was successed");
        } catch (Exception e){
            System.out.println("sql driver is failed for init");
        }
    }
    public static int addUpdDel(String sql){
        int i=0;
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            i =  ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("sql数据库增删改查异常");
            e.printStackTrace();
        }
        return i;
    }
    public static ResultSet selectSql(String sql){
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("数据库查询异常");
            e.printStackTrace();
        }
        return rs;
    }
    public static void closeConn(){
        try{
            if(rs!=null){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(ps!=null){
                    ps.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try{
                    if(conn!=null){
                        conn.close();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
