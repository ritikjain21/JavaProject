//Showw all data or marks table

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ShowAll extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		PrintWriter out = response.getWriter ();
		out.println("<html><head><title>Login Page</title><link rel='stylesheet' href='xyz.css'></head><body><div class = 'menu'><ul><li> <a href='menu.html'>Home</a> </li><li> <a href='insert.html'>Insert</a> </li><li> <a href='delete.html'>Delete</a> </li><li> <a href='update.html'>Update</a> </li><li> <a href='ShowAll'>ShowAll</a> </li><li> <a href='login.html'>LogOut</a> </li></ul></div><div id='data'><center><form action = 'insert' ><table cellpadding='10px'><th><h1>Showing All Data</h1></th>");
					// <tr>
					// 	<td>Enter RollNo.</td> 
					// 	<td><input type="text" placeholder="Your Name" name="rno"></td>
					// </tr>
					// <tr>
					// 	<td>Enter Name</td> 
					// 	<td><input type="text" placeholder="Your Password" name="name"></td>
					// </tr>
					// <tr>
					// 	<td>Enter Physics Marks</td> 
					// 	<td><input type="text" placeholder="Physics Marks" name="P"></td>
					// </tr>
					// <tr>
					// 	<td>Enter Chemistry Marks</td> 
					// 	<td><input type="text" placeholder="Chemistry Marks" name="C"></td>
					// </tr>
					// <tr>
					// 	<td>Enter Mathematics Marks</td> 
					// 	<td><input type="text" placeholder="Mathematics Marks" name="M"></td>
					// </tr>
					// <tr>
					// 	<th colspan="2"><input type="submit" value="Insert" class="B"></th>	
					// </tr>

		try
		{
			Class.forName ("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection (
				"jdbc:mysql://localhost:3306/project_loginsignup?allowPublicKeyRetrieval=true&useSSL=false",
				"root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery ("select * from marks");
			out.println("<tr>");
			out.println("<td><u>Roll No.</u></td>");
			out.println("<th><u>Student Name.</u></th>");
			out.println("<th><u>Physics Marks</u></th>");
			out.println("<th><u>Chemistry Marks</u></th>");
			out.println("<th><u>Mathematics Marks</u></th>");
			out.println("</tr>");
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("</tr>");
			}
			con.close ();
		}catch (Exception e)
		{
			out.println (e);
		}
		out.println("</table></form></center></div></body></html>");
	}
}
			
//set classpath=C:\Program Files\Apache Software Foundation\Tomcat 8.5\lib\servlet-api.jar;.;%classpath%