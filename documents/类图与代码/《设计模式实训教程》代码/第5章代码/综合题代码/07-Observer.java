import java.util.*;

interface Observer
{
	public void setName(String name);
	public String getName();
	public void help();
	public void beAttacked(Ally ally);
}

class Player implements Observer
{
	private String name;

	public Player(String name)
	{
		this.name = name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void help()
	{
		System.out.println("���ס��" + this.name + "�����㣡");
	}
	
	public void beAttacked(Ally ally)
	{
        System.out.println(this.name + "��������");
        ally.notifyObserver(name);		
	}
}

class Ally
{
	private ArrayList<Observer> players = new ArrayList<Observer>();
	
	public void join(Observer obs)
	{
		players.add(obs);
	}
	
	public void quit(Observer obs)
	{
		players.remove(obs);
	}
	
	public void notifyObserver(String name)
	{
		System.out.println("����֪ͨ������" + name + "���ܵ��˹�����");
        for(Object obs : players)
        {
            if (!((Observer)obs).getName().equalsIgnoreCase(name))
            {
                ((Observer)obs).help();
            }
        }		
	}
}

class MainClass
{
	public static void main(String args[])
	{
		Ally ally = new Ally();
		Observer player1,player2,player3,player4;
		player1 = new Player("���");
		ally.join(player1);
		player2 = new Player("�����");
		ally.join(player2);
		player3 = new Player("���޼�");
		ally.join(player3);
		player4 = new Player("����");
		ally.join(player4);
		player1.beAttacked(ally);
	}
}