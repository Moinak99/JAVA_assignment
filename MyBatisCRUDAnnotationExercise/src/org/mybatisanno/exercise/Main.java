package org.mybatisanno.exercise;

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
			 
			 System.out.println("1 insert");
			 System.out.println("2 update");
			 System.out.println("3 getdata by id");
			 System.out.println("4 delete");
			 System.out.println("5 get all");
			 Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
		        SqlSession session = sqlSessionFactory.openSession();
//		        session.getConfiguration().addMapper(Student_mapper.class);
		        Employee_mapper mapper = session.getMapper(Employee_mapper.class);   
		        System.out.println("session opened successfully");
			 
			 Scanner scan = new Scanner(System.in);
			 int choice = scan.nextInt();
			 
			 switch(choice)
			 {
			 case 1:
			     //INSERT
			      //Create a new student object
				 System.out.println("Enter Employee name");
				 String nm = scan.nextLine();
				 System.out.println("Enter Employee salary");
				 int sal = scan.nextInt();
			        Employee obj = new Employee(nm, sal);
			        //Insert student data   
			        mapper.insert(obj);
			        System.out.println("record inserted successfully"); 
                 break;
                 
			 case 2: 
				 //UPDATE
				 //select a particular student using id  
				 System.out.println("Enter Employee id");
				 int id = scan.nextInt();
				 System.out.println("Enter Employee name");
				 String nm1 = scan.nextLine();
				 System.out.println("Enter Employee salary");
				 int sal2 = scan.nextInt();
				 Employee obj1 = mapper.getByEid(id);
				 System.out.println("Current details of the student are "+obj1.toString());  
				 //Set new values to the mail and phone number of the student
				 obj1.setEname(nm1);
				 obj1.setEsal(sal2);
				 	//Update the student record
				 mapper.update(obj1);
				 System.out.println("Record updated successfully");      
                 break;
                 
			 case 3: 
				 //Get data by id
				 System.out.println("Enter Employee id");
				 int id1 = scan.nextInt();
				 Employee obj11 = mapper.getByEid(id1);
				 System.out.println(obj11);
				 break;
    
			 case 4: 
				 //DELETE
				 System.out.println("Enter Employee id");
				 int id12 = scan.nextInt();
				 mapper.delete(id12);
				 System.out.println("record deleted successfully");  
				 break;
    
			 case 5: 
			        //get all data
    
				 List<Employee> std = mapper.getAll();
				 for(Employee s : std)
					 System.out.println(s); 
				 break;      
			 }		        
		        session.commit();
		        scan.close();
		        session.close();
		  } 
		 catch (IOException e) {
		   e.printStackTrace();  }
	}

}
