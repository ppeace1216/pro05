package com.shop.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.myapp.dto.BoardDTO;
import com.shop.myapp.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("list.do")
	public String boardList(Model model) throws Exception {
		List<BoardDTO> boardList = boardService.boardList();
		model.addAttribute("boardList",boardList);
		return "board/boardList";
	}
	@GetMapping("detail.do")
	public String getBoardDetail(HttpServletRequest request, Model model) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDTO dto = boardService.boardDetail(no);
		model.addAttribute("dto", dto);
		return "board/boardDetail";
	}
	@GetMapping("insert.do")
	public String insertForm(HttpServletRequest request, Model model) throws Exception {
		return "board/boardInsert";
	}
	@PostMapping("insert.do")
	public String boardInsert(HttpServletRequest request, Model model) throws Exception {
		BoardDTO dto = new BoardDTO();
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		boardService.boardInsert(dto);
		return "redirect:list.do";
	}
	@GetMapping("delete.do")
	public String boardDelete(HttpServletRequest request, Model model) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		boardService.boardDelete(no);
		return "redirect:list.do";
	}
	@GetMapping("edit.do")
	public String editForm(HttpServletRequest request, Model model) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDTO dto = boardService.boardDetail(no);
		model.addAttribute("dto", dto);
		return "board/boardEdit";
	}
	@PostMapping("edit.do")
	public String boardEdit(HttpServletRequest request, Model model) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDTO dto = new BoardDTO();
		dto.setNo(no);
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		boardService.boardEdit(dto);
		return "redirect:list.do";
	}
}
