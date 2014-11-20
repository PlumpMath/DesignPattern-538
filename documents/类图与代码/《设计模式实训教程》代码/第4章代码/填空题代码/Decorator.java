interface Cellphone
{
	public void receiveCall();
}

class SimplePhone implements Cellphone
{
	public void receiveCall()
	{
		System.out.println("声音提示");
	}
}

class PhoneDecorator implements Cellphone
{
	private Cellphone phone=null;
	public PhoneDecorator(Cellphone phone)
	{
		if(phone!=null)
		{
			this.phone=phone;
		}
		else
		{
			this.phone=new SimplePhone();
		}
	}
	public void receiveCall()
	{
		phone.receiveCall();
	}
}

class JarPhone extends PhoneDecorator
{
	public JarPhone(Cellphone phone)
	{
		super(phone);
	}
	public void receiveCall()
	{
		super.receiveCall();
		System.out.println("震动提示");		
	}
}

class ComplexPhone extends PhoneDecorator
{
	public ComplexPhone(Cellphone phone)
	{
		super(phone);
	}
	public void receiveCall()
	{
		super.receiveCall();
		System.out.println("灯光闪烁提示");		
	}
}

class Client
{
	public static void main(String a[])
	{
		Cellphone p1=new SimplePhone();
		p1.receiveCall();
		System.out.println("-----------------------");	
		Cellphone p2=new JarPhone(p1);
		p2.receiveCall();
		System.out.println("-----------------------");	
		Cellphone p3=new ComplexPhone(p2);
		p3.receiveCall();
		System.out.println("-----------------------");						
	}
}

