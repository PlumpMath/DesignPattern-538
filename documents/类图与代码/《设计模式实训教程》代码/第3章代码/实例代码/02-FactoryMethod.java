//日志记录器接口：抽象产品
interface Log
{
	public void writeLog();
}

//文件日志记录器：具体产品
class FileLog implements Log
{
	public void writeLog()
	{
		System.out.println("文件日志记录。");
	}
}

//数据库日志记录器：具体产品
class DatabaseLog implements Log
{
	public void writeLog()
	{
		System.out.println("数据库日志记录。");
	}
}

//日志记录器工厂接口：抽象工厂
interface LogFactory
{
	public Log createLog();
}

//文件日志记录器工厂类：具体工厂
class FileLogFactory implements LogFactory
{
	public Log createLog()
	{
		return new FileLog();
	}
}

//数据库日志记录器工厂类：具体工厂
class DatabaseLogFactory implements LogFactory
{
	public Log createLog()
	{
		return new DatabaseLog();
	}	
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
		LogFactory factory;
		Log log;
		factory = new FileLogFactory();
		log = factory.createLog();
		log.writeLog();
	}
}
