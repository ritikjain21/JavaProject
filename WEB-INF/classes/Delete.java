import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Delete extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		String s1 = request.getParameter("u1");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_loginsignup","root","root"); 
			Statement st = con.createStatement();
			
			String q = "delete from marks where (ENROLL='"+s1+"')";
			st.executeUpdate(q);
	
			response.sendRedirect("ShowAll");
		    
			
			con.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("</body>");
		out.println("</html>");
	}
}
