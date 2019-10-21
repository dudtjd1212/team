package kr.or.ksmart.ksmart_layout1.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.ksmart_layout1.service.BoardService;
import kr.or.ksmart.ksmart_layout1.vo.Board;

@Controller
public class BoardController {
	
	@Autowired private BoardService boardService;
	
	@PostMapping("/deleteBoard")
	public String deleteBoard(Board board, Model model) {
		System.out.println(board.toString() + "<--boardController deleteBoard board");
		String alert = boardService.deleteBoard(board);
		
		if(!alert.equals("")) {
			model.addAttribute("alert", alert);
			model.addAttribute("boardNo",board.getBoardNo());
			return "/board/bDelete/delBoard";
		}
		return "redirect:/boardList";
	}
	
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(@RequestParam(value="boardNo") int boardNo
							, Model model) {
		
		model.addAttribute("boardNo", boardNo);
		
		return "/board/bDelete/delBoard";
	}
	
	@PostMapping("/modifyBoard")
	public String modifyBoard(Board board) {
		System.out.println(board + "<--- boardController modifyBoard board");
		boardService.modifyBoard(board);
		return "redirect:/boardList";
	}
	
	@GetMapping("/modifyBoard")
	public String modifyBoard(Model model
							,@RequestParam(value="boardNo") int boardNo) {
		System.out.println(boardNo+"<---boardController modifyBoard boardNo");
		model.addAttribute("board", boardService.getBoardByNo(boardNo));
		
		return "/board/bUpdate/modifyBoard"; 
	}
	
	@GetMapping("/boardList")
	public String boardList(Model model
							,@RequestParam(value="currentPage"
							, required = false
							, defaultValue = "1") int currentPage) {
		Map<String, Object> map = boardService.getBoardList(currentPage);
		
		model.addAttribute("boardList", map.get("list"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("startPageNum", map.get("startPageNum"));
		model.addAttribute("lastPageNum", map.get("lastPageNum"));
		return "/board/bList/boardList";
	}
	
	
	@GetMapping("/addBoard")
	public String addBoard() {
		return "/board/bInsert/addBoard";
	}
	
	@PostMapping("/addBoard")
	public String addBoard(Board board) {
		System.out.println(board + "<---boardController addBoard board");
		boardService.addBoard(board);
		return "redirect:/";
	}
	
}
