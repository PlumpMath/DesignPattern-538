class Adapter implements Cat,Dog
{
	private Cat cat;
	private Dog dog;
	public void setCat(Cat cat)
	{
		this.cat = cat;
	}
	public void setDog(Dog dog)
	{
		this.dog = dog;
	}
	public void cry()
	{
		dog.wang();
	}
	public void catchMouse()
	{
		cat.catchMouse();
	}
	public void wang()
	{
		dog.wang();
	}
	public void action()
	{
		cat.catchMouse();
	}
}