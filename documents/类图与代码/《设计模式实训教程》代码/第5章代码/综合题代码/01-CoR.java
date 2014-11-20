class Mission
{
	private String code;
	private int enemyNumber;
	public void setCode(String code)
	{
		this.code=code;
	}
	public String getCode()
	{
		return code;
	}
	public void setEnemyNumber(int enemyNumber)
	{
		this.enemyNumber=enemyNumber;
	}
	public int getEnemyNumber()
	{
		return enemyNumber;
	}
	public Mission(String code,int enemyNumber)
	{
		this.code=code;
		this.enemyNumber=enemyNumber;
	}	
}

abstract class Officer
{
	protected String name;
	protected Officer successor;
	public Officer(String name)
	{
		this.name=name;
	}
	public void setSuccessor(Officer successor)
	{
		this.successor=successor;
	}
	public abstract void handleRequest(Mission request);
}

class Banzhang extends Officer
{
	public Banzhang(String name)
	{
		super(name);
	}
	public void handleRequest(Mission request)
	{
		if(request.getEnemyNumber()<10)
		{
			System.out.println("�೤" + name + "�´����Ϊ" + request.getCode() + "����ս���񣬵�������Ϊ" + request.getEnemyNumber());
		}
		else
		{
			if(this.successor!=null)
			{
				this.successor.handleRequest(request);
			}  
		}   
	}    
}

class Paizhang extends Officer
{
	public Paizhang(String name)
	{
		super(name);
	}
	public void handleRequest(Mission request)
	{
		if(request.getEnemyNumber()<50)
		{
			System.out.println("�ų�" + name + "�´����Ϊ" + request.getCode() + "����ս���񣬵�������Ϊ" + request.getEnemyNumber());
		}
		else
		{
			if(this.successor!=null)
			{
				this.successor.handleRequest(request);
			}
		}
	}
}

class Yingzhang extends Officer
{
	public Yingzhang(String name)
	{
		super(name);
	}
	public void handleRequest(Mission request)
	{
		if(request.getEnemyNumber()<200)
		{
			System.out.println("Ӫ��" + name + "�´����Ϊ" + request.getCode() + "����ս���񣬵�������Ϊ" + request.getEnemyNumber());
		}
		else
		{
			System.out.println("�������۴���Ϊ" + request.getCode() + "����ս���񣬵�������Ϊ" + request.getEnemyNumber());
		}  
	}
}

class Client
{
	public static void main(String a[])
	{
		Banzhang zhangsan=new Banzhang("����");
		Paizhang lisi=new Paizhang("����");
		Yingzhang wangwu=new Yingzhang("����");
		zhangsan.setSuccessor(lisi);
		lisi.setSuccessor(wangwu);

		Mission m1=new Mission("��ӥ�ж�",48);
		zhangsan.handleRequest(m1);
		Mission m2=new Mission("��ɳ�ж�",158);
		zhangsan.handleRequest(m2);
		Mission m3=new Mission("��̶�ж�",8);
		zhangsan.handleRequest(m3);
		Mission m4=new Mission("�����ж�",258);	
		zhangsan.handleRequest(m4);
	}
}

