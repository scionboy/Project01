package com.heejin.project01.board.service;


import com.heejin.project01.admin.domain.Admin;
import com.heejin.project01.board.domain.Board;
import com.heejin.project01.board.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    @Autowired
    private final BoardMapper boardMapper;

    // 게시글 등록
    @Transactional
    public boolean insert(HttpServletResponse response, HttpServletRequest request, Board board, HttpSession session){
        // 현재 로그인된 user_id 가져오기
        Admin user = (Admin) session.getAttribute("user");
        board.setUser_id(user.getUser_id());

        boolean flag = boardMapper.insert(board);

        return flag;
    }

    // 게시글 전체 조회
    public List<Board> selectAll(Board board){
        List<Board> boardList = boardMapper.selectAll(board);

        return boardList;
    }

}
