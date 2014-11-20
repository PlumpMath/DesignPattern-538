import java.util.*;

//λ���ࣺ�ⲿ״̬��
class Location
{
	private int x;
	private int y;
	public Location(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	//Getter������Setter����ʡ��
} 

//��С�ࣺ�ⲿ״̬��
class Size
{
	private int width;
	private int height;
	public Size(int width,int height)
	{
		this.width = width;
		this.height = height;
	}
	//Getter������Setter����ʡ��
} 

//��ý���ļ��ࣺ������Ԫ��
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

//ͼƬ�ļ��ࣺ������Ԫ��
class Image extends MultimediaFile
{
	private String fileName;
	public Image(String fileName)
	{
		this.fileName = fileName;
	}
	public void display()
	{
		//�������ʾͼƬ�ļ�����ʡ�ԣ�����ʾͼƬʱ��ʹ��size��location����
	}
}

//�����ļ��ࣺ������Ԫ��
class Animation extends MultimediaFile
{
	//�����ļ������ʡ��
}

//��Ƶ�ļ��ࣺ������Ԫ��
class Video extends MultimediaFile
{
	//��Ƶ�ļ������ʡ��
}

//��ý���ļ������ࣺ��Ԫ������
class MultimediaFileFactory
{
	
	private Hashtable ht;  //��Ԫ��
	private int fileNum = 0;  //��Ԫ���������
	
	public MultimediaFileFactory()
	{
		ht = new Hashtable();
	}
	
	//����Ԫ���л�ȡ����
	public MultimediaFile getMultimediaFile(String fileName)
	{
		//�����ļ���׺���ж��ļ�����
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
			//��������ʡ��
		}	
	}
	
	//������Ԫ��������
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
				
		System.out.println(file1==file2);   //������1
		System.out.println(factory.getFileNum());    //������2
	}
}