package com.chemingyu.stuentmanagersystem.view;

import com.chemingyu.stuentmanagersystem.bean.Student;
import com.chemingyu.stuentmanagersystem.controller.StudentManager;
import com.chemingyu.stuentmanagersystem.util.*;

public class StudentView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����ı�����ķ���,��static����Ҫ�������
		StudentView studentView = new StudentView();
		studentView.MainMenu();
		
	}

	public void MainMenu(){
		/*   ����е����Զ���StudentManager�и�ֵ��
		Student[] students=new Student[10];//����10��ѧ��������
		int count=0;//��һ����ר�ż�¼�����Ƿ�Ϊ��
		int currentId=1;
		*/

		//����StudentManager���е�����
		StudentManager studentManager= new StudentManager();
		boolean flage=true;
	do{
		System.out.println("\n------------------ѧ����Ϣ����ϵͳ-----------------");
		System.out.println("                  1 ���ѧ��");
		System.out.println("                  2 �޸�ѧ��");
		System.out.println("                  3 ɾ��ѧ��");
		System.out.println("                  4 ѧ���б�");
		System.out.println("                  5 ��      ��");
		System.out.println("\t\t       ��ѡ��1��5��");
		
		char key = CMUtility.readMenuSelection();
		System.out.println();
		switch (key) {
		case '1':
			System.out.println("\n------------------���ѧ����Ϣ-----------------");
			System.out.print("������");
			String name=CMUtility.readString(4);
			System.out.print("���䣺");
			int    age=CMUtility.readInt();
			System.out.print("�Ա�");
			char   sex=CMUtility.readChar();
			System.out.print("�绰��");
			String phone=CMUtility.readString(11);
			System.out.print("email��");
			String email=CMUtility.readString(15);
			
			Student stu  =new Student(name,age,sex,phone,email);//�ù��������ֵ
			Boolean Flage=studentManager.addStudent(stu);//��boolean����ֵ
			if (Flage) {
				System.out.println("��ӳɹ�");
			}else {
				System.out.println("���ʧ��");
			}
			/*  ���ʵ���Ǵ洢��ӵ�ѧ��������addStudent()��������
			//Ϊÿ����������һ�����
			stu.setId(currentId);
			currentId++;
			
			//����һ������forѭ��������ÿ������Ԫ���Ƿ�Ϊ�գ�Ϊ�վͲ���ֵ
			for(int i=0;i<students.length;i++){
				if(students[i]==null){
					students[i]=liStudent;
					break;
				}
			}
			
			//����������count ��¼��������Ԫ�ر��,��stu�����洢
			students[count]=stu;
			count++;
			*/
			
			break;
		case '2':
			System.out.println("\n-----------------�޸�ѧ����Ϣ-----------------");
			System.out.println("\n-----------------����Ҫ�޸ĵ�ѧ�����-----------------");
			//����Ҫ֪��Ҫ�޸ĵ�ѧ�����
			int update_id=CMUtility.readInt();
			/*  �ҵ���Ŷ�Ӧ������
			for(int i=0;i<count;i++){
				if(update_id==students[i].getId()){
					update_index=i;
					break;
				}
			}
				*/
				//���ҵ�������ȡ����
				Student update_student = studentManager.findInfoById(update_id);
			if (update_student==null) {
				System.out.println("�ñ�Ų�����");
				
			}else{
			//�������޸ĵ�ѧ����Ϣ,�൱�����������Ԫ��
			System.out.print("��������"+update_student.getName()+")");
			name=CMUtility.readString(4,update_student.getName());
			System.out.print("���䣺��"+update_student.getAge()+")");
			age=CMUtility.readInt(update_student.getAge());
			System.out.print("�Ա𣺣�"+update_student.getSex()+")");
			sex=CMUtility.readChar(update_student.getSex());
			System.out.print("�绰����"+update_student.getPhone()+")");
			phone=CMUtility.readString(11,update_student.getPhone());
			System.out.print("email����"+update_student.getEmail()+")");
			email=CMUtility.readString(15,update_student.getEmail());
			
			//�������ֵ�ŵ�update_student������
			update_student.setName(name);
			update_student.setSex(sex);
			update_student.setAge(age);
			update_student.setEmail(email);
			update_student.setPhone(phone);
			
			}
			System.out.println("\n-------------------�޸����-----------------");
			break;
			
		case '3':
			System.out.println("\n-----------------ɾ��ѧ�����-----------------");
			System.out.println("������Ҫɾ����ѧ�����:");
			int id = CMUtility.readInt();
			//ɾ��ĳ��Ԫ��
			Boolean nBoolean =studentManager.deleteStudent(id);
			if (nBoolean) {
				System.out.println("��ɾ���ɹ�");
			}else {
				System.out.println("����ı�Ų���ȷ");
			}
			/*
			int index=-1;//-1���������±�ֵ
			//����Ҫ����id�ҵ�Ҫɾ����ѧ�����±�
			for(int i=0;i<count;i++){
				if(id==students[i].getId()){
					//���ҵ���Ԫ���±����������
					index=i;
					break;
				}
			}
			if(index!=-1){//˵���ҵ�ƥ����
				//���ҵ����±�֮���Ԫ��ȫ��ǰ�ƣ�����֮ǰ��ֵ
				for(int i=index;i<count;i++){
					students[i]=students[i+1];
					//�����һ��Ԫ����ֵΪ ��
					students[count]=null;
					
					//�����������һ������ЧԪ�ؼ�һ
					count--;
				}
			}else{
				System.out.println("������ı������");
			}
			*/
			break;
		case '4':
			System.out.println("\n------------------ѧ���б�-------------------");
			System.out.println("���\t����\t����\t�Ա�\t�绰\temail");
			Student[] all= studentManager.getAll();  //�÷�������һ������
			//�ѷ��ص��������,����getInfo()����չʾ
			for(int i=0;i<all.length;i++){
				System.out.println(all[i].getInfo());
			}
			/*
			for(int i=0;i<count;i++){//�˴�����Ӧ�ñ�������¼��ѧ����count����Ӧ����������ܳ���students.length
				//��ӡÿ�������Ԫ�أ�����Ҫ��students[i].getXX
				System.out.println(students[i].getId()+"\t"+students[i].getName()+"\t"+students[i].getAge()+"\t"+students[i].getSex()+"\t"+students[i].getPhone()+"\t"+students[i].getEmail());
			}
			*/
			break;
		case '5':
			System.out.println("\n---------------------ȷ��Ҫ�˳��𣿣�Y/N��-----------------");
			char yn= CMUtility.readConfirmSelection();
			if (yn=='Y') {
				//�˳��˵�ѭ��
				flage=false;
			}
			break;
		}
	}while(flage);
	
	
	}

}
