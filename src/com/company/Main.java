package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.连接数据库
            String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";
            String name = "root";
            String password = "842655";
            conn = DriverManager.getConnection(url, name, password);
            //3.连接数据库操作对象,预编译SQL语句
            //1.增加
            //  String sql = "insert into student values(?,?,?,?)";
            //  ps = conn.prepareStatement(sql);
            //  ps.setInt(1, 19);
            //  ps.setString(2, "CC");
            //  ps.setInt(3, 44);
            //  ps.setString(4, "男");
            //2.修改
            // String sql = "update student set sex=? where sno=?";
            // ps = conn.prepareStatement(sql);
            // ps.setString(1, "女");
            // ps.setInt(2, 17);
            //3.删除
            //  String sql = "delete from student where sno=?";
            //  ps = conn.prepareStatement(sql);
            //  ps.setInt(1, 17);
            //4.查询
            String sql = "select * from student where sex=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "女");
            //4.执行SQL语句
            //执行insert，updata，delete
            //int sun = ps.executeUpdate();
            //执行查询
            ResultSet sun = ps.executeQuery();
            System.out.println(sun);
            //System.out.print(sun);
            //5.处理查询结果集
            while(sun.next())
            {
                System.out.print(sun.getInt("sno") + " ");
                System.out.print(sun.getString("sname") + " ");
                System.out.print(sun.getInt("age") + " ");
                System.out.println(sun.getString("sex"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
