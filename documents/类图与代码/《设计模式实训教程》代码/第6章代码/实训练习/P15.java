abstract class Beverage
{
	public abstract String getDescription();
	public abstract double getCost();
}

class HouseBlend extends Beverage
{
	public String getDescription() 
	{ 
		return "HouseBlend����"; 
	}
	public double getCost() 
	{
		return 10.00; 
	}
}

class Espresso extends Beverage
{
	public String getDescription() 
	{ 
		return "Espresso����"; 
	}
	public double getCost() 
	{
		return 20.00; 
	}
}

class CondimentDecorator extends Beverage
{
	private Beverage beverage;
	public CondimentDecorator(Beverage beverage)
	{
		this.beverage = beverage;
	}
	public String getDescription() 
	{ 
		return beverage.getDescription(); 
	}
	public double getCost() 
	{
		return beverage.getCost(); 
	}
}


class Milk extends CondimentDecorator
{
	public Milk(Beverage beverage)
	{
		super(beverage);
	}
	public String getDescription() 
	{ 
		String decription = super.getDescription();
		return decription + "��ţ��"; 
	}
	public double getCost() 
	{
		double cost = super.getCost();
		return cost + 2.0; 
	}
}

class Mocha extends CondimentDecorator
{
	public Mocha(Beverage beverage)
	{
		super(beverage);
	}
	public String getDescription() 
	{ 
		String decription = super.getDescription();
		return decription + "��Ħ��"; 
	}
	public double getCost() 
	{
		double cost = super.getCost();
		return cost + 3.0; 
	}	
}

class StarBuzzCoffee
{
	public static void main(String args[])
	{
		String decription;
		double cost;
		Beverage beverage_e;
		
		beverage_e = new Espresso();
		decription = beverage_e.getDescription();
		cost = beverage_e.getCost();
		System.out.println("���ϣ�" + decription);
		System.out.println("�۸�" + cost);
		System.out.println("---------------------");
		
		Beverage beverage_mi;
		beverage_mi = new Milk(beverage_e);
		decription = beverage_mi.getDescription();
		cost = beverage_mi.getCost();
		System.out.println("���ϣ�" + decription);
		System.out.println("�۸�" + cost);
		System.out.println("---------------------");		

		Beverage beverage_mo;
		beverage_mo = new Mocha(beverage_mi);
		decription = beverage_mo.getDescription();
		cost = beverage_mo.getCost();
		System.out.println("���ϣ�" + decription);
		System.out.println("�۸�" + cost);
		System.out.println("---------------------");		
	}
}