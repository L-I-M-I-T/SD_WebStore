package web;
public class Admin
{
	private String admin_name;
	private String pwd;
	private String role;
	public Admin()
	{
		
	}
	public Admin(String admin_name,String pwd,String role)
	{
		this.admin_name=admin_name;
		this.pwd=pwd;
		this.role=role;
	}
	public String get_admin_name()
	{
		return admin_name; 
	}
	public String get_pwd()
	{
		return pwd;
	}
	public String get_role()
	{
		return role;
	}
	public void set_admin_name(String admin_name)
	{
		this.admin_name=admin_name;
	}
	public void set_pwd(String pwd)
	{
		this.pwd=pwd;
	}
	public void set_role(String role)
	{
		this.role=role;
	}
}