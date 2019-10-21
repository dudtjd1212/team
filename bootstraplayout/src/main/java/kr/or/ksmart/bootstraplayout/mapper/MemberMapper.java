package kr.or.ksmart.bootstraplayout.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.bootstraplayout.vo.Member;

@Mapper
public interface MemberMapper {
	
	public List<Member> memberList();
	
	public int addMember(Member member);
	
	public Member getMemberById(String memberId);
	
	public int modifyMember(Member member) ;
	
	public int delMember(String memberId,String memberPw);
	
	public List<Member> mSearchList(String sk,String sv);
	
}
