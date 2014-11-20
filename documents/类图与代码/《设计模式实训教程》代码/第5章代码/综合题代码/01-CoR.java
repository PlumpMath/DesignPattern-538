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
			System.out.println("班长" + name + "下达代号为" + request.getCode() + "的作战任务，敌人数量为" + request.getEnemyNumber());
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
			System.out.println("排长" + name + "下达代号为" + request.getCode() + "的作战任务，敌人数量为" + request.getEnemyNumber());
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
			System.out.println("营长" + name + "下达代号为" + request.getCode() + "的作战任务，敌人数量为" + request.getEnemyNumber());
		}
		else
		{
			System.out.println("开会讨论代号为" + request.getCode() + "的作战任务，敌人数量为" + request.getEnemyNumber());
		}  
	}
}

class Client
{
	public static void main(String a[])
	{
		Banzhang zhangsan=new Banzhang("张三");
		Paizhang lisi=new Paizhang("李四");
		Yingzhang wangwu=new Yingzhang("王五");
		zhangsan.setSuccessor(lisi);
		lisi.setSuccessor(wangwu);

		Mission m1=new Mission("黑鹰行动",48);
		zhangsan.handleRequest(m1);
		Mission m2=new Mission("长沙行动",158);
		zhangsan.handleRequest(m2);
		Mission m3=new Mission("湘潭行动",8);
		zhangsan.handleRequest(m3);
		Mission m4=new Mission("株洲行动",258);	
		zhangsan.handleRequest(m4);
	}
}

