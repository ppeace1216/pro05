package com.shop.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.dto.SampleDTO;

@Repository
public class SampleDAOImpl implements SampleDAO{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<SampleDTO> sampleList() throws Exception {
		return selectList("sample.sampleList");
	}
	
}
