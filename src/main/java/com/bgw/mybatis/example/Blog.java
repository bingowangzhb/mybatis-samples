package com.bgw.mybatis.example;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * BlogMapper
 *
 * @author wang
 * @since 2020/12/6 21:01
 **/
@Data
@ToString
public class Blog {
    private Integer id;
    private String title;
    private String content;
    private String author;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}
