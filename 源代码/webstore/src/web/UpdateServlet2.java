package web;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
        String role=request.getParameter("role");
        if (role=="null")
        	role="";
        JDBC db= new JDBC();
        DAO dao=new DAO();
        try 
        {
            Connection connection=db.getCon();
            dao.update2(connection, request.getParameter("id"),role);
            response.sendRedirect("display3.jsp");
            db.closeCon(connection);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
