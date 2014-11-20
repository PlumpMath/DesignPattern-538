import java.util.*;

//抽象股民：抽象观察者
interface Investor
{
	public void response(Stock stock);
}

//股票：观察目标
class Stock
{
	private ArrayList<Investor> investors;
	private String stockName;
	private double price;
	public Stock(String stockName,double price)
	{
		this.stockName = stockName;
		this.price = price;
		investors = new ArrayList<Investor>();
	}
	public void attach(Investor investor)
	{
		investors.add(investor);
	}
	public void detach(Investor investor)
	{
		investors.remove(investor);
	}
	public void setStockName(String stockName)
	{
		this.stockName = stockName;
	}
	public String getStockName()
	{
		return this.stockName;
	}
	public void setPrice(double price)
	{
		double range = Math.abs(price-this.price)/this.price;
		this.price = price;
		if(range>=0.05)
		{
			this.notifyInvestor();
		}
	}
	public double getPrice()
	{
		return this.price;
	}
	public void notifyInvestor()
	{
		for(Object obj:investors)
		{
			((Investor)obj).response(this);
		}
	}
}

//股民：具体观察者
class ConcreteInvestor implements Investor
{
	private String name;
	public ConcreteInvestor(String name)
	{
		this.name = name;
	}
	public void response(Stock stock)
	{
	   System.out.print("提示股民: " + name);
	   System.out.print("------股票：" + stock.getStockName());
	   System.out.print("价格波动幅度超过5%------") ;
	   System.out.println("新价格是:"+ stock.getPrice() + "。");		
	}	
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
		Investor investor1,investor2;
		investor1 = new ConcreteInvestor("杨过");
		investor2 = new ConcreteInvestor("小龙女");
		
		Stock haier = new Stock("青岛海尔",20.00);
		haier.attach(investor1);  //注册
		haier.attach(investor2);  //注册
		
		haier.setPrice(25.00);
	}
}