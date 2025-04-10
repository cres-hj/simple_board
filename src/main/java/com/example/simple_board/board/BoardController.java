package com.example.simple_board.board;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
public class BoardController {
  @Autowired
  private BoardService boardService;

  @GetMapping("/board/list")
  public ModelAndView list() {
    List<Board> boards = boardService.findAll();
    return new ModelAndView("board/list").addObject("boards", boards);
  }

  @GetMapping("/board/write")
  public ModelAndView write() {
    return new ModelAndView("board/write");
  }

  @GetMapping("/board/read")
  public ModelAndView read(@RequestParam Integer bno) {
    // 읽을 게시글이 있어야 하니까 board도 넘겨야지
    Map<String, Object> map = boardService.findByBno(bno);
    return new ModelAndView("board/read").addObject("map", map);
  }

  @PostMapping("/board/write")
  public ModelAndView write(@ModelAttribute Board board) {
    boardService.save(board);
    return new ModelAndView("redirect:/board/read?bno="+board.getBno());
  }

  @PostMapping("/board/update")
  public ModelAndView update(@ModelAttribute Board board) {
    boolean result = boardService.update(board);
    if(result==true)
      return new ModelAndView("redirect:/board/read?bno="+board.getBno());
    return new ModelAndView("redirect:/board/list");
  }

  @PostMapping("/board/delete")
  public ModelAndView delete(@RequestParam int bno, String password) {
    boolean result = boardService.delete(bno, password);
    return new ModelAndView("redirect:/board/list");
  }



}
