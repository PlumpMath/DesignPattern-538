import java.util.*;

class Multiton
{
	//����һ���������ڴ洢���ʵ��
	private static Multiton[] array = {new Multiton(),new Multiton(),new Multiton(),new Multiton()};
	//˽�й��캯��
	private Multiton()
	{
	}
	//��̬����������������������е�һ��ʵ��
	public static Multiton getInstance()
	{
		return array[random()];
	}
	//�������һ��������Ϊ�����±�
	public static int random()
	{
		Date d = new Date();
		Random random = new Random();
		int value = Math.abs(random.nextInt());
		value = value % 4;
		return value;
	}
	public static void main(String args[])
	{
		Multiton m1,m2,m3,m4; 
		m1 = Multiton.getInstance();
		m2 = Multiton.getInstance();
		m3 = Multiton.getInstance();
		m4 = Multiton.getInstance();
		
		System.out.println(m1==m2);
		System.out.println(m1==m3);
		System.out.println(m1==m4);
	}
}