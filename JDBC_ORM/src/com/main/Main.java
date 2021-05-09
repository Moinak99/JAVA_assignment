package com.main;

import java.util.Scanner;

import com.employee.EmployeeModel;
import com.postgres.operations.ORM;

public class Main {

	public static void main(String[] args) {
		EmployeeModel empobj = new EmployeeModel();
		ORM cursor = new ORM();
		System.out.println(cursor.CreateTable());
		System.out.println("commands: 1. insert , 2. delete, 3. Update , 4. View");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
		
		switch (choice) {
		case "insert": {
			System.out.println("Enter Employee Name");
			String name = scan.nextLine();
			System.out.println("Enter Employee Age");
			int age = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter Employee Gender");
			String gender = scan.nextLine();
			System.out.println("Enter Employee Salary");
			Double sal = scan.nextDouble();		
			empobj.setEmpName(name);
			empobj.setEmpAge(age);
			empobj.setEmpGender(gender);
			empobj.setEmpSalary(sal);
			
			System.out.println(cursor.InsertData(empobj));
			break;

		}
		case "delete": {
			System.out.println("Enter Employee id to Delete:");
			int empId = scan.nextInt();
			
			empobj.setEmpId(empId);
			System.out.println(cursor.DeleteData(empobj));

			break;
			
		}
		case "update": {
			
			System.out.println("Enter Employee id");
			int empId = scan.nextInt();
			System.out.println("Enter new salary value");
			double salary = scan.nextDouble();
			
			empobj.setEmpId(empId);
			empobj.setEmpSalary(salary);
			
			System.out.println(cursor.UpdateData(empobj));
			break;
		}
		case "view": {
			System.out.println(cursor.ViewData());
			break;
		}
		default:
			System.out.println("Try running again");
		}
				
		scan.close();

	}

}
