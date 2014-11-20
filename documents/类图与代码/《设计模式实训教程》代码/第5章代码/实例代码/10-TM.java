//�������ݿ�����ࣺ������
abstract class DBOperator
{
	public abstract void connDB();
    public void openDB()
	{
		System.out.println("�����ݿ�");
	}
	public void useDB()
	{
		System.out.println("ʹ�����ݿ�");
	}
	public void closeDB()
	{
		System.out.println("�ر����ݿ�");	
	}
   public void process()
   {
    connDB();
   	openDB();
   	useDB();
   	closeDB();
   }
}

//SQL Server���ݿ�����ࣺ��������
class SQLServerDBOperator extends DBOperator
{
	public void connDB()
	{
		System.out.println("����SQL Server���ݿ⣡");		
	}
}

//Oracle���ݿ�����ࣺ��������
class OracleDBOperator extends DBOperator
{
	public void connDB()
	{
		System.out.println("����Oracle���ݿ⣡");		
	}
}

//�ͻ��˲�����
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

