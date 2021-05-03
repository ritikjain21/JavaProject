import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ServletUpdate extends HttpServlet
{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
       
	   
	   PrintWriter out=response.getWriter();
        out.println("<html>");
		//html css design
		//------------------------------------------------------------------------------------------
			out.println("<html><head><title>Login Page</title><link rel='stylesheet' href='xyz.css'></head><body><div class = 'menu'><ul><li> <a href='menu.html'>Home</a> </li><li> <a href='insert.html'>Insert</a> </li><li> <a href='delete.html'>Delete</a> </li><li> <a href='update.html'>Update</a> </li><li> <a href='ShowAll'>ShowAll</a> </li><li> <a href='login.html'>LogOut</a> </li></ul></div><div id='data'><center><form action = 'ShowAll' method='GET' ><table cellpadding='10px'><th><h1>Showing All Data</h1></th>");
	
          //-------------------------------------------------------------------------------------------
	 out.println("<center><table cellpadding='12px' width='500'>");
	    String s1=request.getParameter("u1");         
		try
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			String db_url="jdbc:mysql://localhost:3306/project_loginsignup?useSSL=false&allowPublicKeyRetrieval=true";
			String db_name="root";
			String db_pass="root";
			
			Connection con=DriverManager.getConnection(db_url,db_name,db_pass);
			 
			Statement st= con.createStatement();
			  String q="select * from marks where ENROLL='"+s1+"'";
			  ResultSet rs=st.executeQuery(q);
			 
				 
			 if(rs.next())
			 {
                             	 out.println("<caption style='color:white;font-weight:bold;font-size:25px;'>Update data here Here</caption><tr><td colspan='2'>Enter Roll</td><td colspan='2'><input type='text' style='background:gray;color:white;' name='u1' readOnly='false' value='"+rs.getString(1)+"'></td> </tr><tr><th colspan='5'></th></tr>");
        
                                 out.println("<tr><td>Enter Name</td><td colspan='2'><input type='text' name='u2'value='"+rs.getString(2)+"' ></td></tr><tr><td>Physics</td><td colspan='2'><input type='integer' name='u3'value='"+rs.getString(3)+"' ></td></tr><tr><td>Chemistry</td><td colspan='2'><input type='integer' name='u4' value='"+rs.getString(4)+"'></td></tr><tr><td>Maths</td><td colspan='2'><input type='integer' name='u5' value='"+rs.getString(5)+"'></td></tr><tr><th colspan='2'><input type='submit' value='Update' class='B'></th></tr>");
		  
	 		 } 
			 else
			 {
				 out.println("<>not found");
			 }
			 out.println("</table></center>");
			 out.println("</form>");
			con.close();
		 }
         catch(Exception e1)
		 {
			 out.println(e1);
		 }		 
		
		out.println("</body>");
		out.println("</html>");
	
	}

}