//���ݿ����ӽӿڣ������Ʒ
interface Connection
{
	public void connect();
}

//Oracle���ݿ������ࣺ�����Ʒ
class OracleConnection implements Connection
{
	public void connect()
	{
		System.out.println("����Oracle���ݿ⡣");
	}
}

//MySQL���ݿ������ࣺ�����Ʒ
class MySQLConnection implements Connection
{
	public void connect()
	{
		System.out.println("����MySQL���ݿ⡣");
	}	
}

//���ݿ����ӿڣ������Ʒ
interface Statement
{
	public void executeStatement();
}

//Oracle���ݿ�����ࣺ�����Ʒ
class OracleStatement implements Statement
{
	public void executeStatement()
	{
		System.out.println("ִ��Oracle���ݿ���䡣");
	}
}

//MySQL���ݿ�����ࣺ�����Ʒ
class MySQLStatement implements Statement
{
	public void executeStatement()
	{
		System.out.println("ִ��MySQL���ݿ���䡣");
	}
}

//���ݿ⹤���ӿڣ����󹤳�
interface DBFactory
{
	public Connection createConnection();
	public Statement createStatement();
}

//Oracle���ݿ⹤�������幤��
class OracleFactory implements DBFactory
{
	public Connection createConnection()
	{
		return new OracleConnection();
	}
	
	public Statement createStatement()
	{
		return new OracleStatement();
	}
}

//MySQL���ݿ⹤�������幤��
class MySQLFactory implements DBFactory
{
	public Connection createConnection()
	{
		return new MySQLConnection();
	}
	
	public Statement createStatement()
	{
		return new MySQLStatement();
	}
}

//�ͻ��˲�����
class Client
{
	public static void main(String args[])
	{
		DBFactory factory;
		Connection connection;
		Statement statement;
		factory = new OracleFactory();
		connection = factory.createConnection();
		statement = factory.createStatement();
		connection.connect();
		statement.executeStatement();
	}
}
