//抽象窗体类：抽象构件类
abstract class Window
{
	public abstract void display();
}

//简单窗体类：具体构件类
class SimpleWindow extends Window
{
	public void display()
	{
		System.out.println("显示窗体！");
	}
}

//窗体装饰类：抽象装饰者类
class WindowDecorator extends Window
{
	private Window window;
	public WindowDecorator(Window window)
	{
		this.window = window;
	}
	public void display()
	{
		window.display();
	}
}

//滚动条窗体装饰类：具体装饰者类
class ScrollbarDecorator extends WindowDecorator
{
	public ScrollbarDecorator(Window window)
	{
		super(window);
	}
	public void display()
	{
		this.setScrollbar();
		super.display();
	}
	public void setScrollbar()
	{
		System.out.println("给窗体增加滚动条！");
	}
}

//透明窗体装饰类：具体装饰者类
class TransparentDecorator extends WindowDecorator
{
	public TransparentDecorator(Window window)
	{
		super(window);
	}
	public void display()
	{
		this.setTransparent();
		super.display();
	}
	public void setTransparent()
	{
		System.out.println("将窗体设置为透明窗体！");
	}
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
		Window windowS,windowSB,windowT;
		windowS = new SimpleWindow();
		windowSB = new ScrollbarDecorator(windowS);
		windowT = new TransparentDecorator(windowSB);
		windowT.display();
	}
}