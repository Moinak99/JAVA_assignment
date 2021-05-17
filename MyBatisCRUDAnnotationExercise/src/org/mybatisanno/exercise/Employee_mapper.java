package org.mybatisanno.exercise;

import java.util.List;
import org.apache.ibatis.annotations.*;

public interface Employee_mapper {
	 final String getAll = "SELECT * FROM emp"; 
	   final String getById = "SELECT * FROM emp WHERE eid = #{eid}";
	   final String deleteById = "DELETE from emp WHERE eid = #{eid}";
	   final String insert = "INSERT INTO emp (ename, esal) VALUES (#{ename}, #{esal})";
	   final String update = "UPDATE emp SET ename = #{ename}, esal = #{esal} WHERE eid = #{eid}";
	   @Select(getAll)
	   @Results(value = {
	      @Result(property = "eid", column = "eid"),
	      @Result(property = "ename", column = "ename"),
	      @Result(property = "esal", column = "esal"),
	     
	   })
	   List<org.mybatisanno.exercise.Employee> getAll();
	   

	   @Select(getById)
	   @Results(value = {
	      @Result(property = "eid", column = "eid"),
	      @Result(property = "ename", column = "ename"),
	      @Result(property = "esal", column = "esal"),
	   })
	   Employee getByEid(int eid);
	   @Update(update)
	   void update(Employee employee);
	   @Delete(deleteById)
	   void delete(int eid);
	   @Insert(insert)
	   //@Options(useGeneratedKeys = true, keyProperty = "id")
	   void insert(Employee employee);
}
