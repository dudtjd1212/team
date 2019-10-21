package kr.or.ksmart.ksmart_layout1.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ksmart.ksmart_layout1.service.BoardService;

@Controller
public class Common {
	
	@Autowired private BoardService boardService;
	
	
	@RequestMapping(value="/ajaxTest", produces  = "application/json")
	public @ResponseBody Map<String,Object> ajaxTest(
			@RequestParam(value="currentPage"
			, required = false
			, defaultValue = "1") int currentPage
		){
		
		//Map<String,Object> map = boardService.getBoardList(currentPage);
		
		return boardService.getBoardList(currentPage);
	}
	
	@RequestMapping("/ajaxCall")
	public String ajaxCall() {
		
		return "ajax/ajaxCall";
	}
	
}
