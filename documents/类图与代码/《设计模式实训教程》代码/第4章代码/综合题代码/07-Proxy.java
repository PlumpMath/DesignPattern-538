class Picture implements Subject
{
	private Application obj;
	public Picture()
	{
		obj = new Application();
	}
	public void run()
	{
		obj.run();
	}
}