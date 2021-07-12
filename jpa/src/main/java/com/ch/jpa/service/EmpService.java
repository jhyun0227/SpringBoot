package com.ch.jpa.service;
import java.util.List;

import com.ch.jpa.model.Emp;
public interface EmpService {
	List<Emp> list(int deptno);
	List<Emp> empList();
	Emp select(int empno);
	Emp insert(Emp emp);
	Emp update(Emp emp);
	int delete(int empno);
	List<Emp> list();

}