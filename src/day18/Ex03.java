package day18;

import java.io.File;
import java.io.FileInputStream;

public class Ex03 {
	public static void main(String[] args) throws Exception {
		File path = new File("D:/1.오후_취업반/eclipse-jee-2022-03-R-win32-x86_64/aaa.txt");
		FileInputStream fis = new FileInputStream(path); //기본 스트림
		while(true) {
			Thread.sleep(1000);
			int res = fis.read(); //해당파일에서 문자 하나씩 읽어와서 저장
			//System.out.println("res : " + res);
			if(res < 0) //다 가져와서 가져올 것이 없으면 마지막의 -1(eof)을 가져옴
				break;
			System.out.println( (char)res ); //형변환
			
		}

	}

}
