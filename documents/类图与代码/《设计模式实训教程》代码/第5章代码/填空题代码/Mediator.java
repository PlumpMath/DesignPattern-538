//抽象中介者类
abstract class Window
{
	//协调窗格之间的相互调用
	public abstract void action(Pane pane,String value);		
}

//具体中介者类
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

//抽象同事类
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

//具体同事类
class TextPane extends Pane
{
	public TextPane(Window window)
	{
		super(window);
	}
	public void update(String value)
	{
		System.out.println("文本窗格值更新，显示值为：" + value);
	}
}

//具体同事类
class ListPane extends Pane
{
	public ListPane(Window window)
	{
		super(window);
	}
	public void update(String value)
	{
		System.out.println("列表窗格值更新，显示值为：" + value);
	}			
}

//具体同事类
class GraphicPane extends Pane
{
	public GraphicPane(Window window)
	{
		super(window);
	}
	public void update(String value)
	{
		System.out.println("图形窗格值更新，显示值为：" + value);
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
		tp.modify("天生我才必有用！");
		System.out.println("----------------------");
		lp.modify("大家好才是真的好！");
	}
}