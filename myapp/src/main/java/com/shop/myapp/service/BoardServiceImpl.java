package com.shop.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.myapp.dto.BoardDTO;
import com.shop.myapp.dto.UserDTO;
import com.shop.myapp.repository.BoardDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardDAO boardMapper;

	@Override
	public List<BoardDTO> boardList() {
		return boardMapper.boardList();
	}

	@Override
	public BoardDTO boardDetail(int no) {
		return boardMapper.boardDetail(no);
	}

	@Override
	public void boardInsert(BoardDTO dto) {
		boardMapper.boardInsert(dto);
		
	}

	@Override
	public void boardDelete(int no) {
		boardMapper.boardDelete(no);
		
	}

	@Override
	public void boardEdit(BoardDTO dto) {
		boardMapper.boardEdit(dto);
		
	}


	
}
