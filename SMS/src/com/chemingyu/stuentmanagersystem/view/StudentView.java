package com.chemingyu.stuentmanagersystem.view;

import com.chemingyu.stuentmanagersystem.bean.Student;
import com.chemingyu.stuentmanagersystem.controller.StudentManager;
import com.chemingyu.stuentmanagersystem.util.*;

public class StudentView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//调用文本界面的方法,非static，需要对象调用
		StudentView studentView = new StudentView();
		studentView.MainMenu();
		
	}

	public void MainMenu(){
		/*   这块中的属性都在StudentManager中赋值过
		Student[] students=new Student[10];//创建10个学生的数组
		int count=0;//用一个数专门记录数组是否为空
		int currentId=1;
		*/

		//调用StudentManager类中的属性
		StudentManager studentManager= new StudentManager();
		boolean flage=true;
	do{
		System.out.println("\n------------------学生信息管理系统-----------------");
		System.out.println("                  1 添加学生");
		System.out.println("                  2 修改学生");
		System.out.println("                  3 删除学生");
		System.out.println("                  4 学生列表");
		System.out.println("                  5 退      出");
		System.out.println("\t\t       请选择（1—5）");
		
		char key = CMUtility.readMenuSelection();
		System.out.println();
		switch (key) {
		case '1':
			System.out.println("\n------------------添加学生信息-----------------");
			System.out.print("姓名：");
			String name=CMUtility.readString(4);
			System.out.print("年龄：");
			int    age=CMUtility.readInt();
			System.out.print("性别：");
			char   sex=CMUtility.readChar();
			System.out.print("电话：");
			String phone=CMUtility.readString(11);
			System.out.print("email：");
			String email=CMUtility.readString(15);
			
			Student stu  =new Student(name,age,sex,phone,email);//用构造参数赋值
			Boolean Flage=studentManager.addStudent(stu);//有boolean返回值
			if (Flage) {
				System.out.println("添加成功");
			}else {
				System.out.println("添加失败");
			}
			/*  这块实际是存储添加的学生，调用addStudent()方法代替
			//为每个数组设置一个编号
			stu.setId(currentId);
			currentId++;
			
			//方法一：利用for循环，遍历每个数组元素是否为空，为空就插入值
			for(int i=0;i<students.length;i++){
				if(students[i]==null){
					students[i]=liStudent;
					break;
				}
			}
			
			//方法二：用count 记录已用数组元素编号,把stu挨个存储
			students[count]=stu;
			count++;
			*/
			
			break;
		case '2':
			System.out.println("\n-----------------修改学生信息-----------------");
			System.out.println("\n-----------------输入要修改的学生编号-----------------");
			//首先要知道要修改的学生编号
			int update_id=CMUtility.readInt();
			/*  找到编号对应的数组
			for(int i=0;i<count;i++){
				if(update_id==students[i].getId()){
					update_index=i;
					break;
				}
			}
				*/
				//把找到的数组取出来
				Student update_student = studentManager.findInfoById(update_id);
			if (update_student==null) {
				System.out.println("该编号不存在");
				
			}else{
			//输入新修改的学生信息,相当于再添加数组元素
			System.out.print("姓名：（"+update_student.getName()+")");
			name=CMUtility.readString(4,update_student.getName());
			System.out.print("年龄：（"+update_student.getAge()+")");
			age=CMUtility.readInt(update_student.getAge());
			System.out.print("性别：（"+update_student.getSex()+")");
			sex=CMUtility.readChar(update_student.getSex());
			System.out.print("电话：（"+update_student.getPhone()+")");
			phone=CMUtility.readString(11,update_student.getPhone());
			System.out.print("email：（"+update_student.getEmail()+")");
			email=CMUtility.readString(15,update_student.getEmail());
			
			//把输入的值放到update_student对象中
			update_student.setName(name);
			update_student.setSex(sex);
			update_student.setAge(age);
			update_student.setEmail(email);
			update_student.setPhone(phone);
			
			}
			System.out.println("\n-------------------修改完成-----------------");
			break;
			
		case '3':
			System.out.println("\n-----------------删除学生编号-----------------");
			System.out.println("请输入要删除的学生编号:");
			int id = CMUtility.readInt();
			//删除某个元素
			Boolean nBoolean =studentManager.deleteStudent(id);
			if (nBoolean) {
				System.out.println("已删除成功");
			}else {
				System.out.println("输入的编号不正确");
			}
			/*
			int index=-1;//-1不可能是下标值
			//首先要根据id找到要删除的学生的下标
			for(int i=0;i<count;i++){
				if(id==students[i].getId()){
					//把找到的元素下标给第三个数
					index=i;
					break;
				}
			}
			if(index!=-1){//说明找到匹配编号
				//把找到的下标之后的元素全部前移，覆盖之前的值
				for(int i=index;i<count;i++){
					students[i]=students[i+1];
					//把最后一个元数赋值为 空
					students[count]=null;
					
					//数组个数减少一个，有效元素减一
					count--;
				}
			}else{
				System.out.println("你输入的编号有误");
			}
			*/
			break;
		case '4':
			System.out.println("\n------------------学生列表-------------------");
			System.out.println("编号\t姓名\t年龄\t性别\t电话\temail");
			Student[] all= studentManager.getAll();  //该方法返回一个数组
			//把返回的数组遍历,调用getInfo()方法展示
			for(int i=0;i<all.length;i++){
				System.out.println(all[i].getInfo());
			}
			/*
			for(int i=0;i<count;i++){//此处遍历应该遍历到记录的学生数count，不应该是数组的总长度students.length
				//打印每个数组的元素，所以要用students[i].getXX
				System.out.println(students[i].getId()+"\t"+students[i].getName()+"\t"+students[i].getAge()+"\t"+students[i].getSex()+"\t"+students[i].getPhone()+"\t"+students[i].getEmail());
			}
			*/
			break;
		case '5':
			System.out.println("\n---------------------确定要退出吗？（Y/N）-----------------");
			char yn= CMUtility.readConfirmSelection();
			if (yn=='Y') {
				//退出菜单循环
				flage=false;
			}
			break;
		}
	}while(flage);
	
	
	}

}
