package com.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection c = null;
	Statement stmt = null;
	public void init(ServletConfig config) throws ServletException {
		try {
			   Class.forName("org.postgresql.Driver");
			   c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/moidb", "postgres", "1234");
			   stmt = c.createStatement();
			   String sql = "CREATE TABLE captcha " 
			     + "(id SERIAL PRIMARY KEY  ,"
			     + " email           TEXT    NOT NULL, " 
			     + "password TEXT    NOT NULL)";
			   stmt.executeUpdate(sql);
			   //c.setAutoCommit(false);
			   stmt = c.createStatement();  

		}
		catch (Exception e) {
			System.err.println("Table exists!");
		}
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
		String email = request.getParameter("email");
		String pass = request.getParameter("psw");
		try {
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM captcha WHERE email = '" + email + "' AND password = '" + pass  + "'; ");
			if ( rs.next() ) {	
				 stmt.close();
				  c.close();
				 response.sendRedirect("login.jsp");
				   } 
			else
			{
				  String sql1=("INSERT INTO captcha(email,password) VALUES('"+email+"','"+pass+"');");
				  stmt.executeUpdate(sql1);
				  
				  //c.commit();
				  c.close();
				  stmt.close();
				  response.sendRedirect("login.jsp");
				 
			}
			
			 
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
