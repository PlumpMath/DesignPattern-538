class NormalState extends State
{
	public void pause()
	{
		//��ͣ����ʡ��
		player.setState(new PauseState(this));
	}
	public void start()
	{
		//���������У��÷���������
	}
	public void attacked()
	{
		//��������ʡ��
		if(lifeValue<=0)
		{
			player.setState(new DeathState(this));
		}
	}
	public void shot()
	{
		//����ʡ��
	}
	public void move()
	{
		//����ʡ��
	}
}