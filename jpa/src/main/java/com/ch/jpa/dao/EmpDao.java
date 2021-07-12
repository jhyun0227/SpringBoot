package com.ch.jpa.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ch.jpa.model.Emp;
@Repository
public interface EmpDao extends JpaRepository<Emp, Object>{
	@Query("select x from Emp x where deptno=:deptno")
	List<Emp> list(@Param("deptno") int deptno);
	@Query("select x from Emp x order by deptno")
	List<Emp> empList();
	@Query("select x from Emp x where x.empno=:empno")
	Emp select(@Param("empno") int empno);
	@SuppressWarnings("unchecked")
	Emp saveAndFlush(Emp emp);
	@Transactional
	@Modifying
	@Query("delete from Emp where empno=:empno")
	int delete(@Param("empno") int empno);
	@Query("select x,y from Emp x, Dept y where x.deptno=y.deptno")
	List<Emp> allList();

}