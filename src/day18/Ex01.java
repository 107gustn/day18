package day18;

import java.io.File;
import java.io.FileOutputStream;

/*
���������
- �̹���&���� ���ε�, �ٿ�ε�
- ��ũ�� �����ϴ� ���
- ���������� �ϱ����� ���
*/
public class Ex01 {
	public static void main(String[] args) throws Exception {
		File path = new File("D:/1.����_�����/eclipse-jee-2022-03-R-win32-x86_64/aaa.txt"); //��μ��� : (���� ��ġ����)
		//stream : �������
		FileOutputStream os = new FileOutputStream(path);//���� �⺻�� �Ǵ� ��Ʈ�� //�ش��ϴ� ��ġ�� �ش������� ������ ���Ӱ� ���� ����
		os.write('A');// ���� �� �ۼ�
		os.write(97);
		
		String s = "hello";
		os.write( s.getBytes() ); //���ڿ��� byte ������ ��ȯ�ؼ� ó��
		System.out.println(path.exists());
	}

}
