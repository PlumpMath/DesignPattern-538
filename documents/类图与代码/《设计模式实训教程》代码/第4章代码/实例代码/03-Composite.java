import java.util.*;

//�����ļ��ࣺ���󹹼�
abstract class AbstractFile
{
	public abstract void add(AbstractFile element);
	public abstract void remove(AbstractFile element);
	public abstract void display();
}

//�ļ����ࣺ��������
class Folder extends AbstractFile
{
	private ArrayList fileList=new ArrayList();
	private String fileName;	
	public Folder(String fileName)
	{
		this.fileName=fileName;
	}
	public void add(AbstractFile element)
	{
	   fileList.add(element);	
	}
	public void remove(AbstractFile element)
	{
		fileList.remove(element);
	}
	public void display()
	{
		System.out.println("�ļ���-" + fileName + "-�����������ϣ�");
		for(Object obj : fileList)
		{
			((AbstractFile)obj).display();
		}
	}
}

//ͼƬ�ļ��ࣺҶ�ӹ���
class ImageFile extends AbstractFile
{
	private String fileName;
	public ImageFile(String fileName)
	{
		this.fileName=fileName;
	}
	public void add(AbstractFile element)
	{
	   System.out.println("�Բ��𣬲�֧�ָ÷�����");
	}
	public void remove(AbstractFile element)
	{
		System.out.println("�Բ��𣬲�֧�ָ÷�����");
	}
	public void display()
	{
		System.out.println("���ͼƬ�ļ���" + fileName);
	}
}

//�ı��ļ��ࣺҶ�ӹ���
class TextFile extends AbstractFile
{
	private String fileName;
	public TextFile(String fileName)
	{
		this.fileName=fileName;
	}
	public void add(AbstractFile element)
	{
	   System.out.println("�Բ��𣬲�֧�ָ÷�����");
	}
	public void remove(AbstractFile element)
	{
		System.out.println("�Բ��𣬲�֧�ָ÷�����");
	}
	public void display()
	{
		System.out.println("����ı��ļ���" + fileName);
	}
}

//��Ƶ�ļ��ࣺҶ�ӹ���
class VideoFile extends AbstractFile
{
	private String fileName;
	public VideoFile(String fileName)
	{
		this.fileName=fileName;
	}
	public void add(AbstractFile element)
	{
	   System.out.println("�Բ��𣬲�֧�ָ÷�����");
	}
	public void remove(AbstractFile element)
	{
		System.out.println("�Բ��𣬲�֧�ָ÷�����");
	}
	public void display()
	{
		System.out.println("�����Ƶ�ļ���" + fileName);
	}
}

//�ͻ��˲�����
class Client
{
	public static void main(String args[])
	{
		AbstractFile file1,file2,file3,file4,file5,folder1,folder2,folder3;
		file1 = new ImageFile("����.gif");
		file2 = new ImageFile("��Ů.jpg");
		file3 = new TextFile("���ģʽ.txt");
		file4 = new TextFile("Java�������.doc");
		file5 = new VideoFile("�ǳ�����.rmvb");
		folder1 = new Folder("����ͼƬ");
		folder1.add(file1);
		folder1.add(file2);
		folder2 = new Folder("ѧϰ����");
		folder2.add(file3);
		folder2.add(file4);
		folder3 = new Folder("��������");
		folder3.add(file5);
		folder3.add(folder1);
		folder3.add(folder2);	
		folder3.display();
	}
}