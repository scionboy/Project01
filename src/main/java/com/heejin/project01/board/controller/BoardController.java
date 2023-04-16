package com.heejin.project01.board.controller;

import com.heejin.project01.admin.domain.Admin;
import com.heejin.project01.board.domain.Board;
import com.heejin.project01.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    @Autowired
    private final BoardService boardService;


    @GetMapping("/board")
    public String board(Model model, HttpSession session, Board board) {
        model.addAttribute("bList",boardService.selectAll(board));
        Admin user = (Admin) session.getAttribute("user");
        model.addAttribute("user",user);
        return "board/board";
    }

}
