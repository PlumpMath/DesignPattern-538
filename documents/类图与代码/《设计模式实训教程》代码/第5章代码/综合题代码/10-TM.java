abstract class Account
{
	public abstract void getUserType();
	public abstract void calculateInterest();
	public void findUser()
	{
		System.out.println("��ѯ�û���Ϣ��");
	}
	public void display()
	{
		System.out.println("��ʾ��Ϣ��");
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
		System.out.println("�����˻���");
	}
	public void calculateInterest()
	{
		System.out.println("���������ʼ�����Ϣ��");
	}
}

class SavingAccount extends Account
{
	public void getUserType()
	{
		System.out.println("�����˻���");
	}
	public void calculateInterest()
	{
		System.out.println("���������ʼ�����Ϣ��");
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