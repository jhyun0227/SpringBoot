package com.ch.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ch.mysql.dto.BoardDto;

@Mapper // 구현하는 클래스 없이 바로 xml로 연결
public interface BoardMapper {
	List<BoardDto> selectBoardList();

	int insert(BoardDto board);

	BoardDto select(int boardIdx);

}
