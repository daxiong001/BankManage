package util;

import com.mysql.cj.jdbc.Driver;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class dbConnection {
    static Properties prop;
    static {

        prop = new Properties();
        try {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(prop.getProperty("driver"));
            conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("psw"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static int addUpdDel(String sql){
        int i = 0;
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("数据库增删改异常");
            e.printStackTrace();
        }
        return i;
    }

    public static ResultSet selectSql(String sql){
        ResultSet rs = null;
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
             rs = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("数据库查询异常");
            e.printStackTrace();
        }
        return rs;
    }

   public static void close(ResultSet rs, PreparedStatement pst,Connection conn){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (pst!=null){
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
   }

   public static void close(PreparedStatement pst,Connection conn){
        if (pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
   }

   public static void close(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
   }
}
