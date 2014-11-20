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
 		System.out.println(this.name + "�����ģ�");
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
		System.out.println(this.name + "���ղ��·����ģ�");
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
		bjHeadquarters = new Institution("�����ܲ�");
		hnSubSchool = new Institution("���Ϸ�У");
		csTeachingPost = new Institution("��ɳ��ѧ��");
		xtTeachingPost = new Institution("��̶��ѧ��");
		tOffice1 = new Office("��������칫��");
		tOffice2 = new Office("���Ͻ���칫��");
		tOffice3 = new Office("��ɳ����칫��");
		tOffice4 = new Office("��̶����칫��");
		aOffice1 = new Office("���������칫��");
		aOffice2 = new Office("���������칫��");
		aOffice3 = new Office("��ɳ�����칫��");
		aOffice4 = new Office("��̶�����칫��");
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