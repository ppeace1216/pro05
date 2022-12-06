package com.shop.myapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.myapp.dto.SampleDTO;

@Mapper
@Repository
public interface SampleDAO {
	List<SampleDTO> getSample();
}
