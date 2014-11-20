//人：抽象产品
interface Person
{
	public void eat();
	public void sleep();
}

//男人：具体产品
class Man implements Person
{
	public void eat()
	{
		System.out.println("男人吃饭。");
	}
	public void sleep()
	{
		System.out.println("男人睡觉");
	}
}

//女人：具体产品
class Woman implements Person
{
	public void eat()
	{
		System.out.println("女人吃饭。");
	}
	public void sleep()
	{
		System.out.println("女人睡觉");
	}
}

//机器人：具体产品
class Robot implements Person
{
	public void eat()
	{
		System.out.println("机器人要吃饭吗？");
	}
	public void sleep()
	{
		System.out.println("机器人要睡觉吗？");
	}
}

//女娲：工厂
class Nvwa
{
	//静态工厂方法
	public static Person makePerson(char arg)
	{
		Person person = null;
		switch(arg)
		{
			case 'M': person = new Man();break;
			case 'W': person = new Woman();break;
			case 'R': person = new Robot();break;
		}
		return person;
	} 
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
         	Person person;
         	person=Nvwa.makePerson('W');
         	person.eat();
         	person.sleep();
	}
}
