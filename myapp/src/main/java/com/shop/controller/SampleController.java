package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.SampleDTO;
import com.shop.service.SampleService;

@RequestMapping("/sample/*")
@Controller
public class SampleController {
	
	@Autowired
	SampleService sampleService;
	
	@RequestMapping("list.do")
	public String boardList(Model model) throws Exception {
		List<SampleDTO> sampleList = sampleService.sampleList();
		model.addAttribute("sampleList",sampleList);
		return "sample/sampleList";
	}
}
