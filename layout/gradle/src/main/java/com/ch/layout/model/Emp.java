package com.ch.layout.model;
import java.sql.Date;
import org.apache.ibatis.type.Alias;
import lombok.Data;
@Data
@Alias("emp")
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	// join
//	private Dept dept;
	private String dname;
	private String loc;
}