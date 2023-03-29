package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/All_read")
public class All_read extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public All_read() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.println("<table border='2'>");
		 out.println("<tr>");
		 out.println("<th><h2>Name</h2></th>");
		 
		 out.println("<th><h2>mobile</h2></th>");
		 
		 out.println("<th><h2>Age</h2></th>");
		 
		 
		 
		 out.println("</tr>");
		 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data1","root","test");
			System.out.println(con);
			Statement stmnt = con.createStatement();
			ResultSet result = stmnt.executeQuery("select * from test");
			
			while(result.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.println(result.getString(1));
				out.println("</td>");
				
				out.println("<td>");
				out.println(result.getString(2));
				out.println("</td>");
				
				out.println("<td>");
				out.println(result.getString(3));
				out.println("</td>");
				
				
				
				
				
				out.println("</tr>");
			}
			
			
			
		} catch (Exception e) {
		}
		out.println("</table>");
		
		}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
