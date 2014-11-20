//�����ܱ�������ԭ����
class WeeklyLog implements Cloneable
{
	private String name;
	private String date;
	private String content;
	public void setName(String name) {
		this.name = name; 
	}
	public void setDate(String date) {
		this.date = date; 
	}
	public void setContent(String content) {
		this.content = content; 
	}
	public String getName() {
		return (this.name); 
	}
	public String getDate() {
		return (this.date); 
	}
	public String getContent() {
		return (this.content); 
	}
	public WeeklyLog clone()
	{
		Object obj = null;
		try
		{
			obj = super.clone();
			return (WeeklyLog)obj;	
		}
		catch(CloneNotSupportedException e)
		{
			System.out.println("���ܸ��ƣ�");
			return null;
		}
	}
}

//�ͻ��˲�����
class Client
{
	public static void main(String args[])
	{
		WeeklyLog log_previous = new WeeklyLog();
		log_previous.setName("����");
		log_previous.setDate("2010���12��");
		log_previous.setContent("���ܹ�����æ��ÿ��Ӱ࣡");
		
		System.out.println("****�ܱ�****");
		System.out.println(log_previous.getDate());
		System.out.println(log_previous.getName());
		System.out.println(log_previous.getContent());
		System.out.println("--------------------------------");
		
		WeeklyLog log_now;
		log_now = (WeeklyLog)log_previous.clone();
		log_now.setDate("2010���13��");
		System.out.println("****�ܱ�****");
		System.out.println(log_now.getDate());
		System.out.println(log_now.getName());
		System.out.println(log_now.getContent());
	}
}
