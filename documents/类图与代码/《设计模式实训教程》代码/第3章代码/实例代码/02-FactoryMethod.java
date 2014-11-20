//��־��¼���ӿڣ������Ʒ
interface Log
{
	public void writeLog();
}

//�ļ���־��¼���������Ʒ
class FileLog implements Log
{
	public void writeLog()
	{
		System.out.println("�ļ���־��¼��");
	}
}

//���ݿ���־��¼���������Ʒ
class DatabaseLog implements Log
{
	public void writeLog()
	{
		System.out.println("���ݿ���־��¼��");
	}
}

//��־��¼�������ӿڣ����󹤳�
interface LogFactory
{
	public Log createLog();
}

//�ļ���־��¼�������ࣺ���幤��
class FileLogFactory implements LogFactory
{
	public Log createLog()
	{
		return new FileLog();
	}
}

//���ݿ���־��¼�������ࣺ���幤��
class DatabaseLogFactory implements LogFactory
{
	public Log createLog()
	{
		return new DatabaseLog();
	}	
}

//�ͻ��˲�����
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
