package com.heejin.project01.board.repository;

import com.heejin.project01.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    boolean insert(Board board);

    List<Board> selectAll(Board board);


}
