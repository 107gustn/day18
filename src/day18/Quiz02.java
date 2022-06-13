package day18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Student implements Serializable {
	String name, age, kor, math, eng;
	char grade;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math;
	}
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
}

public class Quiz02 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		String name = null, age, kor, math, eng;
		char grade = 0;
		int sum;
		boolean flag = true;

		String path = "D:/1.����_�����/eclipse-jee-2022-03-R-win32-x86_64/student/";

		Student st =  new Student();
		
		while (flag) {
			System.out.println("1.�߰�");
			System.out.println("2.����");
			System.out.println("3.����");
			System.out.println("4.�˻�");
			System.out.println("5.����");
			System.out.print(">>>> ");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:
				System.out.print("�̸� �Է� : ");
				name = sc.next();
				System.out.print("���� �Է� : ");
				age = sc.next();
				System.out.print("���� ���� : ");
				kor = sc.next();
				System.out.print("���� ���� : ");
				math = sc.next();
				System.out.print("���� ���� : ");
				eng = sc.next();

				sum = (Integer.parseInt(kor) + Integer.parseInt(math) + Integer.parseInt(eng)) / 3;
				if (sum >= 80) {
					grade = 'A';
				} else if (sum < 80 && sum >= 60) {
					grade = 'B';
				} else if (sum < 60 && sum >= 40) {
					grade = 'C';
				} else {
					grade = 'D';
				}

				st = new Student();
				st.setName(name);
				st.setAge(age);
				st.setKor(kor);
				st.setMath(math);
				st.setEng(eng);
				st.setGrade(grade);

				File path02 = new File(path + name + ".txt");
				FileOutputStream fos = new FileOutputStream(path02);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos);
				oos.writeObject(st);

				oos.close();
				bos.close();
				fos.close();
				System.out.println("���� �Ǿ����ϴ�.\n");

				break;
			case 2:
				File list = new File(path);
				String[] li = list.list();
				for( String a : li) {
					System.out.println(a);
				}
				
				System.out.print("�˻��� �̸� �Է� : ");
				name = sc.next();
				File p = new File(path + name + ".txt");
				
				if ( p.exists() ) {
					System.out.print("���� �Է� : ");
					age = sc.next();
					System.out.print("���� ���� : ");
					kor = sc.next();
					System.out.print("���� ���� : ");
					math = sc.next();
					System.out.print("���� ���� : ");
					eng = sc.next();

					sum = (Integer.parseInt(kor) + Integer.parseInt(math) + Integer.parseInt(eng)) / 3;
					if (sum >= 80) {
						grade = 'A';
					} else if (sum < 80 && sum >= 60) {
						grade = 'B';
					} else if (sum < 60 && sum >= 40) {
						grade = 'C';
					} else {
						grade = 'D';
					}
					
					st = new Student();
					st.setName(name);
					st.setAge(age);
					st.setKor(kor);
					st.setMath(math);
					st.setEng(eng);
					st.setGrade(grade);

					path02 = new File(path + name + ".txt");
					fos = new FileOutputStream(path02);
					bos = new BufferedOutputStream(fos);
					oos = new ObjectOutputStream(bos);
					oos.writeObject(st);

					oos.close();
					bos.close();
					fos.close();
					System.out.println("���� �Ǿ����ϴ�.\n");
				}else {
					System.out.println("�������� �ʴ� �л��Դϴ�.\n");
				}
				break;
			case 3:
				list = new File(path);
				li = list.list();
				for( String a : li) {
					System.out.println(a);
				}
				
				System.out.println("������ �̸� �Է�");
				String dn = sc.next();
				
				p = new File(path + dn + ".txt");
				if ( p.exists() ) {
					p.delete();
					System.out.println(dn + ".txt ���� �Ϸ�\n");
				}else {
					System.out.println("�������� �ʴ� �л��Դϴ�.\n");
				}
				break;
			case 4:
				list = new File(path);
				li = list.list();
				for( String a : li) {
					System.out.println(a);
				}
				
				System.out.print("�˻��� �̸� �Է� : ");
				name = sc.next();
				p = new File(path + name + ".txt");
				if ( p.exists() ) {
					FileInputStream fis = new FileInputStream(p);
					BufferedInputStream bis = new BufferedInputStream(fis);
					ObjectInputStream ois = new ObjectInputStream(bis);
					
					st = (Student)ois.readObject();
					System.out.println("�̸� : " + st.getName());
					System.out.println("���� : " + st.getAge());
					System.out.println("���� : " + st.getKor());
					System.out.println("���� : " + st.getMath());
					System.out.println("���� : " + st.getEng());
					System.out.println("��� : " + st.getGrade());
					System.out.println("==============================\n");
					
					ois.close();
					bis.close();
					fis.close();
				}else {
					System.out.println("�������� �ʴ� �л��Դϴ�.\n");
				}
				break;
			case 5:
				System.out.println("�����մϴ�.");
				flag = false;
				break;
			default:
				System.out.println("�ٽ� ������.");
			}

		}
	}
}
