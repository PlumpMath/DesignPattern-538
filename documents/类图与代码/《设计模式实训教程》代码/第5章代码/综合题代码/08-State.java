class PlayerRole
{
	private String nickname;
	private RoleState state;
	public PlayerRole(String nickname)
	{
		this.nickname = nickname;
	}
	public String getNickname()
	{
		return this.nickname;
	}
	public void setState(RoleState state)
	{
		this.state = state;
	}
	public void play(int score, String result)
	{
		state.play(score,result);
	}
	public void doubleScore(int score, String result)
	{
		state.doubleScore(score,result);
	}
	public void changeCards()
	{
		state.changeCards();
	}
	public void peekCards()
	{
		state.peekCards();
	}
}

abstract class RoleState
{
	protected PlayerRole role;
	protected int point;
	protected String grade;
	public abstract void play(int score, String result);
	public abstract void doubleScore(int score, String result);
	public abstract void changeCards();
	public abstract void peekCards();
	public abstract void check();
}

class PrimaryState extends RoleState
{
	public PrimaryState(PlayerRole role)
	{
		this.point = 0;
		this.grade = "���ż�";
		this.role = role;
	}
	public PrimaryState(RoleState state)
	{
		this.point = state.point;
		this.grade = "���ż�";
		this.role = state.role;
	}
	public void play(int score, String result)
	{
		if(result.equalsIgnoreCase("win"))
		{
			this.point += score;
			System.out.println("���" + this.role.getNickname() + "��ʤ�����ӻ���" + score + "����ǰ����Ϊ" + this.point + "��");
		}
		else if(result.equalsIgnoreCase("lose"))
		{
			this.point -= score;
			System.out.println("���" + this.role.getNickname() + "ʧ�������ٻ���" + score + "����ǰ����Ϊ" + this.point + "��");
		}
		this.check();
	}
	
	public void doubleScore(int score, String result)
	{
		System.out.println("�ݲ�֧�ָù��ܣ�");
	}
	
	public void changeCards()
	{
		System.out.println("�ݲ�֧�ָù��ܣ�");
	}
	
	public void peekCards()
	{
		System.out.println("�ݲ�֧�ָù��ܣ�");
	}
	
	public void check()  //ģ��
	{
		if(this.point >= 10000)
		{
			this.role.setState(new FinalState(this));
		}
		else if(this.point >= 5000)
		{
			this.role.setState(new ProfessionalState(this));
		}
		else if(this.point >= 1000)
		{
			this.role.setState(new SecondaryState(this));			
		}
	}
}