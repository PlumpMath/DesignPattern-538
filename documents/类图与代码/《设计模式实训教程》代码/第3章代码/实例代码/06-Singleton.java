import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//�Ӵ��ڣ�������
class SubFrame extends JInternalFrame
{
	private static SubFrame frame;//��̬ʵ��
	
	//˽�й��캯��
    private SubFrame()
    {
    	super("�Ӵ���", true, true, true, false);
    	this.setLocation(20,20);  //�����ڲ�����λ��  
    	this.setSize(200,200);  //�����ڲ������С 
    	this.addInternalFrameListener(new MyIFListener());//���������¼�
    	this.setVisible(true);
    }
    
    //�������������ش���ʵ��
    public static SubFrame getFrame()
    {
    	if(frame==null)//����������Ϊ��
    	{
    		frame=new SubFrame();//�����ô��壬����ֱ�ӷ��ش���
    	}
    	return frame;//���ش���
    }  
    
    //�¼�������
    class MyIFListener extends InternalFrameAdapter
    {
    	//�Ӵ���ر�ʱ�������������Ϊnull
    	public void internalFrameClosing(InternalFrameEvent e) 
    	{
    		if(frame!=null)
    		{
    			frame=null;
    		}
    	}
    }  
}

//�ͻ��˲�����
class MainClass extends JFrame
{
	private JButton button;
	private JDesktopPane desktopPane; 
	private SubFrame iFrame=null;
	
    public  MainClass()
    {
    	super("������");
    	Container c=this.getContentPane();
    	c.setLayout(new BorderLayout());
		
    	button=new JButton("�������һ���ڲ�����");
    	button.addActionListener(new BtListener());
    	c.add(button, BorderLayout.SOUTH);
    	
    	desktopPane = new JDesktopPane(); //����DesktopPane  
		c.add(desktopPane);
    	
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLocationRelativeTo(null);
    	this.setSize(400,400);
    	this.show();
    }
    
    //�¼�������
    class BtListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{	
    		if(iFrame!=null)
    		{
    			 desktopPane.remove(iFrame);
    		}
    		iFrame=SubFrame.getFrame();
    		desktopPane.add(iFrame);
    	}
    }
    
    public static void main(String[] args) 
    {
    	new MainClass();
	}  
}