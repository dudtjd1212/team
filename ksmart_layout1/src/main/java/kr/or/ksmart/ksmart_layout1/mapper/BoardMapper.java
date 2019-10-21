package kr.or.ksmart.ksmart_layout1.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.ksmart_layout1.vo.Board;

@Mapper
public interface BoardMapper {
	
	public int deleteBoard(Board board);
	
	public int modifyBoard(Board board);
	
	public Board getBoardByNo(int boardNo);
	
	public int getBoardAllCount();
	
	public int addBoard(Board board); 
	
	public List<Board> getBoardList(Map<String, Integer> map);
}
