package com.dlts.hrms.test;

import java.sql.*;

/**
 * Created by admin on 2018/5/24.
 */
public class MyCat {


    public  static void main(String[] args){
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("select * from sys_company");

            ResultSet rs = pstmt.executeQuery();
            while( rs.next() ){
                System.out.print(rs.getString("parent_code"));
            }

            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConn(conn);
    }

    private static void closeConn(Connection connection){
        if( connection!=null ){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.79.153:8066/test?characterEncoding=UTF-8&useSSL=false","root","123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
