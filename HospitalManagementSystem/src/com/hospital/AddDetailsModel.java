package com.hospital;

public class AddDetailsModel {
	private String id;
	private String patientname;
	private int patientage;
	private String patientaddress;
	private String diseasedetails;
	private String doctorname;
	private double paymentdetails;
	
	public AddDetailsModel(String patientname,int patientage,String patientaddress,String diseasedetails,String doctorname,double paymentdetails) {
		this.patientname=patientname;
		this.patientage=patientage;
		this.patientaddress=patientaddress;
		this.diseasedetails=diseasedetails;
		this.doctorname=doctorname;
		this.paymentdetails=paymentdetails;
	}
	public AddDetailsModel() {}
	public String toString() {
		  return "\nID: " + id + " Patient Name: " + patientname + " Age: " + patientage + " Address: " + patientaddress+ " Disease: " + diseasedetails+ " Doctor: " + doctorname+ " Payment: " + paymentdetails; }
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public int getPatientage() {
		return patientage;
	}
	public void setPatientage(int patientage) {
		this.patientage = patientage;
	}
	public String getPatientaddress() {
		return patientaddress;
	}
	public void setPatientaddress(String patientaddress) {
		this.patientaddress = patientaddress;
	}
	public String getDiseasedetails() {
		return diseasedetails;
	}
	public void setDiseasedetails(String diseasedetails) {
		this.diseasedetails = diseasedetails;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public double getPaymentdetails() {
		return paymentdetails;
	}
	public void setPaymentdetails(double paymentdetails) {
		this.paymentdetails = paymentdetails;
	}
}
