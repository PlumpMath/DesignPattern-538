class FunctionButton
{
	private Command command;
	public void setCommand(Command command)
	{
		this.command = command;
	}
	public void click()
	{
		command.execute();
	}
}

abstract class Command
{
	public abstract void execute();
}

class ExitCommand extends Command
{
	private SystemExitClass seObj;
	public ExitCommand()
	{
		seObj = new SystemExitClass();
	}
	public void execute()
	{
		seObj.exit();
	}
}

class SystemExitClass
{
	public void exit()
	{
		System.out.println("ÍË³öÏµÍ³£¡");
	}
}

class Client
{
	public static void main(String args[])
	{
		FunctionButton fb = new FunctionButton();
		Command command;
		command = new ExitCommand();
		fb.setCommand(command);
		fb.click();
	}
}