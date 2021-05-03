import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Search extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		String s1 = request.getParameter("u1");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Search</title><link rel='stylesheet' href='xyz.css'></head><body><table cellpadding='10px'><th><h1>Show All Data</h1></th>");
	
		
		try
		{
			Class.forName ("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection (
				"jdbc:mysql://localhost:3306/project_loginsignup?allowPublicKeyRetrieval=true&useSSL=false",
				"root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery ("select * from marks where (ENROLL='"+s1+"')");
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