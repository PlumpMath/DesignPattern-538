import java.util.*;

abstract class Unit
{
	public abstract void handleArchives();
}

class Office extends Unit
{
 	private String name;
 	public Office(String name)
 	{
 		this.name = name;
 	}	
 	
 	public void handleArchives()
 	{
 		System.out.println(this.name + "处理公文！");
 	}
}

class Institution extends Unit
{
	private ArrayList list = new ArrayList();
	private String name;
	public Institution(String name)
	{
		this.name = name;
	}
	
	public void add(Unit unit)
	{
		list.add(unit);
	}
	
	public void handleArchives()
	{
		System.out.println(this.name + "接收并下发公文：");
		for(Object obj : list)
		{
			((Unit)obj).handleArchives();
		}
	}
}

class Client
{
	public static void main(String args[])
	{
		Institution bjHeadquarters,hnSubSchool,csTeachingPost,xtTeachingPost;
		Unit tOffice1,tOffice2,tOffice3,tOffice4,aOffice1,aOffice2,aOffice3,aOffice4;
		bjHeadquarters = new Institution("北京总部");
		hnSubSchool = new Institution("湖南分校");
		csTeachingPost = new Institution("长沙教学点");
		xtTeachingPost = new Institution("湘潭教学点");
		tOffice1 = new Office("北京教务办公室");
		tOffice2 = new Office("湖南教务办公室");
		tOffice3 = new Office("长沙教务办公室");
		tOffice4 = new Office("湘潭教务办公室");
		aOffice1 = new Office("北京行政办公室");
		aOffice2 = new Office("湖南行政办公室");
		aOffice3 = new Office("长沙行政办公室");
		aOffice4 = new Office("湘潭行政办公室");
		csTeachingPost.add(tOffice3);
		csTeachingPost.add(aOffice3);
		xtTeachingPost.add(tOffice4);
		xtTeachingPost.add(aOffice4);
		hnSubSchool.add(csTeachingPost);
		hnSubSchool.add(xtTeachingPost);
		hnSubSchool.add(tOffice2);
		hnSubSchool.add(aOffice2);
		bjHeadquarters.add(hnSubSchool);
		bjHeadquarters.add(tOffice1);
		bjHeadquarters.add(aOffice1);
		bjHeadquarters.handleArchives();
	}
}