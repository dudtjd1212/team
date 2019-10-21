package kr.or.ksmart.ksmart_layout1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.ksmart_layout1.service.GoodsService;
import kr.or.ksmart.ksmart_layout1.vo.Goods;

@Controller
public class GoodsController {

	@Autowired private GoodsService goodsService;
	
	@GetMapping("/delGoods")
	public String delGoods(@RequestParam(value="goodsCode")
							String goodsCode, Model model) {
		model.addAttribute("goodsCode", goodsCode);
		
		return "/goods/goodsdelete/delGoods";
	}
	
	@PostMapping("/delGoods")
	public String delGoods(  @RequestParam(value="goodsCode")
							 String goodsCode
							 ,@RequestParam(value="memberId")
							 String memberId
							,@RequestParam(value="memberPw")
							 String memberPw 
							,Model model) {
		int result = goodsService.delGoods(goodsCode, memberId, memberPw);
		if(result==0) {
			model.addAttribute("result", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("goodsCode", goodsCode);
			return "/goods/goodsdelete/delGoods";
		}
		return "redirect:/goodsList";
	}
	
	@GetMapping("/modifyGoods")
	public String getGoodsByCode(@RequestParam(value="goodsCode") 
								String goodsCode, Model model) {
		model.addAttribute("goods", goodsService.getGoodsByCode(goodsCode));
		
		return "/goods/gUpdate/modifyGoods";
	}
	
	@PostMapping("/modifyGoods")
	public String modifyGoods(Goods goods) {
		System.out.println(goods.toString() + "<----goods");
		goodsService.modifyGoods(goods);
		return "redirect:/goodsList";
	}
	
	@GetMapping("/goodsList")
	public String getGoodsList(Model model) {

		model.addAttribute("goodsList", goodsService.getGoodsList());

		return "/goods/glist/goodsList";
	}
	
	@PostMapping("/getGoodsSearch")
	public String getGoodsSearch( @RequestParam(value="sk") 		String sk
								 ,@RequestParam(value="sv")			String sv
								 ,@RequestParam(value="firstMoney") String firstMoney
								 ,@RequestParam(value="lastMoney") 	String lastMoney
								 ,Model model) {

		model.addAttribute("goodsList", goodsService.getGoodsSearch(sk, sv, firstMoney, lastMoney));
		return "/goods/glist/goodsList";
	}
	
	@GetMapping("/addGoods")
	public String addGoods() {
		
		return "/goods/gInsert/addGoods";
	}
	
	@PostMapping("/addGoods")
	public String addGoods(Goods goods, HttpSession session) {
		
		goodsService.addGoods(goods, session);
		
		return "redirect:/goodsList";
	}
	
	/*
	 * @PostMapping("/addGoods") public String addGoods(Goods goods, HttpSession
	 * session) {
	 * 
	 * goodsService.addGoods1(goods, session);
	 * 
	 * return "redirect:/goodsList"; }
	 */
	
}
