import java.util.*;
class Magazine
{
	private ArrayList weapons;
	private Iterator iterator;
	public Magazine()
	{
		weapons = new ArrayList();
		iterator = weapons.iterator();
	}
	public void display()
	{
		while(iterator.hasNext())
		{
			((Weapon)iterator.next()).display();
		}
	}
	......
}