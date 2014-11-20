import java.util.*;

class Class
{
	private ArrayList<Student> students = new ArrayList<Student>();
	
	public void addStudent(Student student)
	{
		students.add(student);
	}
	
	public void displayStudents()
	{
		Comparator comp = new MyComparator();
		Collections.sort(students,comp); 
		Iterator i = students.iterator();
		while(i.hasNext())
		{
			Student student = (Student)i.next();
			System.out.println("������" + student.getSName() + "�����䣺" + student.getSAge());
		}
	}
}

class MyComparator implements Comparator
{
	public int compare(Object obj1,Object obj2) 
	{
		Student s1=(Student)obj1;
		Student s2=(Student)obj2; 
		if(s1.getSAge()<s2.getSAge())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}

class Student
{
	private String sName;
	private int sAge;
	private String sSex;
	
	public Student(String sName,int sAge,String sSex)
	{
		this.sName = sName;
		this.sAge = sAge;
		this.sSex = sSex;
	}
	
	public void setSName(String sName) {
		this.sName = sName; 
	}

	public void setSAge(int sAge) {
		this.sAge = sAge; 
	}

	public void setSSex(String sSex) {
		this.sSex = sSex; 
	}

	public String getSName() {
		return (this.sName); 
	}

	public int getSAge() {
		return (this.sAge); 
	}

	public String getSSex() {
		return (this.sSex); 
	}
}

class MainClass
{
	public static void main(String args[])
	{
		Class obj = new Class();
		Student student1,student2,student3,student4;
		student1 = new Student("���",20,"��");
		student2 = new Student("�����",22,"��");
		student3 = new Student("С��Ů",18,"Ů");
		student4 = new Student("������",19,"Ů");
		obj.addStudent(student1);
		obj.addStudent(student2);
		obj.addStudent(student3);
		obj.addStudent(student4);
		obj.displayStudents();
	}
}