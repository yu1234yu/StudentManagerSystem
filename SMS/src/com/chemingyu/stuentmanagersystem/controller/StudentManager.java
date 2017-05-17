package com.chemingyu.stuentmanagersystem.controller;

import com.chemingyu.stuentmanagersystem.bean.Student;

public class StudentManager {
	//�洢ѧ������Ϣ
	//��ӡ��޸ġ�ɾ��������
	
	private Student[] liStudents =new Student[10];
	private int count=0;
	private int currentId=1;
	
	//������ʼ������
	public StudentManager(){
		liStudents[0]=new Student(currentId++,"����",22,'��',"2647846","1414@scacom");
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
		//�жϱ�ű߽�
		if (id<0 || id>currentId) {
			return null;
		}
		//���Ҷ�Ӧ����
		for(int i=0;i<count;i++){
			if (id== liStudents[i].getId()) {
				return liStudents[i];
			}
		}
		return null;
	}
	
	
	public Student[] getAll(){
		//����Ҫչʾ count�����飬����Ҫ����ֵ
		//�贴��һ����������մ��ݵ����е����飬����������
		Student[] result = new Student[count];
		for(int i=0;i<count;i++){
			result[i]=liStudents[i];
		}
		return result;
	}
	
}
