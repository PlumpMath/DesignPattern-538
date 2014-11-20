abstract class Account
{
	public abstract void getUserType();
	public abstract void calculateInterest();
	public void findUser()
	{
		System.out.println("查询用户信息！");
	}
	public void display()
	{
		System.out.println("显示利息！");
	}
	public void handle()
	{
		findUser();
		getUserType();
		calculateInterest();
		display();
	}	
}

class CurrentAccount extends Account
{
	public void getUserType()
	{
		System.out.println("活期账户！");
	}
	public void calculateInterest()
	{
		System.out.println("按活期利率计算利息！");
	}
}

class SavingAccount extends Account
{
	public void getUserType()
	{
		System.out.println("定期账户！");
	}
	public void calculateInterest()
	{
		System.out.println("按定期利率计算利息！");
	}
}

class Client
{
	public static void main(String args[])
	{
		Account account;
		account = new CurrentAccount();
		account.handle();
	}
}