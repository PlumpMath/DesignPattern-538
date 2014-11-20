import java.util.*;

//������־��¼�ࣺ��������
interface AbstractLog
{
	public void method();
}

//ҵ���ࣺ��ʵ����
class BusinessClass implements AbstractLog
{
	public void method()
	{
		System.out.println("��ʵҵ�񷽷���");
	}
}

//��־��¼�����ࣺ��������
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
		String dateTime = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second + "��";
		System.out.println("����method()�����ã�����ʱ��Ϊ" + dateTime);
		try{
			business.method();
			System.out.println("����method()���óɹ���");
		}
		catch(Exception e)
		{
			System.out.println("����method()����ʧ�ܣ�");
		}
	}
}

//�ͻ��˲�����
class Client
{
	public static void main(String args[])
	{
		AbstractLog al;
		al = new LoggerProxy();
		al.method();
	}
}