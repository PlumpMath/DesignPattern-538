interface Collection
{
	public void setArray(Object objs[]);  //设置数组
	public Object[] getArray();  //获取数组
	public Iterator createIterator();  //创建迭代器
}

interface Iterator
{
	public void first(); //索引指向第一个元素
	public void last(); //索引指向最后一个元素
	public void next(); //索引指向下一个元素
	public void previous(); //索引指向上一个元素
	public boolean isLast();  //判断是否最后一个元素
	public boolean isFirst(); //判断是否第一个元素
	public Object getItem();  //获取当前索引所指向的元素
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
	private int index=0;  //索引变量，初值为0
	
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
		Object[] objs={"北京","上海","广州","深圳","长沙"};
		collection.setArray(objs);
		Iterator i = collection.createIterator();
		i.last();		
//逆向遍历所有元素
		while(!i.isFirst())
		{
			System.out.println(i.getItem().toString());
			 i.previous();
		}
	}
}