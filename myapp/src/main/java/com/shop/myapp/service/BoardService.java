package com.shop.myapp.service;

import java.util.List;

import com.shop.myapp.dto.BoardDTO;


public interface BoardService {
	List<BoardDTO> boardList();
	BoardDTO boardDetail(int no);
	void boardInsert(BoardDTO dto);
	void boardDelete(int no);
	void boardEdit(BoardDTO dto);
}
