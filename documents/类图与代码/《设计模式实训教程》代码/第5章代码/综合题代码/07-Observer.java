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
		System.out.println("坚持住，" + this.name + "来救你！");
	}
	
	public void beAttacked(Ally ally)
	{
        System.out.println(this.name + "被攻击！");
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
		System.out.println("紧急通知，盟友" + name + "遭受敌人攻击！");
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
		player1 = new Player("杨过");
		ally.join(player1);
		player2 = new Player("令狐冲");
		ally.join(player2);
		player3 = new Player("张无忌");
		ally.join(player3);
		player4 = new Player("段誉");
		ally.join(player4);
		player1.beAttacked(ally);
	}
}