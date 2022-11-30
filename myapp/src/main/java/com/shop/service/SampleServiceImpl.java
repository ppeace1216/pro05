package com.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.dto.SampleDTO;
import com.shop.repository.SampleDAO;

@Service
public class SampleServiceImpl implements SampleService {

	@Override
	public List<SampleDTO> sampleList() throws Exception {
		return SampleDAO.sampleList();
	}
	
}
