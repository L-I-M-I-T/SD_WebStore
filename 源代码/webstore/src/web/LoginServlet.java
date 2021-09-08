package web;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        JDBC db= new JDBC();
        User user=new User(username,password,null,null,null,null,null,null,null);
        DAO dao=new DAO();
        try 
        {
            Connection connection=db.getCon();
            if (dao.login(connection, user)!= null)
            {
                response.sendRedirect("user_login_success.jsp");
            }
            else 
            {
                response.sendRedirect("user_fail.jsp");
            }
            db.closeCon(connection);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
