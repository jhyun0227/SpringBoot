package com.ch.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.member.dao.MemberDao;
import com.ch.member.model.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao md;

	@Override
	public Member select(String id) {
		return md.select(id);
	}

	@Override
	public int insert(Member member) {
		return md.insert(member);
	}

	@Override
	public int update(Member member) {
		return md.update(member);
	}

	@Override
	public int delete(String id) {
		return md.delete(id);
	}
}
