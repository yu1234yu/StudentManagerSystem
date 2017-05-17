package com.chemingyu.stuentmanagersystem.bean;

public class Student {

	//自增长编号，方便查找，删除
	private int id;
	private String name;
	private int    age;
	private char sex;
	private String phone;
	private String email;
	
	
	public Student() {
		
	}
	
	
	public Student(String name, int age, char sex, String phone, String email) {
		
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
	}



	public Student(int id, String name, int age, char sex, String phone, String email) {
		this(name,age,sex,phone,email);
		this.id = id;
	
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInfo(){
		return id+"\t"+name+"\t"+age+"\t"+sex+"\t"+phone+"\t"+email;
	}
	
}
