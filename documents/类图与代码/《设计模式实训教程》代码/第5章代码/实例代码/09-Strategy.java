//��ӰƱ�ࣺ������
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

//�ۿ��ࣺ���������
interface Discount
{
	public double calculate(double price);
}

//ѧ���ۿ��ࣺ���������
class StudentDiscount implements Discount
{
	public double calculate(double price)
	{
		return price * 0.8;
	}
}

//��ͯ�ۿ��ࣺ���������
class ChildrenDiscount implements Discount
{
	public double calculate(double price)
	{
		return price - 10;
	}
}

//VIP��Ա�ۿ��ࣺ���������
class VIPDiscount implements Discount
{
	public double calculate(double price)
	{
		System.out.println("���ӻ��֣�");
		return price * 0.5;
	}
}

//�ͻ��˲�����
class Client
{
	public static void main(String args[])
	{
		MovieTicket mt = new MovieTicket();
		mt.setPrice(50.00);
		double currentPrice;
			
		Discount obj;
		obj = new StudentDiscount();  //��ͨ�������ļ�ʵ��
		mt.setDiscount(obj);
		currentPrice = mt.getPrice();
		System.out.println("�ۺ��Ϊ��" + currentPrice);
		System.out.println("---------------------------------");
		obj = new VIPDiscount();
		mt.setDiscount(obj);
		currentPrice = mt.getPrice();
		System.out.println("�ۺ��Ϊ��" + currentPrice);
	}
}