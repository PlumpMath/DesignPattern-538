import java.util.*;

//抽象命令
interface Command
{
	public void execute();
}

//菜单项类：发送者（调用者）
class MenuItem
{
	private String name;
	private Command command;
	public MenuItem(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Command getCommand()
	{
		return this.command;
	}
	public void setCommand(Command command)
	{
		this.command = command;
	}
	public void click()
	{
		command.execute();
	}
}

//菜单类
class Menu
{
	public ArrayList itemList = new ArrayList();
	public void addMenuItem(MenuItem item)
	{
		itemList.add(item);
	}
}

//打开命令：具体命令
class OpenCommand implements Command
{
	private BoardScreen screen;
	public OpenCommand(BoardScreen screen)
	{
		this.screen = screen;
	}
	public void execute()
	{
		screen.open();
	}
}

//新建命令：具体命令
class CreateCommand implements Command
{
	private BoardScreen screen;
	public CreateCommand(BoardScreen screen)
	{
		this.screen = screen;
	}
	public void execute()
	{
		screen.create();
	}
}

//编辑命令：具体命令
class EditCommand implements Command
{
	private BoardScreen screen;
	public EditCommand(BoardScreen screen)
	{
		this.screen = screen;
	}
	public void execute()
	{
		screen.edit();
	}
}

//公告板系统界面：接收者
class BoardScreen
{
	private Menu menu;
	private MenuItem openItem,createItem,editItem;
	public BoardScreen()
	{
		menu = new Menu();
		openItem = new MenuItem("打开");
		createItem = new MenuItem("新建");
		editItem = new MenuItem("编辑");
		menu.addMenuItem(openItem);
		menu.addMenuItem(createItem);
		menu.addMenuItem(editItem);
	}
	public void display()
	{
		System.out.println("主菜单选项：");
		for(Object obj:menu.itemList)
		{
			System.out.println(((MenuItem)obj).getName());
		}
	}
	public void open()
	{
		System.out.println("显示打开窗口！");
	}
	public void create()
	{
		System.out.println("显示新建窗口！");
	}
	public void edit()
	{
		System.out.println("显示编辑窗口！");
	}
	public Menu getMenu()
	{
		return menu;
	}
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
		BoardScreen screen = new BoardScreen();
		Menu menu = screen.getMenu();
		Command openCommand,createCommand,editCommand;
		openCommand = new OpenCommand(screen);
		createCommand = new CreateCommand(screen);
		editCommand = new EditCommand(screen);
		MenuItem openItem,createItem,editItem;
		openItem = (MenuItem)menu.itemList.get(0);
		createItem = (MenuItem)menu.itemList.get(1);
		editItem = (MenuItem)menu.itemList.get(2);
		openItem.setCommand(openCommand);
		createItem.setCommand(createCommand);
		editItem.setCommand(editCommand);
		screen.display();
		openItem.click();
		createItem.click();
		editItem.click();
	}
}