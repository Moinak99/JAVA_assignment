package com.patient;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	     PatientService serv = ctx.getBean(PatientService.class); 
	     PatientModel pmodel = new PatientModel();
	     
	     
	     
	     System.out.println("---Choose Operation: 1.Insert , 2.Delete , 3.Update , 4. GetAllRegistered Details---");
	     int choice = scan.nextInt();
	     System.out.println();
	     
	     switch(choice) {
	     
	     case 1:
	    	 System.out.println("Patient Name: ");
	    	 String pnm = scan.next();
	    	 
	    	 System.out.println("Patient Address: ");
	    	 String patientaddress = scan.next();
	    	 
	    	 System.out.println("Patient Gender: ");
	    	 String gender = scan.next();
	    	 
	    	 System.out.println("Doctor Name: ");
	    	 String doctorname = scan.next();
	    	 
	    	 System.out.println("Disease: ");
	    	 String diseasedetails = scan.next();
	    	 
	    	 System.out.println("Date: ");
	    	 String date = scan.next();
	    	 
	    	 pmodel.setDate(date);
	    	 pmodel.setDiseasedetails(diseasedetails);
	    	 pmodel.setDoctorname(doctorname);
	    	 pmodel.setGender(gender);
	    	 pmodel.setPatientaddress(patientaddress);
	    	 pmodel.setPatientname(pnm);
	    	 serv.insertPatient(pmodel);
	    	 System.out.println("Added");
	    	 break;
	     case 2:
	    	 System.out.println("Enter id to Delete: ");
	    	 int id = scan.nextInt();
	    	 pmodel.setId(id);
	    	 serv.deletePatient(pmodel);
	    	 System.out.println("Added");

	    	 break;
	     case 3:
	    	 System.out.println("Enter id to Delete: ");
	    	 int id1 = scan.nextInt();
	    	 pmodel.setId(id1);
	    	 System.out.println("Enter Patient Name: ");
	    	 String nm = scan.next();
	    	 pmodel.setPatientname(nm);
	    	 serv.updatePatient(pmodel);
	    	 System.out.println("Added");

	    	 break;
	     case 4:
	    	 
	    	 System.out.println(serv.getALLDetails().get(0));
	    	 break;
	    default:
	    	System.out.println("Enter Again");
	     }
	     scan.close();
	     

	}

}
