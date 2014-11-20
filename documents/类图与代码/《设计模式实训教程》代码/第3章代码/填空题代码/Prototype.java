import java.io.*;

class DataSet implements Serializable
{
	//����ʵ�ִ���ʡ��
}

class Color implements Serializable
{
	//����ʵ�ִ���ʡ��
}

class DataChart implements Serializable
{
	private DataSet ds = new DataSet();
	private Color color = new Color();
	private int no;	
	public void setDs(DataSet ds) {
		this.ds = ds; 
	}
	public void setColor(Color color) {
		this.color = color; 
	}
	public void setNo(int no) {
		this.no = no;
	}
	public DataSet getDs() {
		return this.ds; 
	}
	public Color getColor() {
		return this.color; 
	}
	public int getNo() {
		return this.no;
	}
	public void display() {
		//����ʵ�ִ���ʡ��
	}
	public Object deepClone() throws IOException, ClassNotFoundException, OptionalDataException
	{
		//������д������
		ByteArrayOutputStream bao=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bao);
		oos.writeObject(this);
		
		//�����������ȡ��
		ByteArrayInputStream bis=new ByteArrayInputStream(bao.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bis);
		return(ois.readObject());
	}
}

class Test
{
	public static void main(String args[])
	{
		DataChart chart1,chart2=null;
		chart1=new DataChart();
		
		try{
			chart2=(DataChart)chart1.deepClone();	
		}
		catch(Exception e){
	   		e.printStackTrace();
	    }

		System.out.println(chart1==chart2); 
		System.out.println(chart1.getDs()==chart2.getDs());	
		System.out.println(chart1.getNo()==chart2.getNo()); 		
	}
}

