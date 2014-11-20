//�ˣ������Ʒ
interface Person
{
	public void eat();
	public void sleep();
}

//���ˣ������Ʒ
class Man implements Person
{
	public void eat()
	{
		System.out.println("���˳Է���");
	}
	public void sleep()
	{
		System.out.println("����˯��");
	}
}

//Ů�ˣ������Ʒ
class Woman implements Person
{
	public void eat()
	{
		System.out.println("Ů�˳Է���");
	}
	public void sleep()
	{
		System.out.println("Ů��˯��");
	}
}

//�����ˣ������Ʒ
class Robot implements Person
{
	public void eat()
	{
		System.out.println("������Ҫ�Է���");
	}
	public void sleep()
	{
		System.out.println("������Ҫ˯����");
	}
}

//Ů洣�����
class Nvwa
{
	//��̬��������
	public static Person makePerson(char arg)
	{
		Person person = null;
		switch(arg)
		{
			case 'M': person = new Man();break;
			case 'W': person = new Woman();break;
			case 'R': person = new Robot();break;
		}
		return person;
	} 
}

//�ͻ��˲�����
class Client
{
	public static void main(String args[])
	{
         	Person person;
         	person=Nvwa.makePerson('W');
         	person.eat();
         	person.sleep();
	}
}
