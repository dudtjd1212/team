package kr.or.ksmart.bootstraplayout.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.bootstraplayout.mapper.MemberMapper;
import kr.or.ksmart.bootstraplayout.vo.Member;

@Service
@Transactional
public class MemberService {
	@Autowired private MemberMapper memberMapper;
	
	public List<Member> memberList(){
		return memberMapper.memberList();
	}
	
	public int addMember(Member member) {
		return memberMapper.addMember(member);
	}
	
	public Member getMemberById(String memberId){
		return memberMapper.getMemberById(memberId);
	}
	
	public int modifyMember(Member member) {
		return memberMapper.modifyMember(member);
	}
	public int delMember(String memberId,String memberPw) {
		return memberMapper.delMember(memberId, memberPw);
	}
	public List<Member> mSearchList(String sk,String sv){
		return memberMapper.mSearchList(sk, sv);
	}
}
