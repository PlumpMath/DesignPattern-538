class SceneManager
{
	private static SceneManager sManager = null;
	private SceneManager()
	{
		//初始化代码
	}
	public synchronized static SceneManager getInstance()
	{
		if(sManager==null)
		{
			sManager = new SceneManager();
		}
		return sManager;
	}
	public void manage()
	{
		//业务方法
	}
}