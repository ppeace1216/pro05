package com.shop.myapp.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shop.myapp.dto.UserDTO;
import com.shop.myapp.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("list.do")
	public String userList(Model model) throws Exception {
		List<UserDTO> userList = userService.userList();
		model.addAttribute("userList",userList);
		return "user/userList";
	}
	/* 관리자 회원 정보 보기 */
	@RequestMapping(value="getUser.do", method = RequestMethod.GET)
	public String getUser(@RequestParam String id, Model model) throws Exception {
		UserDTO user = userService.getUser(id);
		model.addAttribute("user", user);
		return "user/userDetail";
	}
	/* 일반회원 정보보기 */
	@RequestMapping(value="read.do", method = RequestMethod.GET)
	public String userRead(Model model, HttpServletRequest request) throws Exception {
		String id = (String) session.getAttribute("sid");
		UserDTO user = userService.getUser(id);
		model.addAttribute("user", user);
		return "user/userRead";
	}
	
	
	//회원 가입 - 약관 동의 페이지 로딩
	@GetMapping("agree.do")
	public String getAgree(Model model) throws Exception {
		return "user/agree";
	}
	//회원 가입 - 회원가입폼 페이지 로딩
	@GetMapping("join.do")
	public String joinUser(Model model) throws Exception {
		return "user/userInsert";
	}
//	//회원 가입 - Ajax로 아이디 중복 체크 
//	@RequestMapping(value="idCheck.do", method=RequestMethod.POST)
//	public void idCheck(HttpServletResponse response, HttpServletRequest request, Model model) throws Exception {
//		String id = request.getParameter("id");
//		boolean result = false;
//		UserDTO dto = new UserDTO();
//		dto = userService.getUser(id);
//
//		if(dto!=null){	//이미 있는 아이디임
//			result = false;
//		} else {
//			result = true;
//		}
//		JSONObject json = new JSONObject();
//		json.put("result", result);
//		PrintWriter out = response.getWriter();
//		out.println(json.toString());
//	}
//	//회원 가입 - 회원 가입 처리
//	@RequestMapping(value="insert.do", method = RequestMethod.POST)
//	public String memberWrite(UserDTO udto, Model model) throws Exception {
//		//비밀번호 암호화
//		String userpw = user.getPw();
//		String pwd = pwdEncoder.encode(userpw);
//		member.setPw(pwd);
//		userService.userInsert(user);
//		return "redirect:/";
//	}
//	
//	//로그인 폼 로딩
//	@RequestMapping("loginForm.do")  
//	public String memberLoginForm(Model model) throws Exception {
//		return "member/loginForm";
//	}
//	
//	//로그인 	- 컨트롤러에서 세션 처리
//	@RequestMapping(value="signin.do", method = RequestMethod.POST)
//	public String memberSignin(@RequestParam String id, @RequestParam String pw, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
//		session.invalidate();
//		UserDTO mdto = new UserDTO();
//		mdto.setPw(pw);
//		mdto.setId(id);
//		UserDTO login = userService.signIn(mdto);
//		boolean loginSuccess = pwdEncoder.matches(mdto.getPw(), login.getPw());
//		if(loginSuccess && login!=null) {
//			session.setAttribute("member", login);
//			session.setAttribute("sid", id);
//			return "redirect:/";
//		} else {
//			return "redirect:loginForm.do";
//		}
//	} 
//	
//	//로그인 - Service에서 세션 처리
//	@RequestMapping(value="login.do", method = RequestMethod.POST)
//	public String memberLogin(UserDTO mdto, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
//		boolean loginSuccess = userService.login(req);
//		if(loginSuccess) {		
//			return "home";
//		} else {
//			return "redirect:loginForm.do";
//		}
//	}
//	
//	
//	//회원 정보 변경
//	@RequestMapping(value="update.do", method = RequestMethod.POST)
//	public String userUpdate(UserDTO mdto, Model model) throws Exception {
//		String pwd = pwdEncoder.encode(mdto.getPw());
//		mdto.setPw(pwd);
//		userService.userUpdate(mdto);
//		return "redirect:/";
//	}

	//회원 탈퇴
	@RequestMapping(value="delete.do", method = RequestMethod.GET)
	public String userDelete(@RequestParam String id, Model model, HttpSession session) throws Exception {
		userService.userDelete(id);
		session.invalidate();
		return "redirect:/";
	}
	
	//로그아웃
	@RequestMapping("logout.do")
	public String memberLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}
}
