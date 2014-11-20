//工作周报：具体原型类
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
			System.out.println("不能复制！");
			return null;
		}
	}
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
		WeeklyLog log_previous = new WeeklyLog();
		log_previous.setName("张三");
		log_previous.setDate("2010年第12周");
		log_previous.setContent("这周工作很忙，每天加班！");
		
		System.out.println("****周报****");
		System.out.println(log_previous.getDate());
		System.out.println(log_previous.getName());
		System.out.println(log_previous.getContent());
		System.out.println("--------------------------------");
		
		WeeklyLog log_now;
		log_now = (WeeklyLog)log_previous.clone();
		log_now.setDate("2010年第13周");
		System.out.println("****周报****");
		System.out.println(log_now.getDate());
		System.out.println(log_now.getName());
		System.out.println(log_now.getContent());
	}
}
