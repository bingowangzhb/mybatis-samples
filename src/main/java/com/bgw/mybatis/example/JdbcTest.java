package com.bgw.mybatis.example;

import com.bgw.mybatis.example.domain.Blog;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JdbcTest
 *
 * @author wang
 * @since 2020/12/9 22:29
 **/
public class JdbcTest {


    public static void main(String[] args) {
        select();
    }

    public static void select() {

        Connection conn = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2. 创建连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis-samples", "root", "root");

            DatabaseMetaData metaData = conn.getMetaData();

            printDatabaseInfo(metaData);


            // 3. 创建Statement
            Statement statement = conn.createStatement();
            String sql = "select * from blog where id = 1";

            // 4. 返回结果ResultSet
            ResultSet rs = statement.executeQuery(sql);


            Blog blog = new Blog();

            while (rs.next()) {
                blog.setId(rs.getInt("id"));
                blog.setAuthor(rs.getString("author"));
                blog.setContent(rs.getString("content"));
                blog.setTitle(rs.getString("title"));
                blog.setCreateTime(rs.getDate("create_time"));
                blog.setUpdateTime(rs.getDate("update_time"));
                blog.setStatus(rs.getInt("status"));
            }

            System.out.println("blog = " + blog);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 5. 映射
    }

    private static void printDatabaseInfo(DatabaseMetaData metaData) throws Exception {
        System.out.println("metaData.getDatabaseProductName() = " + metaData.getDatabaseProductName());
        System.out.println("metaData.getDatabaseProductVersion() = " + metaData.getDatabaseProductVersion());
        System.out.println("metaData.getDatabaseMajorVersion() = " + metaData.getDatabaseMajorVersion());
        System.out.println("metaData.getDatabaseMinorVersion() = " + metaData.getDatabaseMinorVersion());

        System.out.println("metaData.getDriverMajorVersion() = " + metaData.getDriverMajorVersion());
        System.out.println("metaData.getDefaultTransactionIsolation() = " + metaData.getDefaultTransactionIsolation());
        System.out.println("metaData.getDriverMinorVersion() = " + metaData.getDriverMinorVersion());
        System.out.println("metaData.getDriverName() = " + metaData.getDriverName());
        System.out.println("metaData.getDriverVersion() = " + metaData.getDriverVersion());
        System.out.println("metaData.getURL() = " + metaData.getURL());
        System.out.println("metaData.getJDBCMajorVersion() = " + metaData.getJDBCMajorVersion());
        System.out.println("metaData.getJDBCMinorVersion() = " + metaData.getJDBCMinorVersion());
        System.out.println("metaData.getMaxConnections() = " + metaData.getMaxConnections());

    }

}
