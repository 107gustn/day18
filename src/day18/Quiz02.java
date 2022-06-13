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

		String path = "D:/1.오후_취업반/eclipse-jee-2022-03-R-win32-x86_64/student/";

		Student st =  new Student();
		
		while (flag) {
			System.out.println("1.추가");
			System.out.println("2.수정");
			System.out.println("3.삭제");
			System.out.println("4.검색");
			System.out.println("5.종료");
			System.out.print(">>>> ");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:
				System.out.print("이름 입력 : ");
				name = sc.next();
				System.out.print("나이 입력 : ");
				age = sc.next();
				System.out.print("국어 점수 : ");
				kor = sc.next();
				System.out.print("수학 점수 : ");
				math = sc.next();
				System.out.print("영어 점수 : ");
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
				System.out.println("저장 되었습니다.\n");

				break;
			case 2:
				File list = new File(path);
				String[] li = list.list();
				for( String a : li) {
					System.out.println(a);
				}
				
				System.out.print("검색할 이름 입력 : ");
				name = sc.next();
				File p = new File(path + name + ".txt");
				
				if ( p.exists() ) {
					System.out.print("나이 입력 : ");
					age = sc.next();
					System.out.print("국어 점수 : ");
					kor = sc.next();
					System.out.print("수학 점수 : ");
					math = sc.next();
					System.out.print("영어 점수 : ");
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
					System.out.println("수정 되었습니다.\n");
				}else {
					System.out.println("존재하지 않는 학생입니다.\n");
				}
				break;
			case 3:
				list = new File(path);
				li = list.list();
				for( String a : li) {
					System.out.println(a);
				}
				
				System.out.println("삭제할 이름 입력");
				String dn = sc.next();
				
				p = new File(path + dn + ".txt");
				if ( p.exists() ) {
					p.delete();
					System.out.println(dn + ".txt 삭제 완료\n");
				}else {
					System.out.println("존재하지 않는 학생입니다.\n");
				}
				break;
			case 4:
				list = new File(path);
				li = list.list();
				for( String a : li) {
					System.out.println(a);
				}
				
				System.out.print("검색할 이름 입력 : ");
				name = sc.next();
				p = new File(path + name + ".txt");
				if ( p.exists() ) {
					FileInputStream fis = new FileInputStream(p);
					BufferedInputStream bis = new BufferedInputStream(fis);
					ObjectInputStream ois = new ObjectInputStream(bis);
					
					st = (Student)ois.readObject();
					System.out.println("이름 : " + st.getName());
					System.out.println("나이 : " + st.getAge());
					System.out.println("국어 : " + st.getKor());
					System.out.println("수학 : " + st.getMath());
					System.out.println("영어 : " + st.getEng());
					System.out.println("등급 : " + st.getGrade());
					System.out.println("==============================\n");
					
					ois.close();
					bis.close();
					fis.close();
				}else {
					System.out.println("존재하지 않는 학생입니다.\n");
				}
				break;
			case 5:
				System.out.println("종료합니다.");
				flag = false;
				break;
			default:
				System.out.println("다시 고르세요.");
			}

		}
	}
}
