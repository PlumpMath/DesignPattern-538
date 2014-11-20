//�������ࣺ���󹹼���
abstract class Window
{
	public abstract void display();
}

//�򵥴����ࣺ���幹����
class SimpleWindow extends Window
{
	public void display()
	{
		System.out.println("��ʾ���壡");
	}
}

//����װ���ࣺ����װ������
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

//����������װ���ࣺ����װ������
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
		System.out.println("���������ӹ�������");
	}
}

//͸������װ���ࣺ����װ������
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
		System.out.println("����������Ϊ͸�����壡");
	}
}

//�ͻ��˲�����
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