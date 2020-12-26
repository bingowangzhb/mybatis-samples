package com.bgw.mybatis.example.mapper;

import com.bgw.mybatis.example.domain.Blog;

import java.util.List;

/**
 * BlogMapper
 *
 * @author wang
 * @since 2020/12/6 21:03
 **/
public interface BlogMapper {

    /**
     * getBlogs
     * @return List
     */
    List<Blog> getBlogs();

    /**
     * getBlog
     * @param id id
     * @return Blog
     */
    Blog getBlog(int id);
}
