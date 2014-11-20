class Button
{
	private List list;
	private ComboBox cb;
	private TextBox tb;
	private Label label;
	//......
	public void change()
	{
		list.update();
		cb.update();
		tb.update();
		label.update();
	}
	public void update()
	{
		//......
	}
	//......
}
class List
{
	private ComboBox cb;
	private TextBox tb;
		//......
	public void change()
	{
		cb.update();
		tb.update();
	}
	public void update()
	{
		//......
	}
	//......	
}
class ComboBox
{
	private List list;
	private TextBox tb;
	//......
	public void change()
	{
		list.update();
		tb.update();
	}
	public void update()
	{
		//......
	}
	//......	
}
class TextBox
{
	private List list;
	private ComboBox cb;
	//......
	public void change()
	{
		list.update();
		cb.update();
	}
	public void update()
	{
		//......
	}
	//......	
}
class Label
{
	//......
	public void update()
	{
		//......
	}
	//......
}


