abstract class Component
{
	protected Mediator mediator;
	public void change()
	{
		mediator.change(this);
	}
	public abstract void update();
}

class Button extends Component
{
	//......
	public void update()
	{
		//......
	}
	//......
}
class List extends Component
{
	//......
	public void update()
	{
		//......
	}
	//......
}
class ComboBox extends Component
{
	//......
	public void update()
	{
		//......
	}
	//......	
}
class TextBox extends Component
{
	//......
	public void update()
	{
		//......
	}
	//......	
}
class Label extends Component
{
	//......
	public void update()
	{
		//......
	}
	//......
}

class Mediator
{
	private Button button;
	private List list;
	private ComboBox cb;
	private TextBox tb;
	private Label label;
	//......
	public void change(Component component)
	{
		if(component==button)
		{
			list.update();
			cb.update();
			tb.update();
			label.update();			
		}
		else if(component==list)
		{
			cb.update();
			tb.update();
		}
		else if(component==cb)
		{
			list.update();
			tb.update();			
		}
		else if(component==tb)
		{
			list.update();
			cb.update();			
		}
	}
	//......
}

