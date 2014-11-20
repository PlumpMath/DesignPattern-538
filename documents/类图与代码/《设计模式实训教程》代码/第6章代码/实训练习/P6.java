import java.util.*;
interface Subject
{
	public void addObserver(Observer obs);
	public void cry();
}

interface Observer
{
	public void response();
}

class Cat implements Subject
{
	private ArrayList<Observer> list;
	public Cat()
	{
		list = new ArrayList<Observer>();
	}
	public void addObserver(Observer obs)
	{
		list.add(obs);
	}
	public void cry()
	{
		for(Object obj : list)
		{
			((Observer)obj).response();
		}
	}
}

class Mouse implements Observer
{
	private String name;
	public Mouse(String name, Subject subject)
	{
		this.name = name;
		subject.addObserver(this);
	}
	public void response()
	{
		System.out.println(this.name + "拼命逃跑！");
	}
}

class Master implements Observer
{
	private String name;
	public Master(String name, Subject subject)
	{
		this.name = name;
		subject.addObserver(this);
	}
	public void response()
	{
		System.out.println(this.name + "从美梦中惊醒！");
	}
}

class Client
{
	public static void main(String args[])
	{
		Subject cat = new Cat();
		Observer mouse1,mouse2,master;
		mouse1 = new Mouse("大老鼠",cat);
		mouse2 = new Mouse("小老鼠",cat);
		master = new Master("小龙女",cat);
		cat.cry(); 
	}
}