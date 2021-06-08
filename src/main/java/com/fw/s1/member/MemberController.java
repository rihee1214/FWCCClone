package com.fw.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	
	@GetMapping("memberJoin")
	public String setJoin() throws Exception {
		return "member/memberJoin";
	}
	
	@PostMapping("usernameCheck")
	public void getUsernameCheck(MemberVO memberVO) throws Exception {
		memberVO = memberService.getUsernameCheck(memberVO);
	}
}