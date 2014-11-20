import java.util.*;

class Multiton
{
	//定义一个数组用于存储多个实例
	private static Multiton[] array = {new Multiton(),new Multiton(),new Multiton(),new Multiton()};
	//私有构造函数
	private Multiton()
	{
	}
	//静态工厂方法，随机返回数组中的一个实例
	public static Multiton getInstance()
	{
		return array[random()];
	}
	//随机生成一个整数作为数组下标
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