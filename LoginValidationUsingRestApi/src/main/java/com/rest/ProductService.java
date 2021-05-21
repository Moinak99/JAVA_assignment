package com.rest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ws.rs.FormParam;  
import javax.ws.rs.POST;  
import javax.ws.rs.Path;  
import javax.ws.rs.core.Response;  
@Path("/product")  
public class ProductService{  
	  Connection c = null;
		Statement stmt = null;
    @POST  
    @Path("/add")  
    public Response addUser(  
        @FormParam("id") int id,  
        @FormParam("name") String name,  
        @FormParam("phone") long phone,
        @FormParam("address") String address,
        @FormParam("email") String email,
        @FormParam("pass") String pass) throws IOException {  
    	 Db();
    	 try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM myproj2 WHERE email = '" + email + "' AND password = '" + pass  + "'; ");
			if ( rs.next() ) {
				 stmt.close();
				  c.close();
				   } 
			else
			{
				  String sql1=("INSERT INTO myproj2(name,contact,address,email,password) VALUES('"+name+"','"+phone+"','"+address+"','"+email+"','"+pass+"');");
				  stmt.executeUpdate(sql1);
				  stmt.close();
				  c.close();
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	 
        return Response.status(200)  
            .entity(" Product added successfuly!")  
            .build();  
        
    }  
    public Boolean Db()
    {
    	try {
			   Class.forName("org.postgresql.Driver");
			   c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/moidb", "postgres", "1234");
			   stmt = c.createStatement();
			   String sql = "CREATE TABLE myproj2 " 
			     + "(id SERIAL PRIMARY KEY  ,"
			     + " name           TEXT    NOT NULL, " 
			     
			     + "email TEXT    NOT NULL  ,"
			     + "password TEXT    NOT NULL  ,"
			     + "address TEXT    NOT NULL  ,"
			     + " contact            BIGINT     NOT NULL)";
			   stmt.executeUpdate(sql);
			   c.setAutoCommit(false);
			   stmt = c.createStatement();  
			   return true;

		}
		catch (Exception e) {
			System.err.println("Table exists!");
			return false;
		}
    }
} 