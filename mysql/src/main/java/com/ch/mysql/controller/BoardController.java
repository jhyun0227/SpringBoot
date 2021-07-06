package com.ch.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ch.mysql.dto.BoardDto;
import com.ch.mysql.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService bs;
	
	@RequestMapping("/board/boardList.do") // springboot는 확장자 포함
	public String boardList(Model model) {
		List<BoardDto> list = bs.selectBoardList();
		model.addAttribute("list", list);
		return "/board/boardList";
	}
	
	@RequestMapping("/board/boardWriteForm.do")
	public String boardWriteForm() {
		return "/board/boardWriteForm";
	}
	
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto board, Model model) {
		int result = bs.insert(board);
		model.addAttribute("result", result);
		return "/board/insertBoard";
	}
	
	@RequestMapping("/board/boardDetail.do")
	public String boardDetail(int boardIdx, Model model) {
		BoardDto board = bs.select(boardIdx);
		model.addAttribute("board", board);
		return "/board/boardDetail";
	}
}
