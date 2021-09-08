package web;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String realname=request.getParameter("realname");
        String sex=request.getParameter("sex");
        String address=request.getParameter("address");
        String question=request.getParameter("question");
        String answer=request.getParameter("answer");
        String email=request.getParameter("email");
        String favorate=request.getParameter("favorate");
        JDBC db= new JDBC();
        User user=new User(username,password,realname,sex,address,question,answer,email,favorate);
        DAO dao=new DAO();
        try 
        {
            Connection connection=db.getCon();
            if (dao.register(connection,user)) 
            {
                response.sendRedirect("user_register_success.jsp");
            }
            else 
            {
                response.sendRedirect("user_register_fail.jsp");
            }
            db.closeCon(connection);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    
    }
}
