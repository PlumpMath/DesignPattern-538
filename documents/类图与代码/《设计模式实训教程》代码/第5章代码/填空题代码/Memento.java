class Data
{
	private int value;
	public int getValue() 
	{  return this.value;  }
	public void setValue(int value) 
	{  this.value = value; }
	public void restore(DataMemento memento)
	{  this.value = memento.getValue();  }
	public DataMemento save()
	{  return new DataMemento(this.value);  }
	public void handle()
	{  System.out.println(this.value);  }
}

class DataMemento
{
	private int value;
	DataMemento(int value)
	{  this.value = value;  }
 	int getValue() 
	{  return this.value;  }
	void setValue(int value) 
	{  this.value = value; }
}

class MementoCaretaker
{
	private DataMemento memento;
	public DataMemento getMemento()
	{  return this.memento;  }
	public void setMemento(DataMemento memento)
	{  this.memento = memento;  }
}

class Test
{
	public static void main(String args[])
	{
		Data data = new Data();
		data.setValue(60);
		MementoCaretaker mc = new MementoCaretaker();
		mc.setMemento(data.save());
		System.out.println("****״̬һ****");
		data.handle();
		int temp = data.getValue();
		temp = (temp + 3 - 4) % 10;
		data.setValue(temp);
		System.out.println("****״̬��****");
		data.handle();
		data.restore(mc.getMemento());
		System.out.println("****�ָ�״̬һ****");
		data.handle();
	}
}