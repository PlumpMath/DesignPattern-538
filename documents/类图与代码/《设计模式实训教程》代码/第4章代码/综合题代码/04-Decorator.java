class Decorator extends Component
{
	private Component component;
	public Decorator(Component component)
	{
		this.component = component;
	}
	public void display()
	{
		component.display();
	}
}

class ScrollBarDecorator extends Decorator
{
	public ScrollBarDecorator(Component component)
	{
		super(component);
	}
	public void display()
	{
		System.out.println("增加滚动条");
		super.display();
	}
}