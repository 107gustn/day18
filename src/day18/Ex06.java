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

class AAA implements Serializable{ //��ü�� ����Ʈ �������� ��ȯ
	String name;
	String addr;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getAddr() { return addr; }
	public void setAddr(String addr) { this.addr = addr; }
}
public class Ex06 {
	public static void main(String[] args) throws Exception {
		//����ȭ - ��ü�� ����Ʈ �������� ��ȯ //������ȭ - ����Ʈ ������ ��ü�� ��ȯ
		Scanner sc = new Scanner(System.in);
		String name, addr;
		
		System.out.println("1.����");
		System.out.println("2.��������");
		int num = sc.nextInt();
		
		String path = "D:/1.����_�����/eclipse-jee-2022-03-R-win32-x86_64/";
		
		AAA info = null;
		
		if(num == 1) {
			System.out.println("�̸� �Է�");
			name = sc.next();
			System.out.println("�ּ� �Է�");
			addr = sc.next();
			
			info = new AAA();
			info.setName(name);
			info.setAddr(addr);
			
			File path02 = new File(path + name + ".txt");
			FileOutputStream fos = new FileOutputStream(path02); //�⺻��Ʈ��
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos); //��ü ��� ��Ʈ��
			oos.writeObject( info ); //��ü ����
			
			oos.close();
			bos.close();
			fos.close();
			System.out.println("���� �Ǿ����ϴ�.");
			
		}else {
			File list = new File(path); //�ش���ġ�� ����� ������
			String[] li = list.list(); //String������ �迭�� ����
//			for(int i=0; i<li.length; i++) {
//				System.out.println(li[i]);
//			}
			for( String a : li ) {
				System.out.println(a);
			}
			System.out.println("Ȯ���� �̸� �Է�");
			name = sc.next();
			File p = new File(path + name + ".txt");
//			p.delete(); //���� ����
			
			FileInputStream fis = new FileInputStream(p); //�⺻��Ʈ��
			BufferedInputStream bis = new BufferedInputStream(fis); //������Ʈ��
			ObjectInputStream ois = new ObjectInputStream(bis); //��ü��Ʈ��
			
			info = (AAA)ois.readObject(); //��ü �������� ����� ������ �����ͼ� �о��
			System.out.println("�̸� : " + info.getName());
			System.out.println("�ּ� : " + info.getAddr());
		}
	}
}
