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
		this.grade = "入门级";
		this.role = role;
	}
	public PrimaryState(RoleState state)
	{
		this.point = state.point;
		this.grade = "入门级";
		this.role = state.role;
	}
	public void play(int score, String result)
	{
		if(result.equalsIgnoreCase("win"))
		{
			this.point += score;
			System.out.println("玩家" + this.role.getNickname() + "获胜，增加积分" + score + "，当前积分为" + this.point + "。");
		}
		else if(result.equalsIgnoreCase("lose"))
		{
			this.point -= score;
			System.out.println("玩家" + this.role.getNickname() + "失利，减少积分" + score + "，当前积分为" + this.point + "。");
		}
		this.check();
	}
	
	public void doubleScore(int score, String result)
	{
		System.out.println("暂不支持该功能！");
	}
	
	public void changeCards()
	{
		System.out.println("暂不支持该功能！");
	}
	
	public void peekCards()
	{
		System.out.println("暂不支持该功能！");
	}
	
	public void check()  //模拟
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