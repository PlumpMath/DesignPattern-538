//主界面类：复合产品
class MainScreen
{
	public String menu;
	public String playList;
	public String mainWindow;
	public String controlBar;
}

//抽象界面建造器：抽象建造者
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

//完整模式界面建造器：具体建造者
class FullModeBuilder extends ModeBuilder
{
	public void buildMenu() { //实现代码省略	
	}
	public void buildPlayList() { //实现代码省略 
	}
	public void buildMainWindow() { //实现代码省略 
	}
	public void buildControlBar() { //实现代码省略 
	}
}

//精简模式界面建造器：具体建造者
class SimpleModeBuilder extends ModeBuilder
{
	public void buildMenu() { //实现代码省略	
	}
	public void buildPlayList() { //实现代码省略 
	}
	public void buildMainWindow() { //实现代码省略 
	}
	public void buildControlBar() { //实现代码省略 
	}
}

//界面模式控制器：指挥者
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
		mb = new FullModeBuilder();  //构造完整模式界面
		MainScreen screen;
		smc.setModeBuilder(mb);
		screen = smc.construct();
		System.out.println(screen.menu);
		//其他代码省略
	}
}