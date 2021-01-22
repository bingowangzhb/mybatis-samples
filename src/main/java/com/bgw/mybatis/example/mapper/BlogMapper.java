package com.bgw.mybatis.example.mapper;

import com.bgw.mybatis.example.domain.Blog;
import org.apache.ibatis.annotations.Param;

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
    List<Blog> listAll();

    /**
     * getBlog
     * @param id id
     * @return Blog
     */
    Blog getBlog(@Param("id") int id);

    /**
     * updateBlog
     * @param blog blog
     * @return int
     */
    int updateBlog(Blog blog);

    /**
     * deleteBlog
     * @param blog blog
     * @return int
     */
    int deleteBlog(Blog blog);

    /**
     * deleteBlogById
     * @param id id
     * @return int
     */
    int deleteBlogById(@Param("id") int id);
}
