import java.util.*;

//坐标类：外部状态类
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

//围棋棋子类：抽象享元类
abstract class IgoChessman
{
	public abstract String getColor();
	public void locate(Coordinates coord)
	{
		System.out.println("棋子颜色：" + this.getColor() + "，棋子位置：" + coord.getX() + "，" + coord.getY() );	
	}
}

//黑色棋子类：具体享元类
class BlackIgoChessman extends IgoChessman
{
	public String getColor()
	{
		return "黑色";
	}	
}

//白色棋子类：具体享元类
class WhiteIgoChessman extends IgoChessman
{
	public String getColor()
	{
		return "白色";
	}
}

//围棋棋子工厂类：享元工厂类
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

//客户端测试类
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
		System.out.println("判断两颗黑棋是否相同：" + (black1==black2));
		white1 = factory.getIgoChessman("w");
		white2 = factory.getIgoChessman("w");
		System.out.println("判断两颗白棋是否相同：" + (white1==white2));
		black1.locate(new Coordinates(1,2));
		black2.locate(new Coordinates(3,4));
		black3.locate(new Coordinates(1,3));
		white1.locate(new Coordinates(2,5));
		white2.locate(new Coordinates(2,4));
	}
}