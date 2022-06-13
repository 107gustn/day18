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
			System.out.println("등록 아이디 입력 : ");
			id = sc.next();
			File path = new File("D:/1.오후_취업반/eclipse-jee-2022-03-R-win32-x86_64/" + id + ".txt");
			if ( path.exists() ) { //해당 위치에 접근할 수 있는지 //해당 파일이나 폴더가 존재시 true
				System.out.println("존재하는 아이디 입니다.");
			}else { //해당 파일이 없을 떄
				System.out.println("비밀번호 입력");
				pwd = sc.next();
				FileOutputStream fos = new FileOutputStream(path);
				fos.write(id.getBytes());
				fos.write(pwd.getBytes());
				System.out.println("등록되었습니다.");
				break;
			}
		}


	}
}
