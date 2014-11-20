//�������ࣺ���ϲ�Ʒ
class MainScreen
{
	public String menu;
	public String playList;
	public String mainWindow;
	public String controlBar;
}

//������潨��������������
abstract class ModeBuilder
{
	protected MainScreen screen = new MainScreen();
	public abstract void buildMenu();
	public abstract void buildPlayList();
	public abstract void buildMainWindow();
	public abstract void buildControlBar();
	public MainScreen getScreen()
	{  return screen;  }
}

//����ģʽ���潨���������彨����
class FullModeBuilder extends ModeBuilder
{
	public void buildMenu() { //ʵ�ִ���ʡ��	
	}
	public void buildPlayList() { //ʵ�ִ���ʡ�� 
	}
	public void buildMainWindow() { //ʵ�ִ���ʡ�� 
	}
	public void buildControlBar() { //ʵ�ִ���ʡ�� 
	}
}

//����ģʽ���潨���������彨����
class SimpleModeBuilder extends ModeBuilder
{
	public void buildMenu() { //ʵ�ִ���ʡ��	
	}
	public void buildPlayList() { //ʵ�ִ���ʡ�� 
	}
	public void buildMainWindow() { //ʵ�ִ���ʡ�� 
	}
	public void buildControlBar() { //ʵ�ִ���ʡ�� 
	}
}

//����ģʽ��������ָ����
class ScreenModeController
{
	private ModeBuilder mb;
	public void setModeBuilder(ModeBuilder mb)
	{
		this.mb = mb;
	}
	public MainScreen construct()
	{
		MainScreen ms;
		mb.buildMenu();
		mb.buildPlayList();
		mb.buildMainWindow();
		mb.buildControlBar();
		ms=mb.getScreen();
		return ms;
	}
}

class Test
{
	public static void main(String args[])
	{
		ScreenModeController smc = new ScreenModeController();
		ModeBuilder mb;
		mb = new FullModeBuilder();  //��������ģʽ����
		MainScreen screen;
		smc.setModeBuilder(mb);
		screen = smc.construct();
		System.out.println(screen.menu);
		//��������ʡ��
	}
}