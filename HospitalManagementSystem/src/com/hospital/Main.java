package com.hospital;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main {

	public static void main(String[] args) {
		try {
			   Reader reader = Resources.getResourceAsReader("config.xml");
			   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			   SqlSession session = sqlSessionFactory.openSession();
			   System.out.println("Session Opened successfully");
			   Scanner scan = new Scanner(System.in); 
			   System.out.println("Enter Operation:-->");
			   System.out.println("1. For Insert");
			   System.out.println("2. Get All data");
			   System.out.println("3.  Get Data By Id");
			   System.out.println("4. Update Data");
			   System.out.println("5. Delete Data by id:");
			   int choice = scan.nextInt();
			   switch(choice) {
			   case 1:
				 //INSERT  
				   System.out.println("Enter Patient Name");
				   String pnm = scan.nextLine();
				   System.out.println("Enter Patient Age");
				   Integer age = scan.nextInt();
				   System.out.println("Disease");
				   String dis= scan.nextLine();
				   scan.next();
				   System.out.println("Enter Patient Address");
				   String add= scan.nextLine();
				   scan.next();
				   System.out.println("Doctor Name");
				   String dctr = scan.nextLine();
				   scan.next();
				   System.out.println("Payment");
				   Double pay = scan.nextDouble();
				   AddDetailsModel details = new AddDetailsModel(pnm,age,add,dis,dctr,pay);
				   //Insert Patient data
				   session.insert("Patient.insert", details);
				   System.out.println("record inserted successfully");
			     break;
			   case 2:
				   //VIEW
				   System.out.println("List of Data");
				     List<AddDetailsModel> obj = session.selectList("Patient.getAll");
				     for(AddDetailsModel st : obj ){ System.out.print(st); }
				     System.out.println("\nRecords Read Successfully "); 
			     break;
			   case 3:
					  //READ BY ID
				   AddDetailsModel obj1 = (AddDetailsModel)session.selectOne("Patient.getById", 2);
			       System.out.println(obj1); 
				     break;
			   case 4:
				   //UPDATE DATA
				   System.out.println("Enter id to Delete:");
				      int id1 = scan.nextInt();
				   AddDetailsModel obj11 = (AddDetailsModel)session.selectOne("Patient.getById", id1);
				      System.out.println("Current details of the Patient are" );
				      System.out.println(obj11.toString());
				      
				      System.out.println("Enter Patient Name");
					   String pnm1 = scan.nextLine();
					   System.out.println("Enter Patient Age");
					   Integer age1 = scan.nextInt();
					   System.out.println("Disease");
					   String dis1= scan.nextLine();
					   scan.next();
					   System.out.println("Enter Patient Address");
					   String add1= scan.nextLine();
					   scan.next();
					   System.out.println("Doctor Name");
					   String dctr1 = scan.nextLine();
					   scan.next();
					   System.out.println("Payment");
					   Double pay1 = scan.nextDouble();
					   obj11.setPatientname(pnm1);
					   obj11.setDiseasedetails(dis1);
					   obj11.setPaymentdetails(pay1);
					   obj11.setDoctorname(dctr1);
					   obj11.setPatientaddress(add1);
					   obj11.setPatientage(age1);
				     //Update the Patient record 
				      session.update("Patient.update",obj11);
				      System.out.println("Record updated successfully"); 
				      session.commit();
				      //verifying the record 
				      AddDetailsModel std = (AddDetailsModel)session.selectOne("Patient.getById", id1);
				      System.out.println("Details of the Patient after update operation" );
				      System.out.println(std.toString());
				     break;
			   case 5:
				   //DELETE BY ID
				      System.out.println("Enter id to Delete:");
				      int id = scan.nextInt();
				   System.out.println("List Before Deletion"); 
				      List<AddDetailsModel> obj2 = session.selectList("Patient.getAll"); 
				      for(AddDetailsModel st : obj2 ){
				           System.out.println(st); }
				     //Delete operation 
				      session.delete("Patient.deleteById", id); 
				      session.commit();
				      System.out.println("Record deleted successfully");
				      System.out.println("List after Deletion");
				      obj2 = session.selectList("Patient.getAll");
				      for(AddDetailsModel st : obj2 ){
				            System.out.println(st); } 
				     break;
			   default:
			     System.out.println("Enter valid choice");
			 }
			   session.commit();
		       session.close();
		       scan.close();
		 } 
			  catch (IOException e) {
		 e.printStackTrace();  } 
	}
}
