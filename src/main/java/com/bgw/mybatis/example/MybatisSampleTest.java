package com.bgw.mybatis.example;

import com.bgw.mybatis.example.domain.Blog;
import com.bgw.mybatis.example.mapper.BlogMapper;
import org.apache.ibatis.io.DefaultVFS;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * SampleTest
 *
 * @author wang
 * @since 2020/12/6 20:54
 **/
public class MybatisSampleTest {


    public static void main(String[] args) throws Exception {


        String resource = "conf/mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // VFS vfs = new DefaultVFS();
        // vfs.list(".").forEach(System.out::println);

        selectByMapper(sqlSessionFactory);
    }

    public static void selectSqlSession(SqlSessionFactory sqlSessionFactory) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Blog blog = sqlSession.selectOne("com.bgw.mybatis.example.mapper.BlogMapper.getBlog", 1);
            System.out.println("blog = " + blog);
        }
    }

    public static void selectByMapper(SqlSessionFactory sqlSessionFactory) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = blogMapper.getBlog(1);
            System.out.println("blog = " + blog);

            List<Blog> blogs = blogMapper.getBlogs();
            for (Blog b : blogs) {
                System.out.println("b = " + b);
            }
        }
    }


}
