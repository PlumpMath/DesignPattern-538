//电影票类：环境类
class MovieTicket
{
	private double price;
	private Discount discount;
	public void setPrice(double price)
	{
		this.price = price;
	}
	public void setDiscount(Discount discount)
	{
		this.discount = discount;
	}
	public double getPrice()
	{
		return discount.calculate(this.price);
	}
}

//折扣类：抽象策略类
interface Discount
{
	public double calculate(double price);
}

//学生折扣类：具体策略类
class StudentDiscount implements Discount
{
	public double calculate(double price)
	{
		return price * 0.8;
	}
}

//儿童折扣类：具体策略类
class ChildrenDiscount implements Discount
{
	public double calculate(double price)
	{
		return price - 10;
	}
}

//VIP会员折扣类：具体策略类
class VIPDiscount implements Discount
{
	public double calculate(double price)
	{
		System.out.println("增加积分！");
		return price * 0.5;
	}
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
		MovieTicket mt = new MovieTicket();
		mt.setPrice(50.00);
		double currentPrice;
			
		Discount obj;
		obj = new StudentDiscount();  //可通过配置文件实现
		mt.setDiscount(obj);
		currentPrice = mt.getPrice();
		System.out.println("折后价为：" + currentPrice);
		System.out.println("---------------------------------");
		obj = new VIPDiscount();
		mt.setDiscount(obj);
		currentPrice = mt.getPrice();
		System.out.println("折后价为：" + currentPrice);
	}
}