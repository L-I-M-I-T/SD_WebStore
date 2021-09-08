package web;

import java.util.Date;

public class User
{
	private String user_name;
	private String user_password;
	private String realname;
	private String sex;
	private String address;
	private String question;
	private String answer;
	private String email;
	private String favorate;
	private int score;
	private Date regdate;
	public User()
	{
		
	}
	public User(String user_name,String user_password,String realname,String sex,String address,String question,String answer,String email,String favorate)
	{
		this.user_name=user_name;
		this.user_password=user_password;
		this.realname=realname;
		this.sex=sex;
		this.address=address;
		this.question=question;
		this.answer=answer;
		this.email=email;
		this.favorate=favorate;
		this.user_password=user_password;
		this.score=0;
		this.regdate= new Date();
	}
	public String get_user_name()
	{
		return user_name; 
	}
	public String get_user_password()
	{
		return user_password;
	}
	public String get_realname()
	{
		return realname;
	}
	public String get_sex()
	{
		return sex;
	}
	public String get_address()
	{
		return address;
	}
	public String get_question()
	{
		return question;
	}
	public String get_answer()
	{
		return answer;
	}
	public String get_email()
	{
		return email;
	}
	public String get_favorate()
	{
		return favorate;
	}
	public int get_score()
	{
		return score;
	}
	public Date get_regdate()
	{
		return regdate;
	}
	public void set_user_name(String user_name)
	{
		this.user_name=user_name;
	}
	public void set_user_password(String user_password)
	{
		this.user_password=user_password;
	}
	public void set_realname(String realname)
	{
		this.realname=realname;
	}
	public void set_sex(String sex)
	{
		this.sex=sex;
	}
	public void set_address(String address)
	{
		this.address=address;
	}
	public void set_question(String question)
	{
		this.question=question;
	}
	public void set_answer(String answer)
	{
		this.answer=answer;
	}
	public void set_email(String email)
	{
		this.email=email;
	}
	public void set_favorate(String favorate)
	{
		this.favorate=favorate;
	}
}