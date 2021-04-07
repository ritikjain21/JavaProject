//registration

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletDemo5 extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		String s1 = request.getParameter("un");
		String s2 = request.getParameter("ue");
		String s3 = request.getParameter("ucn");
		String s4 = request.getParameter("up");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String db_url="jdbc:mysql://localhost:3306/project_loginsignup?useSSL=false";
			String db_uname="root";
			String db_upass="root";
			Connection con =DriverManager.getConnection(db_url,db_uname,db_upass);
		     
			Statement st = con.createStatement();
			
			String q= "insert into users values ('"+s1+"' ,'"+s2+"','"+s3+"','"+s4+"')"; 
			st.executeUpdate(q);
			
			//redirect on login page
			response.sendRedirect("demologin.html");
			
			out.println("data inserteds");
			con.close();
		} 
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		out.println("</body>");
		out.println("</html>");
	}
}

//set classpath=C:\Program Files\Apache Software Foundation\Tomcat 8.5\lib\servlet-api.jar;.;%classpath%