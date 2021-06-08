package com.fw.s1.member;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	public int setJoin(MemberVO memberVO) throws Exception;
	
	public int setMemberRole(Map<String, String> map) throws Exception;
	
	public MemberVO getUsernameCheck(MemberVO memberVO) throws Exception;
	
	//결제폼에서 유저 정보를 일부 가져오기 위함
	public MemberVO getUsernameandemail(MemberVO memberVO)throws Exception;
}