import java.util.*;

//抽象奖励审批类：抽象访问者类
abstract class AwardCheck
{
	public abstract void visit(Teacher teacher);
	public abstract void visit(Student student);
}

//科研奖审批类：具体访问者类
class ScientificAwardCheck extends AwardCheck
{
	public void visit(Teacher teacher)
	{
		if(teacher.getPaperAmount()>=10)
		{
			System.out.println(teacher.getName() + "可评选教师科研奖！");
		}
	}
	public void visit(Student student)	
	{
		if(student.getPaperAmount()>=2)
		{
			System.out.println(student.getName() + "可评选学生科研奖！");
		}		
	}
}

//成绩优秀奖审批类：具体访问者类
class ExcellenceAwardCheck extends AwardCheck
{
	public void visit(Teacher teacher)
	{
		if(teacher.getFeedbackScore()>=90)
		{
			System.out.println(teacher.getName() + "可评选教师成绩优秀奖！");
		}		
	}
	public void visit(Student student)
	{
		if(student.getScore()>=90)
		{
			System.out.println(student.getName() + "可评选学生成绩优秀奖！");
		}			
	}
}

//申请人类：抽象元素类
interface Person
{
	public void accept(AwardCheck check);
}

//教师类：具体元素类
class Teacher implements Person
{
	private String name;
	private int paperAmount;
	private double feedbackScore;
	
	public void setName(String name) 
	{
		this.name = name; 
	}

	public void setPaperAmount(int paperAmount)
	{
		this.paperAmount = paperAmount; 
	}

	public void setFeedbackScore(double feedbackScore)
	{
		this.feedbackScore = feedbackScore; 
	}

	public String getName() 
	{
		return (this.name); 
	}

	public int getPaperAmount() 
	{
		return (this.paperAmount); 
	}

	public double getFeedbackScore() 
	{
		return (this.feedbackScore); 
	}
	
	public void accept(AwardCheck check)
	{
		check.visit(this);
	}
}

//学生类：具体元素类
class Student implements Person
{
	private String name;
	private int paperAmount;
	private double score;
	
	public void setName(String name) 
	{
		this.name = name; 
	}

	public void setPaperAmount(int paperAmount) 
	{
		this.paperAmount = paperAmount; 
	}

	public void setScore(double score) 
	{
		this.score = score; 
	}

	public String getName()
	{
		return (this.name); 
	}

	public int getPaperAmount() 
	{
		return (this.paperAmount); 
	}

	public double getScore() 
	{
		return (this.score); 
	}	
	
	public void accept(AwardCheck check)
	{
		check.visit(this);
	}
}

//候选人集合类：对象结构
class CandidateList
{
	private ArrayList<Person> list = new ArrayList<Person>();
	public void addPerson(Person person)
	{
		list.add(person);
	}
	public void removePerson(Person person)
	{
		list.remove(person);
	}
	public void accept(AwardCheck check)
	{
		Iterator i = list.iterator();
		while(i.hasNext())
		{
			((Person)i.next()).accept(check);
		}
	}
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
		CandidateList list = new CandidateList();
		AwardCheck sac,eac;
		Teacher teacher = new Teacher();
		Student student = new Student();
		teacher.setName("风清扬");
		teacher.setPaperAmount(15);
		teacher.setFeedbackScore(92);
		student.setName("令狐冲");
		student.setPaperAmount(2);
		student.setScore(85);
		list.addPerson(teacher);
		list.addPerson(student);
		sac = new ScientificAwardCheck();
		list.accept(sac);
		eac = new ExcellenceAwardCheck();
		list.accept(eac);
	}
}
