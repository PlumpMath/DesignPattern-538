//������Ʒ���ϣ�����ۺ���
abstract class AbstractProductList
{
	private String[] productsName;
	public AbstractProductList(String[] productsName)
	{
		this.productsName = productsName;
	}
	public String[] getProductsName()
	{
		return this.productsName;
	}
	public abstract AbstractIterator getIterator();
}

//��Ʒ���ϣ�����ۺ���
class ProductList extends AbstractProductList
{
	public ProductList(String[] productsName)
	{
		super(productsName);
	}
	public AbstractIterator getIterator()
	{
		return new MyIterator(this);
	}
}

//�����������
interface AbstractIterator
{
	public void next();
	public boolean isLast();
	public void previous();
	public boolean isFirst();
	public String getNextItem(); 
	public String getPreviousItem();  
}

//�����������
class MyIterator implements AbstractIterator
{
	private String[] productsName;
	private int index1;
	private int index2;
	public MyIterator(AbstractProductList list)
	{
		productsName = list.getProductsName();
		index1 = 0;
		index2 = productsName.length-1;
	}
	public void next()
	{
		if(index1<productsName.length)
		{
			index1++;
		}
	}
	public boolean isLast()
	{
		return (index1==productsName.length);
	}
	public void previous()
	{
		if(index2>-1)
		{
			index2--;
		}
	}
	public boolean isFirst()
	{
		return (index2==-1);
	}
	public String getNextItem()
	{
		return productsName[index1];
	} 
	public String getPreviousItem()
	{
		return productsName[index2];
	} 	
}

//�ͻ��˲�����
class Client
{
	public static void main(String args[])
	{
		String[] pNames={"ThinkPad����","Tissot�ֱ�","iPhone�ֻ�","LV�����"};
		AbstractIterator iterator;
		AbstractProductList list;
		list = new ProductList(pNames);
		iterator = list.getIterator();	
		while(!iterator.isLast())
		{
			System.out.println(iterator.getNextItem());
			iterator.next();
		}
		System.out.println("-----------------------------");
		
		while(!iterator.isFirst())
		{
			System.out.println(iterator.getPreviousItem());
			iterator.previous();
		}
	}
}