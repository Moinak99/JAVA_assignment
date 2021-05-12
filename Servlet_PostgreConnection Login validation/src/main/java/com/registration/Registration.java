package com.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			try {
				try {
					  Connection c = null;
					  Statement stmt = null;
					   Class.forName("org.postgresql.Driver");
					   c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/moidb", "postgres", "1234");
					   stmt = c.createStatement();
					   String sql = "CREATE TABLE registration " 
					     + "(id SERIAL PRIMARY KEY  ,"
					     + " email           TEXT    NOT NULL, " 
					     + " password            TEXT     NOT NULL)";
					   stmt.executeUpdate(sql);
					   c.setAutoCommit(false);
					   stmt = c.createStatement();

				}
				catch (Exception e) {
					System.out.println("Table found!");
				}
				String email=request.getParameter("name"); 
				String password = request.getParameter("pass");
				  Connection c = null;
				  Statement stmt = null;
				  Class.forName("org.postgresql.Driver");
				  c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/moidb", "postgres", "1234");
				  c.setAutoCommit(false);
				  stmt = c.createStatement();  
				  String sql1=("INSERT INTO registration(email,password) VALUES('"+email+"','"+password+"');");
				  stmt.executeUpdate(sql1);
				  stmt.close();
				  c.commit();
				  c.close();
					System.out.println("Success");
				  response.sendRedirect("login.html");
				 
			}
			catch (Exception e) {
				System.out.println(e.getMessage());

			}
		}
	}


