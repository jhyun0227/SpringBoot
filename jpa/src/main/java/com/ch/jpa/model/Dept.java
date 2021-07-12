package com.ch.jpa.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.ibatis.type.Alias;
import lombok.Data;
@Entity
@Table(name = "dept")
@Data
@Alias("dept")
public class Dept {
	@Id
	private int deptno;
	private String dname;
	private String loc;
}