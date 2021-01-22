package com.bgw.mybatis.example;

import com.bgw.mybatis.example.domain.Blog;
import com.bgw.mybatis.example.mapper.BlogMapper;
import org.apache.ibatis.io.DefaultVFS;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;

/**
 * SampleTest
 *
 * @author wang
 * @since 2020/12/6 20:54
 **/
public class MybatisSampleTest {

    static Logger log = LoggerFactory.getLogger(MybatisSampleTest.class);

    static SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void setup() throws Exception {
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void testVfs() throws Exception {
        VFS vfs = new DefaultVFS();
        vfs.list(".").forEach(log::info);
    }

    @Test
    public void selectSqlSession() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Blog blog = sqlSession.selectOne("com.bgw.mybatis.example.mapper.BlogMapper.getBlog", 2);
            log.info("blog : {}", blog);
        }
    }

    @Test
    public void selectByMapper1() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            log.info("bolgMapper.class {}, hashCode: {}", blogMapper.getClass(), blogMapper.hashCode());
            Blog blog = blogMapper.getBlog(2);
            log.info("blog : {}", blog);


            BlogMapper blogMapper2 = sqlSession.getMapper(BlogMapper.class);
            log.info("bolgMapper2.class {}, hashCode: {}", blogMapper2.getClass(), blogMapper2.hashCode());

            List<Blog> blogs = blogMapper.listAll();
            for (Blog b : blogs) {
                log.info("b : {}", b);
            }
        }
    }

    @Test
    public void selectByMapper2() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            log.info("bolgMapper.class {}, hashCode: {}", blogMapper.getClass(), blogMapper.hashCode());
            Blog blog = blogMapper.getBlog(1);
            log.info("blog : {}", blog);
        }
    }
}
