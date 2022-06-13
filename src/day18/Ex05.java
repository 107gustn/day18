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
		File path = new File("D:/1.����_�����/eclipse-jee-2022-03-R-win32-x86_64/aaa.txt");
		FileOutputStream fos = new FileOutputStream(path); //�⺻ ��Ʈ��
		BufferedOutputStream bos = new BufferedOutputStream(fos); //���� ��Ʈ��
		DataOutputStream dos = new DataOutputStream(bos); //�������� ���� ó�����ִ� ��Ʈ��
		
		String s = "�ȳ��ϼ���";
		dos.writeUTF(s);
		
		dos.close(); //�������� ��Ʈ���� �ݾ���
		bos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream(path);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		String str = dis.readUTF(); //���ڿ� ó��
		System.out.println("������ ���� : " + str);
		
		dis.close();
		bis.close();
		fis.close();
	}
}
