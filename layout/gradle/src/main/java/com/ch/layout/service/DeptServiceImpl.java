package com.ch.layout.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.layout.dao.DeptDao;
import com.ch.layout.model.Dept;
@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao dd;
	public List<Dept> deptList() {
		return dd.deptList();
	}
	public Dept select(int deptno) {
		return dd.select(deptno);
	}
	public int insert(Dept dept) {
		return dd.insert(dept);
	}
	public int update(Dept dept) {
		return dd.update(dept);
	}
	public int delete(int deptno) {
		return dd.delete(deptno);
	}
}