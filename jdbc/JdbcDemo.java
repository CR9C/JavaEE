package io.github.cr9c;


import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo {
    @Test
    public void testGetConn() throws Exception {
        String url = "jdbc:mysql:///jdbcdemo?useSSL=false";
        String user = "root";
        String password = "admin";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT id,name FROM student WHERE id > ?";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            ps = conn.prepareStatement(sql);
            ps.setInt(1,3);
            rs = ps.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                System.out.println(id + "-->" + name);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (rs != null){
                    rs.close();
                }
            } catch (Exception e) {
              e.printStackTrace();
            } finally {
                try {
                    if (ps != null){
                        ps.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (conn != null){
                            conn.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
