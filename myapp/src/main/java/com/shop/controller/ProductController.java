package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	@RequestMapping(value="/product")
	public String getProduct(Model model) {
		model.addAttribute("template", "fragments/content/product");
		return "index";
	}
}
