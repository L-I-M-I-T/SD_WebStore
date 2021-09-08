package web;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
        String username=request.getParameter("username");
        String pwd=request.getParameter("password");
        String realname=request.getParameter("realname");
        if (realname=="null")
        	realname="";
        String sex=request.getParameter("sex");
        if (sex=="null")
        	sex="";
        String address=request.getParameter("address");
        if (address=="null")
        	address="";
        String question=request.getParameter("question");
        if (question=="null")
        	question="";
        String answer=request.getParameter("answer");
        if (answer=="null")
        	answer="";
        String favorate=request.getParameter("favorate");
        if (favorate=="null")
        	favorate="";
        String email=request.getParameter("email");
        if (email=="null")
        	email="";
        JDBC db= new JDBC();
        User user=new User(username,pwd,realname,sex,address,question,answer,favorate,email);
        DAO dao=new DAO();
        try 
        {
            Connection connection=db.getCon();
            dao.update(connection, user, request.getParameter("id"));
            response.sendRedirect("display.jsp");
            db.closeCon(connection);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
