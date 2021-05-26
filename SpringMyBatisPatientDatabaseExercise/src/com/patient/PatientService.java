package com.patient;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



public interface PatientService {

	  @Insert("INSERT into patientdb(patientname,patientaddress,gender,doctorname,diseasedetails,date) VALUES(#{patientname}, #{patientaddress}, #{gender}, #{doctorname}, #{diseasedetails}, #{date})")
	  void insertPatient(PatientModel pobj);
	  
	  @Update("UPDATE patientdb SET patientname=#{patientname} where id=#{id}")
	  void updatePatient(PatientModel pobj);
	  
	  @Delete("DELETE FROM patientdb WHERE id=#{id}")
	  void deletePatient(PatientModel pobj);
	  
	  @Select("SELECT * FROM patientdb")
	  public List<PatientModel>  getALLDetails();
}
