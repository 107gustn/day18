package day18;

import java.io.File;
import java.io.FileInputStream;

public class Ex03 {
	public static void main(String[] args) throws Exception {
		File path = new File("D:/1.����_�����/eclipse-jee-2022-03-R-win32-x86_64/aaa.txt");
		FileInputStream fis = new FileInputStream(path); //�⺻ ��Ʈ��
		while(true) {
			Thread.sleep(1000);
			int res = fis.read(); //�ش����Ͽ��� ���� �ϳ��� �о�ͼ� ����
			//System.out.println("res : " + res);
			if(res < 0) //�� �����ͼ� ������ ���� ������ �������� -1(eof)�� ������
				break;
			System.out.println( (char)res ); //����ȯ
			
		}

	}

}
