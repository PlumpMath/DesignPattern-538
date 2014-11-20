class Calculator
{
	private AbstractCommand command;
	public void setCommand(AbstractCommand command)
	{
		this.command = command;
	}
	public int compute(int x,int y)
	{
		return command.execute(x,y);
	}
}

abstract class AbstractCommand
{
	public abstract int execute(int x,int y);
}

class AddCommand extends AbstractCommand
{
	private Adder adder;
	public AddCommand()
	{
		adder = new Adder();
	}
	public int execute(int x,int y)
	{
		return adder.add(x,y);
	}
}

class Adder
{
	public int add(int x,int y)
	{
		return x+y;
	}
}

class SubCommand extends AbstractCommand
{
	private Suber suber;
	public SubCommand()
	{
		suber = new Suber();
	}
	public int execute(int x,int y)
	{
		return suber.sub(x,y);
	}
}

class Suber
{
	public int sub(int x,int y)
	{
		return x-y;
	}
}

class Client
{
	public static void main(String args[])
	{
		Calculator calculator = new Calculator();
		AbstractCommand command;
		command = new AddCommand();
		calculator.setCommand(command);
		int result = calculator.compute(10,10);
		System.out.println(result);
	}
}