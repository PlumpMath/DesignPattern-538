import java.util.*;
interface Employee
{
	public void accept(Department handler);
}

class FulltimeEmployee implements Employee
{
	private String name;
	private double weeklyWage;
	private int workTime;
	public FulltimeEmployee(String name,double weeklyWage,int workTime)
	{
		this.name = name;
		this.weeklyWage = weeklyWage;
		this.workTime = workTime;
	}	
	public void setName(String name) {
		this.name = name; 
	}
	public void setWeeklyWage(double weeklyWage) {
		this.weeklyWage = weeklyWage; 
	}
	public void setWorkTime(int workTime) {
		this.workTime = workTime; 
	}
	public String getName() {
		return (this.name); 
	}
	public double getWeeklyWage() {
		return (this.weeklyWage); 
	}
	public int getWorkTime() {
		return (this.workTime); 
	}
	public void accept(Department handler)
	{
		handler.visit(this);
	}
}

class ParttimeEmployee implements Employee
{
	private String name;
	private double hourWage;
	private int workTime;
	public ParttimeEmployee(String name,double hourWage,int workTime)
	{
		this.name = name;
		this.hourWage = hourWage;
		this.workTime = workTime;
	}	
	public void setName(String name) {
		this.name = name; 
	}
	public void setHourWage(double hourWage) {
		this.hourWage = hourWage; 
	}
	public void setWorkTime(int workTime) {
		this.workTime = workTime; 
	}
	public String getName() {
		return (this.name); 
	}
	public double getHourWage() {
		return (this.hourWage); 
	}
	public int getWorkTime() {
		return (this.workTime); 
	}
	public void accept(Department handler)
	{
		handler.visit(this);
	}
}

abstract class Department
{
	public abstract void visit(FulltimeEmployee employee);
	public abstract void visit(ParttimeEmployee employee);	
}

class FADepartment extends Department
{
	public void visit(FulltimeEmployee employee)
	{
		int workTime = employee.getWorkTime();
		double weekWage = employee.getWeeklyWage();
		if(workTime > 40)
		{
			weekWage = weekWage + (workTime - 40) * 100;
		}
		else if(workTime < 40)
		{
			weekWage = weekWage - (40 - workTime) * 80;
			if(weekWage < 0)
			{
				weekWage = 0;
			}
		}
		System.out.println("正式员工" + employee.getName() + "实际工资为：" + weekWage + "元。");			
	}
	public void visit(ParttimeEmployee employee)
	{
		int workTime = employee.getWorkTime();
		double hourWage = employee.getHourWage();
		System.out.println("临时工" + employee.getName() + "实际工资为：" + workTime * hourWage + "元。");		
	}		
}

class HRDepartment extends Department
{
	public void visit(FulltimeEmployee employee)
	{
		int workTime = employee.getWorkTime();
		System.out.println("正式员工" + employee.getName() + "实际工作时间为：" + workTime + "小时。");
		if(workTime > 40)
		{
			System.out.println("正式员工" + employee.getName() + "加班时间为：" + (workTime - 40) + "小时。");
		}
		else if(workTime < 40)
		{
			System.out.println("正式员工" + employee.getName() + "请假时间为：" + (40 - workTime) + "小时。");
		}						
	}
	public void visit(ParttimeEmployee employee)
	{
		int workTime = employee.getWorkTime();
		System.out.println("临时工" + employee.getName() + "实际工作时间为：" + workTime + "小时。");
	}		
}

class EmployeeList
{
	private ArrayList list = new ArrayList();
	public void addEmployee(Employee employee)
	{
		list.add(employee);
	}
	public void accept(Department handler)
	{
		for(Object obj : list)
		{
			((Employee)obj).accept(handler);
		}
	}
}

class Client
{
	public static void main(String args[])
	{
		EmployeeList list = new EmployeeList();
		Employee fte1,fte2,fte3,pte1,pte2;
		fte1 = new FulltimeEmployee("张无忌",3200.00,45);
		fte2 = new FulltimeEmployee("杨过",2000.00,40);
		fte3 = new FulltimeEmployee("段誉",2400.00,38);
		pte1 = new ParttimeEmployee("洪七公",80.00,20);
		pte2 = new ParttimeEmployee("郭靖",60.00,18);
		list.addEmployee(fte1);
		list.addEmployee(fte2);
		list.addEmployee(fte3);
		list.addEmployee(pte1);
		list.addEmployee(pte2);
		Department fa,hr;
		fa = new FADepartment();
		hr = new HRDepartment();
		System.out.println("财务部处理数据：");
		list.accept(fa);
		System.out.println("-----------------------------------");
		System.out.println("人力资源部处理数据：");
		list.accept(hr);
	}
}
