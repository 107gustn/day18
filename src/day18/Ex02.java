package day18;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		String id = "abcd";
		String pwd = "333";
		while (true) {
			System.out.println("��� ���̵� �Է� : ");
			id = sc.next();
			File path = new File("D:/1.����_�����/eclipse-jee-2022-03-R-win32-x86_64/" + id + ".txt");
			if ( path.exists() ) { //�ش� ��ġ�� ������ �� �ִ��� //�ش� �����̳� ������ ����� true
				System.out.println("�����ϴ� ���̵� �Դϴ�.");
			}else { //�ش� ������ ���� ��
				System.out.println("��й�ȣ �Է�");
				pwd = sc.next();
				FileOutputStream fos = new FileOutputStream(path);
				fos.write(id.getBytes());
				fos.write(pwd.getBytes());
				System.out.println("��ϵǾ����ϴ�.");
				break;
			}
		}


	}
}
