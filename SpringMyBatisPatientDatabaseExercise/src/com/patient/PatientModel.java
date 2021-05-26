package com.patient;

public class PatientModel {
	private int id;
	private String patientname;
	private String patientaddress;
	private String gender;
	private String doctorname;
	private String diseasedetails;
	private String date;
	
	public PatientModel() {}
	public PatientModel(int id,String patientaddress,String patientname,String gender,String doctorname,String diseasedetails,String date) {
		super();
		this.id=id;
		this.patientname=patientname;
		this.patientaddress=patientaddress;
		this.date=date;
		this.diseasedetails=diseasedetails;
		this.doctorname=doctorname;
		this.gender=gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getPatientaddress() {
		return patientaddress;
	}
	public void setPatientaddress(String patientaddress) {
		this.patientaddress = patientaddress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getDiseasedetails() {
		return diseasedetails;
	}
	public void setDiseasedetails(String diseasedetails) {
		this.diseasedetails = diseasedetails;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
