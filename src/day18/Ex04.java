package day18;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Ex04 {
	public static void main(String[] args) throws Exception {
		File path = new File("D:/1.오후_취업반/eclipse-jee-2022-03-R-win32-x86_64/aaa.txt");
		FileOutputStream fos = new FileOutputStream(path); //기본 스트림
		BufferedOutputStream bos = new BufferedOutputStream(fos); //기본 스트림을 이용하여 보조 스트림을 만들음
		
		for(int i='1'; i<'9' ; i++) {
			//Thread.sleep(1000);
			bos.write(i); //보조 스트림에 출력
		}
		bos.flush(); //보조 스트림의 값을 전송시켜 비움.
		
		
	}
}
