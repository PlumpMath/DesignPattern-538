import java.util.*;

//�����������ࣺ�����������
abstract class AwardCheck
{
	public abstract void visit(Teacher teacher);
	public abstract void visit(Student student);
}

//���н������ࣺ�����������
class ScientificAwardCheck extends AwardCheck
{
	public void visit(Teacher teacher)
	{
		if(teacher.getPaperAmount()>=10)
		{
			System.out.println(teacher.getName() + "����ѡ��ʦ���н���");
		}
	}
	public void visit(Student student)	
	{
		if(student.getPaperAmount()>=2)
		{
			System.out.println(student.getName() + "����ѡѧ�����н���");
		}		
	}
}

//�ɼ����㽱�����ࣺ�����������
class ExcellenceAwardCheck extends AwardCheck
{
	public void visit(Teacher teacher)
	{
		if(teacher.getFeedbackScore()>=90)
		{
			System.out.println(teacher.getName() + "����ѡ��ʦ�ɼ����㽱��");
		}		
	}
	public void visit(Student student)
	{
		if(student.getScore()>=90)
		{
			System.out.println(student.getName() + "����ѡѧ���ɼ����㽱��");
		}			
	}
}

//�������ࣺ����Ԫ����
interface Person
{
	public void accept(AwardCheck check);
}

//��ʦ�ࣺ����Ԫ����
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

//ѧ���ࣺ����Ԫ����
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

//��ѡ�˼����ࣺ����ṹ
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

//�ͻ��˲�����
class Client
{
	public static void main(String args[])
	{
		CandidateList list = new CandidateList();
		AwardCheck sac,eac;
		Teacher teacher = new Teacher();
		Student student = new Student();
		teacher.setName("������");
		teacher.setPaperAmount(15);
		teacher.setFeedbackScore(92);
		student.setName("�����");
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
