import java.util.*;

//位置类：外部状态类
class Location
{
	private int x;
	private int y;
	public Location(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	//Getter方法和Setter方法省略
} 

//大小类：外部状态类
class Size
{
	private int width;
	private int height;
	public Size(int width,int height)
	{
		this.width = width;
		this.height = height;
	}
	//Getter方法和Setter方法省略
} 

//多媒体文件类：抽象享元类
abstract class MultimediaFile
{
	protected Size size;
	protected Location location;
	public abstract void display();
	public void setSize(Size size)
	{
		this.size = size;
	}
	public void setLocation(Location location)
	{
		this.location = location;
	}
}

//图片文件类：具体享元类
class Image extends MultimediaFile
{
	private String fileName;
	public Image(String fileName)
	{
		this.fileName = fileName;
	}
	public void display()
	{
		//导入和显示图片文件代码省略，在显示图片时将使用size和location对象
	}
}

//动画文件类：具体享元类
class Animation extends MultimediaFile
{
	//动画文件类代码省略
}

//视频文件类：具体享元类
class Video extends MultimediaFile
{
	//视频文件类代码省略
}

//多媒体文件工厂类：享元工厂类
class MultimediaFileFactory
{
	
	private Hashtable ht;  //享元池
	private int fileNum = 0;  //享元对象计数器
	
	public MultimediaFileFactory()
	{
		ht = new Hashtable();
	}
	
	//从享元池中获取对象
	public MultimediaFile getMultimediaFile(String fileName)
	{
		//根据文件后缀名判断文件类型
		String[] strArray = fileName.split("\\.");
		int ubound = strArray.length;
		String extendName = strArray[ubound-1];
		
		if(ht.containsKey(fileName))
		{
			return (MultimediaFile)ht.get(fileName);
		}
		else
		{
			if(extendName.equalsIgnoreCase("gif")||extendName.equalsIgnoreCase("jpg"))
			{
				MultimediaFile file = new Image(fileName);
				ht.put(fileName,file);
				fileNum++;
			}
			else if(extendName.equalsIgnoreCase("swf"))
			{
				MultimediaFile file = new Animation(fileName);
				ht.put(fileName,file);
				fileNum++;
			}
			//其他代码省略
		}	
	}
	
	//返回享元对象数量
	public int getFileNum()
	{
		return fileNum;
	}
}

class Test
{
	public static void main(String args[])
	{
		MultimediaFile file1,file2,file3,file4;
		MultimediaFileFactory factory;
		factory = new MultimediaFileFactory();
		
		file1 = factory.getMultimediaFile("sun.jpg");
		file1.setSize(new Size(300,400));
		file1.setLocation(new Location(3,5));
		
		file2 = factory.getMultimediaFile("sun.jpg");
		file2.setSize(new Size(300,400));
		file2.setLocation(new Location(6,5));
		
		file3 = factory.getMultimediaFile("star.swf");
		file3.setSize(new Size(200,200));
		file3.setLocation(new Location(10,1));	
				
		file4 = factory.getMultimediaFile("moon.swf");
		file4.setSize(new Size(400,400));
		file4.setLocation(new Location(15,2));	
				
		System.out.println(file1==file2);   //输出语句1
		System.out.println(factory.getFileNum());    //输出语句2
	}
}