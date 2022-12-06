package com.shop.myapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.myapp.dto.BoardDTO;

@Mapper
@Repository
public interface BoardDAO {
	List<BoardDTO> boardList();
	BoardDTO boardDetail(int no);
	void boardInsert(BoardDTO dto);
	void boardDelete(int no);
	void boardEdit(BoardDTO dto);
}
