import java.util.*;

class Color
{
	private String color;
	public Color(String color)
	{
		this.color = color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public String getColor()
	{
		return this.color;
	}
}

class Size
{
	private int value;
	public Size(int value)
	{
		this.value = value;
	}
	public void setValue(int value)
	{
		this.value = value;
	}
	public int getValue()
	{
		return this.value;
	}
}

class SharedString
{
	private String content;
	private Color color;
	private Size size;
	public SharedString(String content)
	{
		this.content = content;
	}
	public void setColor(Color color)
	{
		this.color = color;
	}
	public void setSize(Size size)
	{
		this.size = size;
	}
	public void display()
	{
		System.out.println("���ݣ�" + this.content + "����ɫ��" + this.color.getColor() + "����С��" + this.size.getValue());
	}
}

class SharedStringFactory
{
	private Hashtable ht;
	public SharedStringFactory()
	{
		ht = new Hashtable();
	}
	public SharedString getSharedString(String arg)
	{
		if(ht.containsKey(arg))
		{
			return (SharedString)ht.get(arg);
		}
		else
		{
			SharedString str = new SharedString(arg);
			ht.put(arg,str);
			return (SharedString)ht.get(arg);
		}
	}
}

class Client
{
	public static void main(String args[])
	{
		SharedString str1,str2;
		SharedStringFactory factory = new SharedStringFactory();
		str1 = factory.getSharedString("Java");
		str1.setColor(new Color("��ɫ"));
		str1.setSize(new Size(5));
		str1.display();  //��������ݣ�Java����ɫ����ɫ����С��5��
		str2 = factory.getSharedString("Java");
		str2.setColor(new Color("��ɫ"));
		str2.setSize(new Size(10));
		str2.display(); //��������ݣ�Java����ɫ����ɫ����С��10��
		System.out.println(str1==str2);  //�����true��
	}
}