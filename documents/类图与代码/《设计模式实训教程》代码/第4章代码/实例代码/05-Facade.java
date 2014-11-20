import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//��������ࣺ�����
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

//�ļ���ȡ�ࣺ��ϵͳ��
class FileReader
{
	public String read(String fileNameSrc)
	{
		System.out.println("��ȡ�ļ�����ȡ���ġ�");
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
			System.out.println("�ļ������ڣ�");
		}
		catch(IOException e)
		{
			System.out.println("�ļ���������");
		}
		return sb.toString();
	}
}

//���ݼ����ࣺ��ϵͳ��
class CipherMachine
{
	public String encrypt(String plainText)
	{
		System.out.println("���ݼ��ܣ�������ת��Ϊ���ġ�");
		String es="";
		for(int i=0;i<plainText.length();i++)
		{
			String c=String.valueOf(plainText.charAt(i)%7);
			es+=c;
		}
		return es;
	}
}

//�ļ������ࣺ��ϵͳ��
class FileWriter
{
	public void write(String encryptStr,String fileNameDes)
	{
		System.out.println("�������ģ�д���ļ���");
		try{
     		FileOutputStream outFS = new FileOutputStream(fileNameDes);
      		outFS.write(encryptStr.getBytes());
      		outFS.close();
		}	
		catch(FileNotFoundException e)
		{
			System.out.println("�ļ������ڣ�");
		}
		catch(IOException e)
		{
			System.out.println("�ļ���������");
		}		
	}
}

//�ͻ��˲�����
class Client
{
	public static void main(String args[])
	{
		EncryptFacade ef = new EncryptFacade();
		ef.fileEncrypt("facade/src.txt","facade/des.txt");
	}
}