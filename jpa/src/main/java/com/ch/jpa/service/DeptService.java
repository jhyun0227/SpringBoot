package com.ch.jpa.service;
import java.util.List;

import com.ch.jpa.model.Dept;
public interface DeptService {
	List<Dept> deptList();
	Dept select(int deptno);
	Dept insert(Dept dept);
	Dept update(Dept dept);
	int delete(int deptno);

}