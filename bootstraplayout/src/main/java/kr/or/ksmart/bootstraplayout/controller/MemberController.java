package kr.or.ksmart.bootstraplayout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.bootstraplayout.service.MemberService;
import kr.or.ksmart.bootstraplayout.vo.Member;

@Controller
public class MemberController {
	@Autowired MemberService memberService;
	
	
	@GetMapping("/memberList")
	public String memberList(Model model) {
		model.addAttribute("memberList", memberService.memberList());
		return "/member/mlist/memberList";
	}
	
	@GetMapping("/addMember")
	public String addMember() {
		return "/member/minsert/addMember";
	}
	
	@PostMapping("/addMember")
	public String addMembet(Member member, Model model) {
		//System.out.println(member+"<===============================받아오는값");
		model.addAttribute("member", memberService.addMember(member));
		return "redirect:/memberList";
	}
	
	@GetMapping("/modifyMember")
	public String modefyMember(@RequestParam(value="memberId")String memberId,Model model) {
		System.out.println(memberId+"<=======아이디값확인");
		model.addAttribute("member", memberService.getMemberById(memberId));
		return "/member/mUpdate/modifyMember";
	}
	
	@PostMapping("/modifyMember")
	public String modifyMember(Member member) {
		memberService.modifyMember(member);
		
		return "redirect:/memberList";
	}
	
	@GetMapping("/delMember")
	public String delMember(@RequestParam(value="memberId")String memberId,Model model) {
		model.addAttribute("memberId", memberId);
		return "/member/mdelete/delMember";
	}
	
	@PostMapping("/delMember")
	public String delMember(Member member,Model model) {
		int result = memberService.delMember(member.getMemberId(), member.getMemberPw());
		
		if(result == 0) {
			model.addAttribute("result", "비밀번호불일치");
			model.addAttribute("memberId", member.getMemberId());
			return "/member/mdelete/delMember";
		}
		return "redirect:/memberList";
		
	}
	
	@GetMapping("/mSearchList")
	public String mSearchList() {
		return "/member/msearch/mSearchList";
	}
	
	@PostMapping("/mSearchList")
	public String mSearchList(@RequestParam(value="sk")String sk,@RequestParam(value="sv")String sv,Model model) {
		model.addAttribute("mSearchList", memberService.mSearchList(sk, sv));
		
		return "redirect:/memberList";
	}
	
}
