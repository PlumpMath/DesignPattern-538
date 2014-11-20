import java.util.*;

//������񣺳���۲���
interface Investor
{
	public void response(Stock stock);
}

//��Ʊ���۲�Ŀ��
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

//���񣺾���۲���
class ConcreteInvestor implements Investor
{
	private String name;
	public ConcreteInvestor(String name)
	{
		this.name = name;
	}
	public void response(Stock stock)
	{
	   System.out.print("��ʾ����: " + name);
	   System.out.print("------��Ʊ��" + stock.getStockName());
	   System.out.print("�۸񲨶����ȳ���5%------") ;
	   System.out.println("�¼۸���:"+ stock.getPrice() + "��");		
	}	
}

//�ͻ��˲�����
class Client
{
	public static void main(String args[])
	{
		Investor investor1,investor2;
		investor1 = new ConcreteInvestor("���");
		investor2 = new ConcreteInvestor("С��Ů");
		
		Stock haier = new Stock("�ൺ����",20.00);
		haier.attach(investor1);  //ע��
		haier.attach(investor2);  //ע��
		
		haier.setPrice(25.00);
	}
}