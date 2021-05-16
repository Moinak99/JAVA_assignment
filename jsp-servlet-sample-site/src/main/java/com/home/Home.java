package com.home;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//String name = request.getAttribute("username").toString();
		
		String data = (String) request.getSession().getAttribute("aa");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");  
		System.out.println(data);
		
		out.println("<style>");     // start style
		  // enclose style attributes withing the <style> </style> elements
		  out.println("table {");        // note leading brace
		  out.println("overflow-y:scroll;");
		  out.println("height:100px;");
		  out.println("display:block;");
		  out.println("}");          // note trailing brace for h1 style
		  // add styles for other elements here using similar structure
		  // note that separate lines are used for clarity -
		  // all of the above could be one println
		  out.println("</style>");
			out.println("<h3>"+data+"</h3>");
		  out.println("<h1>LIST OF EMPLOYEES</h1>");
	
		
		
		try 
        {  
			Connection c = null;
			Statement stmt = null;
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/moidb", "postgres", "1234");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM myproj1;"); 
            out.println("<table border=1 width=40% height=1000%>");  
            out.println("<tr><th>First Name</th><th>Last Name</th><th>Email</th><th>Password</th><th>Address</th><th>Contact</th><tr>");  
            while (rs.next()) 
            {  
                String firstname = rs.getString("firstname");  
                String lastname = rs.getString("lastname");  
                String email = rs.getString("email");  
                String password = rs.getString("password");  
                String address = rs.getString("address");  
                String contact = rs.getString("contact");  
                out.println("<tr><td>" + firstname + "</td><td>" + lastname + "</td><td>" + email + "</td><td>" + password + "</td><td>" + address + "</td><td>" + contact + "</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            	c.commit(); 
			   rs.close();
			   stmt.close();
			   c.close();
           }  
            catch (Exception e) 
           {  
            out.println("error");  
        }  
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
