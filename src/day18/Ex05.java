package day18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex05 {
	public static void main(String[] args) throws Exception {
		File path = new File("D:/1.오후_취업반/eclipse-jee-2022-03-R-win32-x86_64/aaa.txt");
		FileOutputStream fos = new FileOutputStream(path); //기본 스트림
		BufferedOutputStream bos = new BufferedOutputStream(fos); //보조 스트림
		DataOutputStream dos = new DataOutputStream(bos); //여러가지 값을 처리해주는 스트림
		
		String s = "안녕하세요";
		dos.writeUTF(s);
		
		dos.close(); //역순으로 스트림을 닫아줌
		bos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream(path);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		String str = dis.readUTF(); //문자열 처리
		System.out.println("가져온 내용 : " + str);
		
		dis.close();
		bis.close();
		fis.close();
	}
}
