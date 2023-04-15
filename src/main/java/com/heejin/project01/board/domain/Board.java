package com.heejin.project01.board.domain;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Board {
    private int board_no;
    private String title;
    private int recommend;
    private int hit;
    private int user_id;
    private String content;
    private Date reg_date;


}

