//银行账户：环境类
class Account
{
	private AccountState state;
	private String owner;
	public Account(String owner,double init)
	{
		this.owner=owner;
		this.state=new GreenState(init,this);
		System.out.println(this.owner + "开户，初始金额为" + init);	
		System.out.println("---------------------------------------------");	
	}
	
	public void setState(AccountState state)
	{
		this.state=state;
	}
	
	public void deposit(double amount)
	{
		System.out.println(this.owner + "存款" + amount);
		state.deposit(amount);
		System.out.println("现在余额为"+ state.balance);
		System.out.println("现在帐户状态为"+ state.getClass().getName());
		System.out.println("---------------------------------------------");			
	}
	
	public void withdraw(double amount)
	{
		System.out.println(this.owner + "取款" + amount);
        state.withdraw(amount);
		System.out.println("现在余额为"+ state.balance);
		System.out.println("现在帐户状态为"+ state.getClass().getName());		
		System.out.println("---------------------------------------------");
	}
}

//抽象状态类
abstract class AccountState
{
	protected Account acc;
	protected double balance;
	abstract public void deposit(double amount);
	abstract public void withdraw(double amount);
	abstract public void stateCheck();
}

//绿色状态：具体状态类
class GreenState extends AccountState{
	public GreenState(AccountState state)
	{
		this.balance=state.balance;
		this.acc=state.acc;
	}
	public GreenState(double balance,Account acc)
	{
		this.balance=balance;
		this.acc=acc;
	}
	public void deposit(double amount)
	{
		this.balance+=amount;
		stateCheck();
	}
	public void withdraw(double amount)
	{
		this.balance-=amount;
		stateCheck();
	}
	public void stateCheck()
	{
		if(balance>=-1000&&balance<=0)
		{
			acc.setState(new YellowState(this));
		}
		else if(balance<-1000)
		{
			acc.setState(new RedState(this));
		}	
	}   
}  

//黄色状态：具体状态类
class YellowState extends AccountState
{
	public YellowState(AccountState state)
	{
		this.balance=state.balance;
		this.acc=state.acc;
	}
	public void deposit(double amount)
	{
		this.balance+=amount;
		stateCheck();
	}
	public void withdraw(double amount)
	{
		this.balance-=amount;
		stateCheck();
	}
	public void stateCheck()
	{
		if(balance>0)
		{
			acc.setState(new GreenState(this));
		}
		else if(balance<-1000)
		{
			acc.setState(new RedState(this));
		}
	}
}

//红色状态：具体状态类
class RedState extends AccountState
{
	public RedState(AccountState state)
	{
		this.balance=state.balance;
		this.acc=state.acc;
	}
	public void deposit(double amount)
	{
		this.balance+=amount;
		stateCheck();
	}
	public void withdraw(double amount)
	{
		System.out.println("帐号被冻结，取款失败");
	}
	public void stateCheck()
	{
		if(balance>0)
		{
			acc.setState(new GreenState(this));
		}
		else if(balance>=-1000)
		{
			acc.setState(new YellowState(this));
		}
	}
}

//客户端测试类
class Client
{
	public static void main(String a[])
	{
		Account acc=new Account("段誉",5.0);
		acc.deposit(100);
		acc.withdraw(200);
		acc.deposit(1000);
		acc.withdraw(2000);
		acc.withdraw(100);
	}
}