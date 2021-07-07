package com.ch.oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.oracle.dao.EmpDao;
import com.ch.oracle.model.Emp;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao ed;

	@Override
	public List<Emp> empList(int deptno) {
		return ed.empList(deptno);
	}
}
