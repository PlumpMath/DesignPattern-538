//�����ѯ�������������ࣺ���󴫵���
abstract class SearchContext
{
	protected SearchContext successor;
	public void setSuccessor(SearchContext successor)
	{
		this.successor = successor;
	}
	public abstract void search(String keyword);
}

//�����ѯ�������������ࣺ���崫����
class JavaSearchContext extends SearchContext
{
	public void search(String keyword)
	{
		//ģ��ʵ��
		if(keyword.contains("Java"))
		{
			System.out.println("��ѯ�ؼ���Java��");
		}
		else
		{
			successor.search(keyword);
		}
	}
}

//�����ѯ�������������ࣺ���崫����
class SQLSearchContext extends SearchContext
{
	public void search(String keyword)
	{
		//ģ��ʵ��
		if(keyword.contains("SQL"))
		{
			System.out.println("��ѯ�ؼ���SQL��");
		}
		else
		{
			successor.search(keyword);
		}
	}
}

//�����ѯ�������������ࣺ���崫����
class UMLSearchContext extends SearchContext
{
	public void search(String keyword)
	{
		//ģ��ʵ��
		if(keyword.contains("UML"))
		{
			System.out.println("��ѯ�ؼ���UML��");
		}
		else
		{
			successor.search(keyword);
		}
	}
}

//�ͻ��˲�����
class Client
{
	public static void main(String args[])
	{
		SearchContext jContext,sContext,uContext;
		jContext = new JavaSearchContext();
		sContext = new SQLSearchContext();
		uContext = new UMLSearchContext();
		jContext.setSuccessor(sContext);
		sContext.setSuccessor(uContext);
		String keyword = "UML��ͼ�����ɻ�";
		jContext.search(keyword);
	}
}