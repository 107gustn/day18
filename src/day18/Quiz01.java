package day18;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String name, addr,  age;

		System.out.println("�̸� �Է� : ");
		name = sc.next();
		System.out.println("���� �Է� : ");
		age = sc.next();
		System.out.println("�ּ� �Է� : ");
		addr = sc.next();
		File path = new File("D:/1.����_�����/eclipse-jee-2022-03-R-win32-x86_64/abcd1234.txt");
		
		FileOutputStream fos = new FileOutputStream(path);
		
		fos.write(name.getBytes());
		fos.write(age.getBytes());
		fos.write(addr.getBytes());
		System.out.println("��ϵǾ����ϴ�.");

	}

}
