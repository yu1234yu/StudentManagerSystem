package com.chemingyu.stuentmanagersystem.controller;

import com.chemingyu.stuentmanagersystem.bean.Student;

public class StudentManager {
	//存储学生的信息
	//添加、修改、删除、查找
	
	private Student[] liStudents =new Student[10];
	private int count=0;
	private int currentId=1;
	
	//创建初始化数据
	public StudentManager(){
		liStudents[0]=new Student(currentId++,"张三",22,'男',"2647846","1414@scacom");
		count++;
	}
	
	public Boolean addStudent(Student stu){
		if (count>=liStudents.length) {
			return false;
			
		}
		
		
		stu.setId(currentId++);
		currentId++;
		
		liStudents[count]=stu;
		count++;
		
		return true;
	}
	
	public Boolean deleteStudent(int id){
		int index=-1;
	
		for(int i=0;i<count;i++){
			if(id==liStudents[i].getId()){
				index=i;
				break;
			}
		}
		if(index!=-1){
			for(int i=index;i<count;i++){
				liStudents[i]=liStudents[i+1];
			}
			liStudents[count--]=null;
			return true;
		}else{
			return false;
		}
	}
	
	
	
	public Student findInfoById(int id){
		//判断编号边界
		if (id<0 || id>currentId) {
			return null;
		}
		//查找对应数组
		for(int i=0;i<count;i++){
			if (id== liStudents[i].getId()) {
				return liStudents[i];
			}
		}
		return null;
	}
	
	
	public Student[] getAll(){
		//界面要展示 count个数组，必须要返回值
		//需创建一个新数组接收传递的所有的数组，返回新数组
		Student[] result = new Student[count];
		for(int i=0;i<count;i++){
			result[i]=liStudents[i];
		}
		return result;
	}
	
}
