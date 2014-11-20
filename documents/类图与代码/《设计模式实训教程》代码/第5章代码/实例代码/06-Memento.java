//��Ϸ�����ࣺԭ����
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
		System.out.print("��ǰ��Ϸ����Ϊ��" + this.scene + "��");
		System.out.println("������" + this.lifeValue + "������");
	}
}

//��������¼
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

//������
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

//�ͻ��˲�����
class Client
{
	public static void main(String args[])
	{
		GameScene scene = new GameScene();
		Caretaker ct = new Caretaker();
		scene.setScene("������");
		scene.setLifeValue(3);
		System.out.println("ԭʼ״̬��");
		scene.display();
		ct.setSceneMemento(scene.save());
		System.out.println("------------------------");
		
		scene.setScene("ħ��");
		scene.setLifeValue(0);
		System.out.println("����״̬��");
		scene.display();
		System.out.println("------------------------");
		
		scene.restore(ct.getSceneMemento());
		System.out.println("�ָ���ԭʼ״̬��");
		scene.display();
		System.out.println("------------------------");		
	}
}