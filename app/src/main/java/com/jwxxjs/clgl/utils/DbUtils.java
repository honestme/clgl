package com.jwxxjs.clgl.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zcl on 2018/3/28.
 *
 * @link
 * @description
 */

public abstract class DbUtils {
    private static String queryAccountSql = "select * from dbo.Account";


    private Connection getSQLConnection(String ip, String user, String pwd, String db) {
        Connection con = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://" + ip + ":1433/" + db + ";charset=utf8", user, pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    private ResultSet querySQL(String sql){
        ResultSet rs = null;
        Connection conn  = null;
        Statement stmt = null;
        try{
            conn = getSQLConnection("192.168.2.6","sa","Sa123","YouweiBDS");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
        }

        return rs;
    }
    public String QuerySQL()
    {
        String result = "";
        try
        {
            Connection conn = getSQLConnection("192.168.2.6","sa","Sa123","YouweiBDS");
            String sql = "select top 10 * from Users";
            Statement stmt = conn.createStatement();//
            ResultSet rs = stmt.executeQuery(sql);

            readData();

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
            result += "查询数据异常!" + e.getMessage();
        }
        return result;
    }

    public abstract void readData();

}
