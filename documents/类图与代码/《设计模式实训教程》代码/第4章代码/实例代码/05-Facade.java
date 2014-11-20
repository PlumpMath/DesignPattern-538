import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//加密外观类：外观类
class EncryptFacade
{
	private FileReader reader;
	private CipherMachine cipher;
	private FileWriter writer;
	
	public EncryptFacade()
	{
		reader = new FileReader();
		cipher = new CipherMachine();
		writer = new FileWriter();
	}
	
	public void fileEncrypt(String fileNameSrc, String fileNameDes)
	{
		String plainStr = reader.read(fileNameSrc);
		String encryptStr = cipher.encrypt(plainStr);
		writer.write(encryptStr,fileNameDes);
	}
}

//文件读取类：子系统类
class FileReader
{
	public String read(String fileNameSrc)
	{
		System.out.println("读取文件，获取明文。");
		StringBuffer sb = new StringBuffer();
		try{
			FileInputStream inFS=new FileInputStream(fileNameSrc);		
			int data;
    		while((data=inFS.read())!=-1)
    		{
    			sb = sb.append((char)data);
    		}
     		inFS.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("文件不存在！");
		}
		catch(IOException e)
		{
			System.out.println("文件操作错误！");
		}
		return sb.toString();
	}
}

//数据加密类：子系统类
class CipherMachine
{
	public String encrypt(String plainText)
	{
		System.out.println("数据加密，将明文转换为密文。");
		String es="";
		for(int i=0;i<plainText.length();i++)
		{
			String c=String.valueOf(plainText.charAt(i)%7);
			es+=c;
		}
		return es;
	}
}

//文件保存类：子系统类
class FileWriter
{
	public void write(String encryptStr,String fileNameDes)
	{
		System.out.println("保存密文，写入文件。");
		try{
     		FileOutputStream outFS = new FileOutputStream(fileNameDes);
      		outFS.write(encryptStr.getBytes());
      		outFS.close();
		}	
		catch(FileNotFoundException e)
		{
			System.out.println("文件不存在！");
		}
		catch(IOException e)
		{
			System.out.println("文件操作错误！");
		}		
	}
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
		EncryptFacade ef = new EncryptFacade();
		ef.fileEncrypt("facade/src.txt","facade/des.txt");
	}
}