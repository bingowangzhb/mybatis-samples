package com.bgw.mybatis.example.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * BlogMapper
 *
 * @author wang
 * @since 2020/12/6 21:01
 **/
@Data
@ToString
public class Blog implements Serializable {
    private Integer id;
    private String title;
    private String content;
    private String author;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}
