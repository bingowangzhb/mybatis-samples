package com.bgw.mybatis.example.mapper;

import com.bgw.mybatis.example.domain.Author;

import java.util.List;

/**
 * AuthorMapper
 *
 * @author zhibin.wang
 * @since 2021/01/21 19:40
 */
public interface AuthorMapper {

    /**
     * insertAuthor
     * @param author author
     * @return int
     */
    int insertAuthor(Author author);

    /**
     * getAuthor
     * @param id id
     * @return Author
     */
    Author getAuthor(int id);

    /**
     * insertAuthors
     * @param authors authors
     * @return int
     */
    int insertAuthors(List<Author> authors);

}
