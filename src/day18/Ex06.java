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

class AAA implements Serializable{ //객체를 바이트 형식으로 변환
	String name;
	String addr;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getAddr() { return addr; }
	public void setAddr(String addr) { this.addr = addr; }
}
public class Ex06 {
	public static void main(String[] args) throws Exception {
		//직렬화 - 객체를 바이트 형식으로 변환 //역직렬화 - 바이트 형식을 객체로 변환
		Scanner sc = new Scanner(System.in);
		String name, addr;
		
		System.out.println("1.저장");
		System.out.println("2.가져오기");
		int num = sc.nextInt();
		
		String path = "D:/1.오후_취업반/eclipse-jee-2022-03-R-win32-x86_64/";
		
		AAA info = null;
		
		if(num == 1) {
			System.out.println("이름 입력");
			name = sc.next();
			System.out.println("주소 입력");
			addr = sc.next();
			
			info = new AAA();
			info.setName(name);
			info.setAddr(addr);
			
			File path02 = new File(path + name + ".txt");
			FileOutputStream fos = new FileOutputStream(path02); //기본스트림
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos); //객체 출력 스트림
			oos.writeObject( info ); //객체 저장
			
			oos.close();
			bos.close();
			fos.close();
			System.out.println("저장 되었습니다.");
			
		}else {
			File list = new File(path); //해당위치값 목록을 가져옴
			String[] li = list.list(); //String형태의 배열로 들어옴
//			for(int i=0; i<li.length; i++) {
//				System.out.println(li[i]);
//			}
			for( String a : li ) {
				System.out.println(a);
			}
			System.out.println("확인할 이름 입력");
			name = sc.next();
			File p = new File(path + name + ".txt");
//			p.delete(); //파일 삭제
			
			FileInputStream fis = new FileInputStream(p); //기본스트림
			BufferedInputStream bis = new BufferedInputStream(fis); //보조스트림
			ObjectInputStream ois = new ObjectInputStream(bis); //객체스트림
			
			info = (AAA)ois.readObject(); //객체 형식으로 저장된 파일을 가져와서 읽어옴
			System.out.println("이름 : " + info.getName());
			System.out.println("주소 : " + info.getAddr());
		}
	}
}
