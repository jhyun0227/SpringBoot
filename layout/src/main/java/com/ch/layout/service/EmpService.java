package com.ch.layout.service;
import java.util.List;

import com.ch.layout.model.Emp;
public interface EmpService {
	List<Emp> list(int deptno);
	List<Emp> empList();
	Emp select(int empno);
	int insert(Emp emp);
	int update(Emp emp);
	int delete(int empno);
	List<Emp> list();

}