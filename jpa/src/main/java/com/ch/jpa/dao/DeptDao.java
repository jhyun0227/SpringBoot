package com.ch.jpa.dao;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ch.jpa.model.Dept;
@Repository
// spring에서는 JpaRepository<Dept, Integer>
public interface DeptDao extends JpaRepository<Dept, Object> {
	@Query("select x from Dept x order by x.deptno")
	List<Dept> deptList();
	@Query("select x from Dept x where x.deptno=:deptno")
	Dept select(@Param("deptno") int deptno);
	@SuppressWarnings("unchecked")
	Dept saveAndFlush(Dept dept);
	@Transactional
	@Modifying
	@Query("delete from Dept d where d.deptno=:deptno")
	int delete(@Param("deptno") int deptno);

}