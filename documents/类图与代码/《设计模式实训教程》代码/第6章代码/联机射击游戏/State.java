class NormalState extends State
{
	public void pause()
	{
		//暂停代码省略
		player.setState(new PauseState(this));
	}
	public void start()
	{
		//正在运行中，该方法不可用
	}
	public void attacked()
	{
		//其他代码省略
		if(lifeValue<=0)
		{
			player.setState(new DeathState(this));
		}
	}
	public void shot()
	{
		//代码省略
	}
	public void move()
	{
		//代码省略
	}
}