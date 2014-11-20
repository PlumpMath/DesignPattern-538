import java.util.*;

abstract class ItemHandler
{
	public abstract void handle(Book item);
	public abstract void handle(Magazine item);
	public abstract void handle(Paper item);
}

class PageHandler extends ItemHandler
{
	public void handle(Book item)
	{  //ͼ��ҳ������
		System.out.println("ͼ�飺��" + item.bookName +  "��ҳ����" + item.totalPages);  
	}
	public void handle(Magazine item)
	{  //�ڿ�ҳ������
		int pages = 0;
	  	for(Object obj : item.papers)
	  	{
	  		pages = pages + ((Paper)obj).pages;
	  	}
		System.out.println("��־����" + item.magazineName + item.magazineNo +  "��ҳ����" + pages);  
		System.out.println("  �����������£�");
		for(Object obj : item.papers)
	  	{
	  		System.out.println("      ���ģ���" + ((Paper)obj).paperTitle +  "��ҳ����" + ((Paper)obj).pages);
	  	}
	}
	public void handle(Paper item)
	{  //����ҳ������ 
			System.out.println("���ģ���" + item.paperTitle +  "��ҳ����" + item.pages);  
	}
}

class AuthorHandler extends ItemHandler
{
	public void handle(Book item)
	{  //ͼ�����ߴ�������ʡ��  
	}
	public void handle(Magazine item)
	{  //�ڿ����ߴ�������ʡ��  
	}
	public void handle(Paper item)
	{  //����ҳ����������ʡ��  
	}
}

interface Item
{
	public void accept(ItemHandler handler);
}

class Magazine implements Item
{
	public List papers = new ArrayList();
	public String magazineName;
	public String magazineNo;
	public void addPaper(Paper paper)
	{
		papers.add(paper);
	}
	public void accept(ItemHandler handler)
	{
		handler.handle(this);
	}
}

class Book implements Item
{
	public String bookName;
	public String author;
	public int totalPages;
	public void accept(ItemHandler handler)
	{
		handler.handle(this);
	}
}

class Paper implements Item
{
	public String paperTitle;
	public String author;
	public int pages;
	public void accept(ItemHandler handler)
	{
		handler.handle(this);
	}
}

class Libaray
{
	private List items = new ArrayList();
	public void addItem(Item item)
	{
		items.add(item);
	}
	public void accept(ItemHandler handler)
	{
		for(Object obj : items)
		{
			((Item)obj).accept(handler);
		}
	}
}

class Test
{
	public static void main(String args[])
	{
		Book book = new Book();
		book.bookName = "21�쾫ͨ������";
		book.author = "���޼�";
		book.totalPages = 450;
		Magazine magazine = new Magazine();
		magazine.magazineName = "����ѧ��";
		magazine.magazineNo = "2011���1��";
		Paper paper1 = new Paper();
		paper1.paperTitle = "��ε����Ʒ�����";
		paper1.author = "���";
		paper1.pages = 12;
		Paper paper2 = new Paper();
		paper2.paperTitle = "�Һ�����Ĺ�����Ե";
		paper2.author = "С��Ů";
		paper2.pages = 8;
		Paper paper3 = new Paper();
		paper3.paperTitle = "�о�����-�����ľŴ�����";
		paper3.author = "����";
		paper3.pages = 30;
		magazine.addPaper(paper1);
		magazine.addPaper(paper2);
		
		Libaray lib = new Libaray();
		lib.addItem(book);
		lib.addItem(magazine);
		lib.addItem(paper3);
		ItemHandler handler = new PageHandler();
		lib.accept(handler);
	}
}