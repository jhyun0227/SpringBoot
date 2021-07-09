package com.ch.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ch.member.model.Member;

@Mapper
public interface MemberDao {
	Member select(String id);

	int insert(Member member);

	int update(Member member);

	int delete(String id);

}
