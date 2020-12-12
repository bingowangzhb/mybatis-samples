package com.bgw.mybatis.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * SampleTest
 *
 * @author wang
 * @since 2020/12/6 20:54
 **/
public class MybatisSampleTest {


    public static void main(String[] args) throws Exception {


        String resource = "conf/mybatis/mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Blog blog = sqlSession.selectOne("com.bgw.mybatis.example.BlogMapper.selectBlog", 1);
            System.out.println("blog = " + blog);
        }



    }
}
