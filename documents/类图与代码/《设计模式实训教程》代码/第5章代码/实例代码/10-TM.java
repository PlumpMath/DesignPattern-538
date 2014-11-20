//抽象数据库操作类：抽象类
abstract class DBOperator
{
	public abstract void connDB();
    public void openDB()
	{
		System.out.println("打开数据库");
	}
	public void useDB()
	{
		System.out.println("使用数据库");
	}
	public void closeDB()
	{
		System.out.println("关闭数据库");	
	}
   public void process()
   {
    connDB();
   	openDB();
   	useDB();
   	closeDB();
   }
}

//SQL Server数据库操作类：具体子类
class SQLServerDBOperator extends DBOperator
{
	public void connDB()
	{
		System.out.println("连接SQL Server数据库！");		
	}
}

//Oracle数据库操作类：具体子类
class OracleDBOperator extends DBOperator
{
	public void connDB()
	{
		System.out.println("连接Oracle数据库！");		
	}
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
		DBOperator operator;
		operator=new SQLServerDBOperator();
		operator.process();
		System.out.println("---------------------------------------");			
		operator=new OracleDBOperator();
		operator.process();
	}
}

