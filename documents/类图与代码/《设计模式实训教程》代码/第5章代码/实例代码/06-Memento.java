//游戏场景类：原发器
class GameScene
{
	private String scene;
	private int lifeValue;
	public void setScene(String scene) 
	{
		this.scene = scene; 
	}
	public void setLifeValue(int lifeValue) 
	{
		this.lifeValue = lifeValue; 
	}
	public String getScene() 
	{
		return (this.scene); 
	}
	public int getLifeValue() 
	{
		return (this.lifeValue); 
	}
	public void restore(SceneMemento m)
	{
		this.scene = m.getScene();
		this.lifeValue = m.getLifeValue();
	}
	public SceneMemento save()
	{
		return new SceneMemento(this.scene,this.lifeValue);
	}
	public void display()
	{
		System.out.print("当前游戏场景为：" + this.scene + "，");
		System.out.println("您还有" + this.lifeValue + "条命！");
	}
}

//场景备忘录
class SceneMemento
{
	private String scene;
	private int lifeValue;
	SceneMemento(String scene,int lifeValue)
	{
		this.scene = scene;
		this.lifeValue = lifeValue;
	}
	void setScene(String scene) 
	{
		this.scene = scene; 
	}
	void setLifeValue(int lifeValue) 
	{
		this.lifeValue = lifeValue; 
	}
	String getScene() 
	{
		return (this.scene); 
	}
	int getLifeValue() 
	{
		return (this.lifeValue); 
	}
}

//负责人
class Caretaker
{
	private SceneMemento memento;
	public SceneMemento getSceneMemento()
	{
		return this.memento;
	}
	public void setSceneMemento(SceneMemento memento)
	{
		this.memento = memento;
	}
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
		GameScene scene = new GameScene();
		Caretaker ct = new Caretaker();
		scene.setScene("无名湖");
		scene.setLifeValue(3);
		System.out.println("原始状态：");
		scene.display();
		ct.setSceneMemento(scene.save());
		System.out.println("------------------------");
		
		scene.setScene("魔鬼洞");
		scene.setLifeValue(0);
		System.out.println("牺牲状态：");
		scene.display();
		System.out.println("------------------------");
		
		scene.restore(ct.getSceneMemento());
		System.out.println("恢复到原始状态：");
		scene.display();
		System.out.println("------------------------");		
	}
}