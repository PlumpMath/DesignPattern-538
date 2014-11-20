abstract class UnitedNations
{
	public abstract void declare(String message,Country country);
}

abstract class Country
{
	protected UnitedNations un;
	public void setUnitedNations(UnitedNations un)
	{
		this.un = un;
	}
	public void declare(String message)
	{
		un.declare(message,this);
	}
	public abstract void getMessage(String message);
}

class China extends Country
{
	public void getMessage(String message)
	{
		System.out.println("�й���ȡ��Ϣ��" + message);
	}
}

class America extends Country
{
	public void getMessage(String message)
	{
		System.out.println("������ȡ��Ϣ��" + message);
	}	
}

class WTO extends UnitedNations
{
	private China cn;
	private America us;
	public void setChina(China cn)
	{
		this.cn = cn;
	}
	public void setAmerica(America us)
	{
		this.us = us;
	}
	public void declare(String message,Country country)
	{
		if(country == cn)
		{
			us.getMessage(message);
		}
		else
		{
			cn.getMessage(message);
		}
	}
}

class MainClass
{
	public static void main(String args[])
	{
		WTO wto = new WTO();
		China cn = new China();
		America us = new America();
		cn.setUnitedNations(wto);
		us.setUnitedNations(wto);
		wto.setChina(cn);
		wto.setAmerica(us);
		cn.declare("�й���һ�����ú�ƽ�Ĺ��ң�");
		us.declare("��������Ϊ�����ƽ��Ŭ����");
	}
}