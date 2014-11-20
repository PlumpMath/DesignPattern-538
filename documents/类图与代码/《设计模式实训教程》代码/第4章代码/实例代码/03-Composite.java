import java.util.*;

//抽象文件类：抽象构件
abstract class AbstractFile
{
	public abstract void add(AbstractFile element);
	public abstract void remove(AbstractFile element);
	public abstract void display();
}

//文件夹类：容器构件
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
		System.out.println("文件夹-" + fileName + "-包含如下资料：");
		for(Object obj : fileList)
		{
			((AbstractFile)obj).display();
		}
	}
}

//图片文件类：叶子构件
class ImageFile extends AbstractFile
{
	private String fileName;
	public ImageFile(String fileName)
	{
		this.fileName=fileName;
	}
	public void add(AbstractFile element)
	{
	   System.out.println("对不起，不支持该方法！");
	}
	public void remove(AbstractFile element)
	{
		System.out.println("对不起，不支持该方法！");
	}
	public void display()
	{
		System.out.println("浏览图片文件：" + fileName);
	}
}

//文本文件类：叶子构件
class TextFile extends AbstractFile
{
	private String fileName;
	public TextFile(String fileName)
	{
		this.fileName=fileName;
	}
	public void add(AbstractFile element)
	{
	   System.out.println("对不起，不支持该方法！");
	}
	public void remove(AbstractFile element)
	{
		System.out.println("对不起，不支持该方法！");
	}
	public void display()
	{
		System.out.println("浏览文本文件：" + fileName);
	}
}

//视频文件类：叶子构件
class VideoFile extends AbstractFile
{
	private String fileName;
	public VideoFile(String fileName)
	{
		this.fileName=fileName;
	}
	public void add(AbstractFile element)
	{
	   System.out.println("对不起，不支持该方法！");
	}
	public void remove(AbstractFile element)
	{
		System.out.println("对不起，不支持该方法！");
	}
	public void display()
	{
		System.out.println("浏览视频文件：" + fileName);
	}
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
		AbstractFile file1,file2,file3,file4,file5,folder1,folder2,folder3;
		file1 = new ImageFile("房子.gif");
		file2 = new ImageFile("美女.jpg");
		file3 = new TextFile("设计模式.txt");
		file4 = new TextFile("Java程序设计.doc");
		file5 = new VideoFile("非诚勿扰.rmvb");
		folder1 = new Folder("最新图片");
		folder1.add(file1);
		folder1.add(file2);
		folder2 = new Folder("学习资料");
		folder2.add(file3);
		folder2.add(file4);
		folder3 = new Folder("个人资料");
		folder3.add(file5);
		folder3.add(folder1);
		folder3.add(folder2);	
		folder3.display();
	}
}