//�����˻���������
class Account
{
	private AccountState state;
	private String owner;
	public Account(String owner,double init)
	{
		this.owner=owner;
		this.state=new GreenState(init,this);
		System.out.println(this.owner + "��������ʼ���Ϊ" + init);	
		System.out.println("---------------------------------------------");	
	}
	
	public void setState(AccountState state)
	{
		this.state=state;
	}
	
	public void deposit(double amount)
	{
		System.out.println(this.owner + "���" + amount);
		state.deposit(amount);
		System.out.println("�������Ϊ"+ state.balance);
		System.out.println("�����ʻ�״̬Ϊ"+ state.getClass().getName());
		System.out.println("---------------------------------------------");			
	}
	
	public void withdraw(double amount)
	{
		System.out.println(this.owner + "ȡ��" + amount);
        state.withdraw(amount);
		System.out.println("�������Ϊ"+ state.balance);
		System.out.println("�����ʻ�״̬Ϊ"+ state.getClass().getName());		
		System.out.println("---------------------------------------------");
	}
}

//����״̬��
abstract class AccountState
{
	protected Account acc;
	protected double balance;
	abstract public void deposit(double amount);
	abstract public void withdraw(double amount);
	abstract public void stateCheck();
}

//��ɫ״̬������״̬��
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

//��ɫ״̬������״̬��
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

//��ɫ״̬������״̬��
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
		System.out.println("�ʺű����ᣬȡ��ʧ��");
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

//�ͻ��˲�����
class Client
{
	public static void main(String a[])
	{
		Account acc=new Account("����",5.0);
		acc.deposit(100);
		acc.withdraw(200);
		acc.deposit(1000);
		acc.withdraw(2000);
		acc.withdraw(100);
	}
}