import java.util.*;

//��������
interface Command
{
	public void execute();
}

//�˵����ࣺ�����ߣ������ߣ�
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

//�˵���
class Menu
{
	public ArrayList itemList = new ArrayList();
	public void addMenuItem(MenuItem item)
	{
		itemList.add(item);
	}
}

//�������������
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

//�½������������
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

//�༭�����������
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

//�����ϵͳ���棺������
class BoardScreen
{
	private Menu menu;
	private MenuItem openItem,createItem,editItem;
	public BoardScreen()
	{
		menu = new Menu();
		openItem = new MenuItem("��");
		createItem = new MenuItem("�½�");
		editItem = new MenuItem("�༭");
		menu.addMenuItem(openItem);
		menu.addMenuItem(createItem);
		menu.addMenuItem(editItem);
	}
	public void display()
	{
		System.out.println("���˵�ѡ�");
		for(Object obj:menu.itemList)
		{
			System.out.println(((MenuItem)obj).getName());
		}
	}
	public void open()
	{
		System.out.println("��ʾ�򿪴��ڣ�");
	}
	public void create()
	{
		System.out.println("��ʾ�½����ڣ�");
	}
	public void edit()
	{
		System.out.println("��ʾ�༭���ڣ�");
	}
	public Menu getMenu()
	{
		return menu;
	}
}

//�ͻ��˲�����
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