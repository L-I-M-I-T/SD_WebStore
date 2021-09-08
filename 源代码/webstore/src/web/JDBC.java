package web;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC 
{
	private static String jdbcName="com.mysql.cj.jdbc.Driver";
	private static String dbUrl="jdbc:mysql://localhost:3306/wt2?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";	
	private static String dbUserName="root";
	private static String dbPassword="wangtian";
    public Connection getCon() throws Exception
    {
        Class.forName(jdbcName);
        Connection connection=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        return connection;
    }
    public void closeCon(Connection connection) throws Exception
    {
        if(connection!=null)
        {
            connection.close();
        }
    }
}
