package com.ch.member.service;

import com.ch.member.model.Member;

public interface MemberService {
	Member select(String id);

	int insert(Member member);

	int update(Member member);

	int delete(String id);

}
