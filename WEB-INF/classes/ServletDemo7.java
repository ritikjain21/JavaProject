//login 

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletDemo7 extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		String s1 = request.getParameter("un");
		String s2 =request.getParameter("up");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_loginsignup","root","root");
			
			Statement st = con.createStatement();
			
			String q = "select * from users where (UNAME='"+s1+"' AND UPASS='"+s2+"') ";
			
			ResultSet rs = st.executeQuery(q);
			
			if(rs.next())
			{
				response.sendRedirect("menu.html");
			}
		    else
			{
				response.sendRedirect("demologin.html");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("</body>");
		out.println("</html>");
	}
}