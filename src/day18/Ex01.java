package day18;

import java.io.File;
import java.io.FileOutputStream;

/*
파일입출력
- 이미지&파일 업로드, 다운로드
- 디스크에 저장하는 방식
- 영구저장을 하기위해 사용
*/
public class Ex01 {
	public static void main(String[] args) throws Exception {
		File path = new File("D:/1.오후_취업반/eclipse-jee-2022-03-R-win32-x86_64/aaa.txt"); //경로설정 : (파일 위치정보)
		//stream : 연결통로
		FileOutputStream os = new FileOutputStream(path);//가장 기본이 되는 스트림 //해당하는 위치에 해당파일이 없으면 새롭게 파일 생성
		os.write('A');// 파일 글 작성
		os.write(97);
		
		String s = "hello";
		os.write( s.getBytes() ); //문자열을 byte 단위로 변환해서 처리
		System.out.println(path.exists());
	}

}
