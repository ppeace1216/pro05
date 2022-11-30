package com.shop.repository;

import java.util.List;

import com.shop.dto.SampleDTO;

public interface SampleDAO {
	List<SampleDTO> sampleList() throws Exception;
}
