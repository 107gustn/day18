package day18;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Ex04 {
	public static void main(String[] args) throws Exception {
		File path = new File("D:/1.����_�����/eclipse-jee-2022-03-R-win32-x86_64/aaa.txt");
		FileOutputStream fos = new FileOutputStream(path); //�⺻ ��Ʈ��
		BufferedOutputStream bos = new BufferedOutputStream(fos); //�⺻ ��Ʈ���� �̿��Ͽ� ���� ��Ʈ���� ������
		
		for(int i='1'; i<'9' ; i++) {
			//Thread.sleep(1000);
			bos.write(i); //���� ��Ʈ���� ���
		}
		bos.flush(); //���� ��Ʈ���� ���� ���۽��� ���.
		
		
	}
}
