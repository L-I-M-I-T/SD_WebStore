package web;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import web.User;
import web.Admin;

public class DAO 
{
    public User login(Connection connection,User user) throws Exception
    {
        User resultUser=null;
        String sql="select * from user_info where user_name=? and user_password=?";
        PreparedStatement Action=connection.prepareStatement(sql);
        Action.setString(1, user.get_user_name());
        Action.setString(2, user.get_user_password());
        ResultSet rs=Action.executeQuery();
        if(rs.next())
        {
            resultUser=new User();
            resultUser.set_user_name(rs.getString("user_name"));
            resultUser.set_user_password(rs.getString("user_password"));
            rs.close();
        }
        return resultUser;
    }
    public ResultSet show(Connection connection,String id) throws Exception
    {
        String sql="select * from user_info where user_id=?";
        PreparedStatement Action=connection.prepareStatement(sql);
        Action.setString(1, id);
        ResultSet rs=Action.executeQuery();
        return rs;
    }
    public ResultSet show2(Connection connection,String id) throws Exception
    {
        String sql="select * from admin_info where admin_id=?";
        PreparedStatement Action=connection.prepareStatement(sql);
        Action.setString(1, id);
        ResultSet rs=Action.executeQuery();
        return rs;
    }
    public Admin login2(Connection connection,Admin admin) throws Exception
    {
        Admin resultAdmin=null;
        String sql="select * from admin_info where admin_name=? and pwd=?";
        PreparedStatement Action=connection.prepareStatement(sql);
        Action.setString(1, admin.get_admin_name());
        Action.setString(2, admin.get_pwd());
        ResultSet rs=Action.executeQuery();
        if(rs.next())
        {
            resultAdmin=new Admin();
            resultAdmin.set_admin_name(rs.getString("admin_name"));
            resultAdmin.set_pwd(rs.getString("pwd"));
            rs.close();
        }
        return resultAdmin;
    }
    public boolean register(Connection connection,User user) throws Exception
    {
        PreparedStatement Action=null;
        String sql="select * from user_info where user_name=?";
        Action=connection.prepareStatement(sql);
        Action.setString(1, user.get_user_name());
        ResultSet rs=Action.executeQuery();
        if (rs.next())
        {
        	rs.close();
        	return false;
        }
        sql="insert into user_info (user_name,user_password,realname,sex,address,question,answer,email,favorate,score,regdate)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        Action = connection.prepareStatement(sql);
        if (user.get_user_name().contentEquals(""))
        	Action.setNull(1, java.sql.Types.VARCHAR);
        else
        	Action.setString(1, user.get_user_name());
        if (user.get_user_password().contentEquals(""))
        	Action.setNull(2, java.sql.Types.VARCHAR);
        else
        	Action.setString(2, user.get_user_password());
        if (user.get_realname().contentEquals(""))
        	Action.setNull(3, java.sql.Types.VARCHAR);
        else
        	Action.setString(3, user.get_realname());
        if (user.get_sex().contentEquals(""))
        	Action.setNull(4, java.sql.Types.VARCHAR);
        else
        	Action.setString(4, user.get_sex());
        if (user.get_address().contentEquals(""))
        	Action.setNull(5, java.sql.Types.VARCHAR);
        else
        	Action.setString(5, user.get_address());
        if (user.get_question().contentEquals(""))
        	Action.setNull(6, java.sql.Types.VARCHAR);
        else
        	Action.setString(6, user.get_question());
        if (user.get_answer().contentEquals(""))
        	Action.setNull(7, java.sql.Types.VARCHAR);
        else
        	Action.setString(7, user.get_answer());
        if (user.get_email().contentEquals(""))
        	Action.setNull(8, java.sql.Types.VARCHAR);
        else
        	Action.setString(8, user.get_email());
        if (user.get_favorate().contentEquals(""))
        	Action.setNull(9, java.sql.Types.VARCHAR);
        else
        	Action.setString(9, user.get_favorate());
        Action.setInt(10, user.get_score());
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Action.setString(11, sdf.format(dt));
        Action.executeUpdate();
        return true;
    }
    public int delete(Connection connection,String id) throws Exception
    {
        String sql="delete from user_info where user_id=?";
        PreparedStatement Action=connection.prepareStatement(sql);
        Action.setString(1, id);
        int rs=Action.executeUpdate();
        return rs;
    }
    public void update(Connection connection,User user,String id) throws Exception
    {
    	 PreparedStatement Action=null;
        String sql="update user_info SET user_name=?,user_password=?,realname=?,sex=?,address=?,question=?,answer=?,email=?,favorate=?,score=?,regdate=? where user_id=? ";
        Action = connection.prepareStatement(sql);
        if (user.get_user_name().contentEquals(""))
        	Action.setNull(1, java.sql.Types.VARCHAR);
        else
        	Action.setString(1, user.get_user_name());
        if (user.get_user_password().contentEquals(""))
        	Action.setNull(2, java.sql.Types.VARCHAR);
        else
        	Action.setString(2, user.get_user_password());
        if (user.get_realname().contentEquals(""))
        	Action.setNull(3, java.sql.Types.VARCHAR);
        else
        	Action.setString(3, user.get_realname());
        if (user.get_sex().contentEquals(""))
        	Action.setNull(4, java.sql.Types.VARCHAR);
        else
        	Action.setString(4, user.get_sex());
        if (user.get_address().contentEquals(""))
        	Action.setNull(5, java.sql.Types.VARCHAR);
        else
        	Action.setString(5, user.get_address());
        if (user.get_question().contentEquals(""))
        	Action.setNull(6, java.sql.Types.VARCHAR);
        else
        	Action.setString(6, user.get_question());
        if (user.get_answer().contentEquals(""))
        	Action.setNull(7, java.sql.Types.VARCHAR);
        else
        	Action.setString(7, user.get_answer());
        if (user.get_email().contentEquals(""))
        	Action.setNull(8, java.sql.Types.VARCHAR);
        else
        	Action.setString(8, user.get_email());
        if (user.get_favorate().contentEquals(""))
        	Action.setNull(9, java.sql.Types.VARCHAR);
        else
        	Action.setString(9, user.get_favorate());
        Action.setInt(10, user.get_score());
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Action.setString(11, sdf.format(dt));
        Action.setString(12, id);
        Action.executeUpdate();
    }
    public void update2(Connection connection,String id,String role) throws Exception
    {
    	PreparedStatement Action=null;
        String sql="update admin_info SET role=? where admin_id=?";
        Action = connection.prepareStatement(sql);
        Action.setString(1, role);
        Action.setString(2, id);
        Action.executeUpdate();
    }
    public ResultSet Query(Connection connection) throws Exception
    {
    	String sql="select * from user_info";
    	PreparedStatement Action=connection.prepareStatement(sql);
    	ResultSet rs=Action.executeQuery();
    	return rs;
    }
    public ResultSet Query2(Connection connection) throws Exception
    {
    	String sql="select * from admin_info";
    	PreparedStatement Action=connection.prepareStatement(sql);
    	ResultSet rs=Action.executeQuery();
    	return rs;
    }
    public ResultSet find(Connection connection,String id) throws Exception
    {
    	String sql="select * from user_info where user_id="+id;
    	PreparedStatement Action=connection.prepareStatement(sql);
    	ResultSet rs=Action.executeQuery();
    	return rs;
    }
    public ResultSet find2(Connection connection,String id) throws Exception
    {
    	String sql="select * from admin_info where admin_id="+id;
    	PreparedStatement Action=connection.prepareStatement(sql);
    	ResultSet rs=Action.executeQuery();
    	return rs;
    }
    public boolean add(Connection connection,Admin admin) throws Exception
    {
        PreparedStatement Action=null;
        String sql="select * from admin_info where admin_name=?";
        Action=connection.prepareStatement(sql);
        Action.setString(1, admin.get_admin_name());
        ResultSet rs=Action.executeQuery();
        if (rs.next())
        {
        	rs.close();
        	return false;
        }
        sql="insert into admin_info (admin_name,pwd,role)VALUES(?,?,?)";
        Action = connection.prepareStatement(sql);
        if (admin.get_admin_name().contentEquals(""))
        	Action.setNull(1, java.sql.Types.VARCHAR);
        else
        	Action.setString(1, admin.get_admin_name());
        if (admin.get_pwd().contentEquals(""))
        	Action.setNull(2, java.sql.Types.VARCHAR);
        else
        	Action.setString(2, admin.get_pwd());
        if (admin.get_role().contentEquals(""))
        	Action.setNull(3, java.sql.Types.VARCHAR);
        else
        	Action.setString(3, admin.get_role());
        Action.executeUpdate();
        return true;
    }
}
 