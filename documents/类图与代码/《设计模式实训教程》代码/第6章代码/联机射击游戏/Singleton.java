class SceneManager
{
	private static SceneManager sManager = null;
	private SceneManager()
	{
		//��ʼ������
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
		//ҵ�񷽷�
	}
}