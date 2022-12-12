package com.shop.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.myapp.dto.SampleDTO;
import com.shop.myapp.service.SampleService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class SampleController {

	SampleService sampleService;
	
	@GetMapping("/test1")
	@ResponseBody
	public String test1() {
		return "Hello Spring Boot Test1";
	}
	
	@GetMapping("/sample")
	@ResponseBody
	public List<SampleDTO> getSample() {
		return sampleService.getSample();
	}
	//thymeleaf의 일반 문자열 전송
	@GetMapping("/test3")
	public String getThy1(Model model) {
		model.addAttribute("thy1", "타임리프 사용하기1");
		return "test3";
	}
	//thymeleaf의 객체 전송
	@GetMapping("/test4")
	public String getThy2(Model model) {
		SampleDTO sample= new SampleDTO("pph", "8888");
		model.addAttribute("thy2", sample);
		return "test4";
	}
	@GetMapping("/test5")
	public String getThy3() {
		return "test5";
	}
	@GetMapping("/test6")
	public String getThy4(Model model) {
		List<SampleDTO> sampleList = sampleService.getSample();
		model.addAttribute("sampleList", sampleList);
		return "test6";
	}
	@GetMapping("/test7")
	public String getThy5(Model model) {
		SampleDTO sample= new SampleDTO("pph", "8888");
		List<String> genderList = new ArrayList<String>();
		genderList.add("M");
		genderList.add("F");
		model.addAttribute("gender", "F");
		model.addAttribute("genderList", genderList);
		model.addAttribute("thy3", sample);
		return "test7";
	}
}
