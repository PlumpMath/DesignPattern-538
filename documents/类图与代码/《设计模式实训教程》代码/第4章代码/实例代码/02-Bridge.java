//抽象播放器类：抽象类
abstract class OperationSystemVersion
{
	protected VideoFile vf;
	public void setVideoFile(VideoFile vf)
	{
		this.vf = vf;
	} 
	public abstract void play(String fileName);
}

//抽象视频文件类：抽象实现类
interface VideoFile
{
	public void decode(String osType, String fileName);
} 

//MPEG格式视频文件类：具体实现类
class MPEGFile implements VideoFile
{
	public void decode(String osType, String fileName)
	{
 		System.out.println("格式为MPEG的视频文件" + fileName + "在" + osType + "平台中解码播放。");
 	}	
}

//RMVB格式视频文件类：具体实现类
class RMVBFile implements VideoFile
{
	public void decode(String osType, String fileName)
	{
 		System.out.println("格式为RMVB的视频文件" + fileName + "在" + osType + "平台中解码播放。");
 	}	
}

//AVI格式视频文件类：具体实现类
class AVIFile implements VideoFile
{
	public void decode(String osType, String fileName)
	{
 		System.out.println("格式为AVI的视频文件" + fileName + "在" + osType + "平台中解码播放。");
 	}	
}

//WMV格式视频文件类：具体实现类
class WMVFile implements VideoFile
{
	public void decode(String osType, String fileName)
	{
 		System.out.println("格式为WMV的视频文件" + fileName + "在" + osType + "平台中解码播放。");
 	}
}

//Window播放器类：扩充抽象类
class WindowsVersion extends OperationSystemVersion
{
	public void play(String fileName)
	{
		vf.decode("Windows",fileName);
	}
}

//Linux播放器类：扩充抽象类
class LinuxVersion extends OperationSystemVersion
{
	public void play(String fileName)
	{
		vf.decode("Linux",fileName);
	}
}

//Unix播放器类：扩充抽象类
class UnixVersion extends OperationSystemVersion
{
	public void play(String fileName)
	{
		vf.decode("Unix",fileName);
	}
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
		VideoFile file;
		OperationSystemVersion version;
		file = new RMVBFile();
		version = new WindowsVersion();
		version.setVideoFile(file);
		version.play("《让子弹飞》");
	}
}