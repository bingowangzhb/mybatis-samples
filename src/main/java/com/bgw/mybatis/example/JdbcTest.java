package com.bgw.mybatis.example;

import com.bgw.mybatis.example.domain.Blog;

import java.sql.Connection;
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

            // 3. 创建Statement
            Statement statement = conn.createStatement();
            String sql = "select * from t_blog where id = 1";

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
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        // 5. 映射


    }

}
