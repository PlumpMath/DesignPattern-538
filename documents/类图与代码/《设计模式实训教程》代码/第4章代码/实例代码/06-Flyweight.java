import java.util.*;

//�����ࣺ�ⲿ״̬��
class Coordinates
{
	private int x;
	private int y;
	public Coordinates(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	public int getX()
	{
		return this.x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY()
	{
		return this.y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
} 

//Χ�������ࣺ������Ԫ��
abstract class IgoChessman
{
	public abstract String getColor();
	public void locate(Coordinates coord)
	{
		System.out.println("������ɫ��" + this.getColor() + "������λ�ã�" + coord.getX() + "��" + coord.getY() );	
	}
}

//��ɫ�����ࣺ������Ԫ��
class BlackIgoChessman extends IgoChessman
{
	public String getColor()
	{
		return "��ɫ";
	}	
}

//��ɫ�����ࣺ������Ԫ��
class WhiteIgoChessman extends IgoChessman
{
	public String getColor()
	{
		return "��ɫ";
	}
}

//Χ�����ӹ����ࣺ��Ԫ������
class IgoChessmanFactory
{
	private static IgoChessmanFactory instance = new IgoChessmanFactory();
	private static Hashtable ht;
	
	private IgoChessmanFactory()
	{
		ht = new Hashtable();
		IgoChessman black,white;
		black = new BlackIgoChessman();
		ht.put("b",black);
		white = new WhiteIgoChessman();
		ht.put("w",white);
	}
	
	public static IgoChessmanFactory getInstance()
	{
		return instance;
	}
	
	public static IgoChessman getIgoChessman(String color)
	{
		return (IgoChessman)ht.get(color);	
	}
}

//�ͻ��˲�����
class Client
{
	public static void main(String args[])
	{
		IgoChessman black1,black2,black3,white1,white2;
		IgoChessmanFactory factory;
		factory = IgoChessmanFactory.getInstance();
		black1 = factory.getIgoChessman("b");
		black2 = factory.getIgoChessman("b");
		black3 = factory.getIgoChessman("b");
		System.out.println("�ж����ź����Ƿ���ͬ��" + (black1==black2));
		white1 = factory.getIgoChessman("w");
		white2 = factory.getIgoChessman("w");
		System.out.println("�ж����Ű����Ƿ���ͬ��" + (white1==white2));
		black1.locate(new Coordinates(1,2));
		black2.locate(new Coordinates(3,4));
		black3.locate(new Coordinates(1,3));
		white1.locate(new Coordinates(2,5));
		white2.locate(new Coordinates(2,4));
	}
}