package poj;

import java.sql.*;

public class test01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //用户连接信息
        String url = "jdbc:mysql://localhost:3306/mall?useUnicode=true&character=utf8&useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "2002";
        //连接数据库
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(connection);
        //创建数据库操作对象
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //执行sql语句，返回结果
        String sql = "select * from teacher";
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}