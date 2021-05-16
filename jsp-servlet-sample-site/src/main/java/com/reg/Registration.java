package com.reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
     * Default constructor. 
     */
    public Registration() {
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
			   String sql = "CREATE TABLE myproj1 " 
			     + "(id SERIAL PRIMARY KEY  ,"
			     + " firstname           TEXT    NOT NULL, " 
			     + "lastname TEXT    NOT NULL  ,"
			     + "email TEXT    NOT NULL  ,"
			     + "password TEXT    NOT NULL  ,"
			     + "address TEXT    NOT NULL  ,"
			     + " contact            BIGINT     NOT NULL)";
			   stmt.executeUpdate(sql);
			   c.setAutoCommit(false);
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
		//doGet(request, response);
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		try {
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM myproj1 WHERE email = '" + email + "' AND password = '" + pass  + "'; ");
			if ( rs.next() ) {
			
				PrintWriter out = response.getWriter();  
//				response.setContentType("text/html");  
//				out.println("<script type=\"text/javascript\">");  
//				out.println("alert('Account Already Exists! Redirecting to login page..');");  
//				out.println("</script>");
				 stmt.close();
				  //c.commit();
				  c.close();
				 response.sendRedirect("login.jsp");

				   } 
			else
			{
				  String sql1=("INSERT INTO myproj1(firstname,lastname,email,password,address,contact) VALUES('"+fname+"','"+lname+"','"+email+"','"+pass+"','"+address+"',"+contact+");");
				  stmt.executeUpdate(sql1);
				  PrintWriter out = response.getWriter();  
//				  response.setContentType("text/html");  
//				  out.println("<script type=\"text/javascript\">");  
//				  out.println("alert('Registration Success');");  
//				  out.println("</script>");
				  stmt.close();
				  //c.commit();
				  c.close();
				  response.sendRedirect("login.jsp");
				 
			}
			
			 
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
