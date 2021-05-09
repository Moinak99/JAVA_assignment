package com.postgres.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.employee.EmployeeModel;

public class ORM {
	
	public String CreateTable()
	{
		try {
			  Connection c = null;
			  Statement stmt = null;
			   Class.forName("org.postgresql.Driver");
			   c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/moidb", "postgres", "1234");
			   stmt = c.createStatement();
			   String sql = "CREATE TABLE employee " 
			     + "(empId SERIAL PRIMARY KEY  ,"
			     + " empName           TEXT    NOT NULL, " 
			     + " empAge            INT     NOT NULL, "
			     + " empGender        TEXT, " 
			     + " empSalary         REAL)";
			   stmt.executeUpdate(sql);
			   c.setAutoCommit(false);
			   stmt = c.createStatement();
			   return "table created";
		}
		catch (Exception e) {
			return(e.getMessage());
		}
	}
	
	
	public String InsertData(EmployeeModel emobj) {
		try {
			System.out.println("Hello");
			  Connection c = null;
			  Statement stmt = null;
			  Class.forName("org.postgresql.Driver");
			  c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/moidb", "postgres", "1234");
			  c.setAutoCommit(false);
			  stmt = c.createStatement();  
			  String sql1=("INSERT INTO employee(empName,empAge,empGender,empSalary) VALUES('"+emobj.getEmpName()+"','"+emobj.getEmpAge()+"','"+emobj.getEmpGender()+"','"+emobj.getEmpSalary()+"');");
			  stmt.executeUpdate(sql1);
			  stmt.close();
			  c.commit();
			  c.close();
			  return "Data Inserted";
		}
		
		catch (Exception e) {
			return e.getMessage();
		}
	}
		
		public String DeleteData(EmployeeModel emobj) {
			try {
				Connection c = null;
				Statement stmt = null;
				Class.forName("org.postgresql.Driver");
				c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/moidb", "postgres", "1234");
				System.out.println("Opened database successfully");
				c.setAutoCommit(false);
				stmt = c.createStatement();
				String sql = "DELETE from employee where empId = " + emobj.getEmpId() + "; ";
				stmt.executeUpdate(sql);
				c.commit();
				ResultSet rs = stmt.executeQuery( "SELECT * FROM employee;" );
				while ( rs.next() ) {
				int empid = rs.getInt("empId");
				String  name = rs.getString("empName");
				int age  = rs.getInt("empAge");
				String  gender = rs.getString("empGender");
				float salary = rs.getFloat("empSalary");
				System.out.print( " ID = " + empid +"   NAME = " + name + "  AGE = " + age + "  Gender = " + gender + "  SALARY = " + salary );
				System.out.println();
				}  
				   rs.close();
				   stmt.close();
				   c.close();
					return "Success";

			}
			
			catch (Exception e) {
				return e.getMessage();
			}
		}
			
			public String UpdateData(EmployeeModel emobj) {
				try {
					Connection c = null;
					Statement stmt = null;
					Class.forName("org.postgresql.Driver");
					c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/moidb", "postgres", "1234");
					System.out.println("Opened database successfully");
					c.setAutoCommit(false);
					stmt = c.createStatement();
					String sql = "UPDATE employee set empSalary = " + emobj.getEmpSalary() + " where empId = " + emobj.getEmpId() + ";";
					stmt.executeUpdate(sql);
					c.commit();
					ResultSet rs = stmt.executeQuery( "SELECT * FROM employee;" );
					while ( rs.next() ) {
					int empid = rs.getInt("empId");
					String  name = rs.getString("empName");
					int age  = rs.getInt("empAge");
					String  gender = rs.getString("empGender");
					float salary = rs.getFloat("empSalary");
					System.out.print( " ID = " + empid +"   NAME = " + name + "  AGE = " + age + "  Gender = " + gender + "  SALARY = " + salary );
					System.out.println();
					          }  
					   rs.close();
					   stmt.close();
					   c.close();
						return "Success";

				}
				
				catch (Exception e) {
					return e.getMessage();
				}
			}
			
			
			public String ViewData()
			{
				try {
					Connection c = null;
					Statement stmt = null;
					Class.forName("org.postgresql.Driver");
					c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/moidb", "postgres", "1234");
					System.out.println("Opened database successfully");
					c.setAutoCommit(false);
					stmt = c.createStatement();
					ResultSet rs = stmt.executeQuery( "SELECT * FROM employee;" );
					while ( rs.next() ) {
					int empid = rs.getInt("empId");
					String  name = rs.getString("empName");
					int age  = rs.getInt("empAge");
					String  gender = rs.getString("empGender");
					float salary = rs.getFloat("empSalary");
					System.out.print( " ID = " + empid +"   NAME = " + name + "  AGE = " + age + "  Gender = " + gender + "  SALARY = " + salary );
					System.out.println();
					   }  
					   rs.close();
					   stmt.close();
					   c.close();
						return "Success";
					
				} catch (Exception e) {
					return e.getMessage();
				}
			}
			
			
	}


