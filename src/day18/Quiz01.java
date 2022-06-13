package day18;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String name, addr,  age;

		System.out.println("이름 입력 : ");
		name = sc.next();
		System.out.println("나이 입력 : ");
		age = sc.next();
		System.out.println("주소 입력 : ");
		addr = sc.next();
		File path = new File("D:/1.오후_취업반/eclipse-jee-2022-03-R-win32-x86_64/abcd1234.txt");
		
		FileOutputStream fos = new FileOutputStream(path);
		
		fos.write(name.getBytes());
		fos.write(age.getBytes());
		fos.write(addr.getBytes());
		System.out.println("등록되었습니다.");

	}

}
