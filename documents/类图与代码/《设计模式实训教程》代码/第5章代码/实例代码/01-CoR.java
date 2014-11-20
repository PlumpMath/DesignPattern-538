//抽象查询请求处理上下文类：抽象传递者
abstract class SearchContext
{
	protected SearchContext successor;
	public void setSuccessor(SearchContext successor)
	{
		this.successor = successor;
	}
	public abstract void search(String keyword);
}

//具体查询请求处理上下文类：具体传递者
class JavaSearchContext extends SearchContext
{
	public void search(String keyword)
	{
		//模拟实现
		if(keyword.contains("Java"))
		{
			System.out.println("查询关键字Java！");
		}
		else
		{
			successor.search(keyword);
		}
	}
}

//具体查询请求处理上下文类：具体传递者
class SQLSearchContext extends SearchContext
{
	public void search(String keyword)
	{
		//模拟实现
		if(keyword.contains("SQL"))
		{
			System.out.println("查询关键字SQL！");
		}
		else
		{
			successor.search(keyword);
		}
	}
}

//具体查询请求处理上下文类：具体传递者
class UMLSearchContext extends SearchContext
{
	public void search(String keyword)
	{
		//模拟实现
		if(keyword.contains("UML"))
		{
			System.out.println("查询关键字UML！");
		}
		else
		{
			successor.search(keyword);
		}
	}
}

//客户端测试类
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
		String keyword = "UML类图绘制疑惑";
		jContext.search(keyword);
	}
}