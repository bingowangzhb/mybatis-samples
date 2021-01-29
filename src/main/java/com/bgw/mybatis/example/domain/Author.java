package com.bgw.mybatis.example.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Author
 *
 * @author zhibin.wang
 * @since 2021/01/21 19:54
 */
@Data
@ToString
public class Author implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private String bio;
}
