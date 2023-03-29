package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public update() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name = request.getParameter("name");
	String mobile = request.getParameter("mobile");
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data1","root","test");
		System.out.println(con);
		Statement stmnt = con.createStatement();
		stmnt.executeUpdate("UPDATE test SET mobile='"+mobile+"' WHERE name='"+name+"'");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}

}
