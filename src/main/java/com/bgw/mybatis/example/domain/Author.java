package com.bgw.mybatis.example.domain;

import lombok.Data;
import lombok.ToString;

/**
 * Author
 *
 * @author zhibin.wang
 * @since 2021/01/21 19:54
 */
@Data
@ToString
public class Author {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private String bio;
}
