//�����н�����
abstract class Window
{
	//Э������֮����໥����
	public abstract void action(Pane pane,String value);		
}

//�����н�����
class ConcreteWindow extends Window
{
	public TextPane tp;
	public ListPane lp;
	public GraphicPane gp;
	public void action(Pane pane,String value)
	{
		if(pane == tp)
		{
			lp.update(value);
			gp.update(value);
		}
		else if(pane == lp)
		{
			tp.update(value);
			gp.update(value);
		}
		else if(pane == gp)
		{
			lp.update(value);
			tp.update(value);
		}
	}		
}

//����ͬ����
abstract class Pane
{
	protected Window window;
	public Pane(Window window)
	{
		this.window = window;
	}
	public void modify(String value)
	{
		window.action(this,value);
	}
	public abstract void update(String value);
}

//����ͬ����
class TextPane extends Pane
{
	public TextPane(Window window)
	{
		super(window);
	}
	public void update(String value)
	{
		System.out.println("�ı�����ֵ���£���ʾֵΪ��" + value);
	}
}

//����ͬ����
class ListPane extends Pane
{
	public ListPane(Window window)
	{
		super(window);
	}
	public void update(String value)
	{
		System.out.println("�б���ֵ���£���ʾֵΪ��" + value);
	}			
}

//����ͬ����
class GraphicPane extends Pane
{
	public GraphicPane(Window window)
	{
		super(window);
	}
	public void update(String value)
	{
		System.out.println("ͼ�δ���ֵ���£���ʾֵΪ��" + value);
	}		
}

class MainClass
{
	public static void main(String args[])
	{
		ConcreteWindow window = new ConcreteWindow();
		TextPane tp = new TextPane(window);	
		ListPane lp = new ListPane(window);
		GraphicPane gp = new GraphicPane(window);
		window.tp = tp;
		window.lp = lp;
		window.gp = gp;
		tp.modify("�����Ҳű����ã�");
		System.out.println("----------------------");
		lp.modify("��Һò�����ĺã�");
	}
}