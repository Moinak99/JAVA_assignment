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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
			String email=request.getParameter("email"); 
			String password = request.getParameter("pass");
			Connection c = null;
			Statement stmt = null;
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/moidb", "postgres", "1234");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM captcha WHERE email = '" + email + "' AND password = '" + password  + "'; ");
			if ( rs.next() ) {
			
				System.out.println("Email and password Exists!");
				String email1 = rs.getString("email");
				request.getSession().setAttribute("aa", email1);
				response.sendRedirect("welcome.jsp");


				   } 
			else
			{
				System.out.println("Email and password dosen't Exists!");
				response.sendRedirect("login.jsp");

			}
			c.commit(); 
			   rs.close();
			   stmt.close();
			   c.close();

		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
