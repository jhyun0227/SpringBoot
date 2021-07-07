package com.ch.oracle.service;

import java.util.List;

import com.ch.oracle.model.Emp;

public interface EmpService {
	List<Emp> empList(int deptno);

}
