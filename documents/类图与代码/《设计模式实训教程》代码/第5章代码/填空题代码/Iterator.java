interface Collection
{
	public void setArray(Object objs[]);  //��������
	public Object[] getArray();  //��ȡ����
	public Iterator createIterator();  //����������
}

interface Iterator
{
	public void first(); //����ָ���һ��Ԫ��
	public void last(); //����ָ�����һ��Ԫ��
	public void next(); //����ָ����һ��Ԫ��
	public void previous(); //����ָ����һ��Ԫ��
	public boolean isLast();  //�ж��Ƿ����һ��Ԫ��
	public boolean isFirst(); //�ж��Ƿ��һ��Ԫ��
	public Object getItem();  //��ȡ��ǰ������ָ���Ԫ��
}

class ConcreteCollection implements Collection
{
	private Object[] objs;
	
	public void setArray(Object objs[])
	{  this.objs = objs;  }
	
	public Object[] getArray()
	{  return this.objs;  }
	
	public Iterator createIterator()
	{  return new ConcreteIterator(this); }
}

class ConcreteIterator implements Iterator
{
	private Object[] objs;
	private int index=0;  //������������ֵΪ0
	
	public ConcreteIterator(ConcreteCollection collection)
	{  this.objs = collection.getArray();  }
	public void first()
	{  index = 0;  }
	public void last()
	{  index = objs.length-1;  }
	public void next()
	{
		if(index<objs.length)
		{
			index ++;
		}
	}
	public void previous()
	{
		if(index>=0)
		{
		    index --;
		}
	}
	public boolean isLast()
	{   return index==objs.length ;  }
	public boolean isFirst()
	{   return index==-1 ;  }
	public Object getItem()
	{  return objs[index];  }	
}

class Test
{
	public static void main(String args[])
	{	
		Collection collection;
		collection = new ConcreteCollection();
		Object[] objs={"����","�Ϻ�","����","����","��ɳ"};
		collection.setArray(objs);
		Iterator i = collection.createIterator();
		i.last();		
//�����������Ԫ��
		while(!i.isFirst())
		{
			System.out.println(i.getItem().toString());
			 i.previous();
		}
	}
}