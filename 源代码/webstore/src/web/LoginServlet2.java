package web;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.Admin;

@WebServlet("/LoginServlet2")
public class LoginServlet2 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
        String adname=request.getParameter("adname");
        String pwd=request.getParameter("pwd");
        JDBC db= new JDBC();
        Admin admin=new Admin(adname,pwd,null);
        DAO dao=new DAO();
        try 
        {
            Connection connection=db.getCon();
            if (dao.login2(connection, admin)!=null)
            {
                response.sendRedirect("display.jsp");
            }
            else 
            {
                response.sendRedirect("admin_fail.jsp");
            }
            db.closeCon(connection);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
