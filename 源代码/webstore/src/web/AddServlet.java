package web;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
        String adname=request.getParameter("adname");
        String pwd=request.getParameter("pwd");
        String role=request.getParameter("role");
      
        JDBC db= new JDBC();
        Admin admin=new Admin(adname,pwd,role);
        DAO dao=new DAO();
        try 
        {
            Connection connection=db.getCon();
            if (dao.add(connection,admin))
            {
                response.sendRedirect("add_success.jsp");
            }
            else
            {
            	response.sendRedirect("add_fail.jsp");
            }
            db.closeCon(connection);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    
    }
}
