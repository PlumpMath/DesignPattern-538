import java.util.*;

//抽象日志记录类：抽象主题
interface AbstractLog
{
	public void method();
}

//业务类：真实主题
class BusinessClass implements AbstractLog
{
	public void method()
	{
		System.out.println("真实业务方法！");
	}
}

//日志记录代理类：代理主题
class LoggerProxy implements AbstractLog
{
	private BusinessClass business;
	
	public LoggerProxy()
	{
		business = new BusinessClass();
	}
	
	public void method()
	{
		Calendar calendar = new GregorianCalendar();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR) + 12;
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		String dateTime = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second + "！";
		System.out.println("方法method()被调用，调用时间为" + dateTime);
		try{
			business.method();
			System.out.println("方法method()调用成功！");
		}
		catch(Exception e)
		{
			System.out.println("方法method()调用失败！");
		}
	}
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
		AbstractLog al;
		al = new LoggerProxy();
		al.method();
	}
}