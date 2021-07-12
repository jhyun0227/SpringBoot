package com.ch.layout.service;
import java.util.List;

import com.ch.layout.model.Dept;
public interface DeptService {
	List<Dept> deptList();
	Dept select(int deptno);
	int insert(Dept dept);
	int update(Dept dept);
	int delete(int deptno);

}