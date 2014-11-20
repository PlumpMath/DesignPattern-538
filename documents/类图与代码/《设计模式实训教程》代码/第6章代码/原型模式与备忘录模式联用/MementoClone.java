import java.util.*;
import java.io.*;

class Originator implements Cloneable, Serializable
{
	private String state;
	public String getState()
	{
		return this.state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public Originator(){}
	
    //ͨ��ǳ��¡����һ������¼����
	public Originator createMementoC()
	{
		return (Originator)this.clone();
	}
	
	//ͨ�����¡����һ������¼����
	public Originator createMementoDC()
	{
        try 
        { 
			return (Originator)this.deepClone();
		}
		catch(Exception e) 
		{
            return null;
		}
	}

    public void restoreMemento(Originator m)
    {
	state = m.getState();
	}
	
	//ǳ��¡
	public Object clone()
	{
		Object object = null;
		try 
		{
			object = super.clone();
		} 
		catch (CloneNotSupportedException exception) 
		{
			System.err.println("Not support cloneable");
		}
		return object;
	}
	
    //���¡
	public Object deepClone() throws IOException, ClassNotFoundException, OptionalDataException
	{
		//������д������
		ByteArrayOutputStream bao=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bao);
		oos.writeObject(this);
		
		//�����������ȡ��
		ByteArrayInputStream bis=new ByteArrayInputStream(bao.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bis);
		return(ois.readObject());
	}
}


class Caretaker
{
	private Originator memento;
	public void setMemento(Originator memento)
	{
		this.memento = memento;
	}
	public Originator getMemento()
	{
		return this.memento;
	}
}

class Client
{
	public static void main(String args[])
	{
		Originator org = new Originator();
		org.setState("Java");
		System.out.println(org.getState());
		Caretaker ct = new Caretaker();
		ct.setMemento(org.createMementoC());
		org.setState("C++");
		System.out.println(org.getState());
		org.restoreMemento(ct.getMemento());
		System.out.println(org.getState());
	}
}
