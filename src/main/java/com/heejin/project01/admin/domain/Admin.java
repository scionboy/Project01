package com.heejin.project01.admin.domain;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin {
    private int user_id;
    private String user_name;
    private String user_email;
    private String user_pass;


}
