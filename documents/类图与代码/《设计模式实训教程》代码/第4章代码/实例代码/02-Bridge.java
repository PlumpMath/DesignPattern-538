//���󲥷����ࣺ������
abstract class OperationSystemVersion
{
	protected VideoFile vf;
	public void setVideoFile(VideoFile vf)
	{
		this.vf = vf;
	} 
	public abstract void play(String fileName);
}

//������Ƶ�ļ��ࣺ����ʵ����
interface VideoFile
{
	public void decode(String osType, String fileName);
} 

//MPEG��ʽ��Ƶ�ļ��ࣺ����ʵ����
class MPEGFile implements VideoFile
{
	public void decode(String osType, String fileName)
	{
 		System.out.println("��ʽΪMPEG����Ƶ�ļ�" + fileName + "��" + osType + "ƽ̨�н��벥�š�");
 	}	
}

//RMVB��ʽ��Ƶ�ļ��ࣺ����ʵ����
class RMVBFile implements VideoFile
{
	public void decode(String osType, String fileName)
	{
 		System.out.println("��ʽΪRMVB����Ƶ�ļ�" + fileName + "��" + osType + "ƽ̨�н��벥�š�");
 	}	
}

//AVI��ʽ��Ƶ�ļ��ࣺ����ʵ����
class AVIFile implements VideoFile
{
	public void decode(String osType, String fileName)
	{
 		System.out.println("��ʽΪAVI����Ƶ�ļ�" + fileName + "��" + osType + "ƽ̨�н��벥�š�");
 	}	
}

//WMV��ʽ��Ƶ�ļ��ࣺ����ʵ����
class WMVFile implements VideoFile
{
	public void decode(String osType, String fileName)
	{
 		System.out.println("��ʽΪWMV����Ƶ�ļ�" + fileName + "��" + osType + "ƽ̨�н��벥�š�");
 	}
}

//Window�������ࣺ���������
class WindowsVersion extends OperationSystemVersion
{
	public void play(String fileName)
	{
		vf.decode("Windows",fileName);
	}
}

//Linux�������ࣺ���������
class LinuxVersion extends OperationSystemVersion
{
	public void play(String fileName)
	{
		vf.decode("Linux",fileName);
	}
}

//Unix�������ࣺ���������
class UnixVersion extends OperationSystemVersion
{
	public void play(String fileName)
	{
		vf.decode("Unix",fileName);
	}
}

//�ͻ��˲�����
class Client
{
	public static void main(String args[])
	{
		VideoFile file;
		OperationSystemVersion version;
		file = new RMVBFile();
		version = new WindowsVersion();
		version.setVideoFile(file);
		version.play("�����ӵ��ɡ�");
	}
}