import java.io.*;

class PurchaseRequest {
	public double amount;  //һ���ɹ��Ľ��
	public int number;  //�ɹ������
	public String purpose;  //�ɹ�Ŀ��
}

class Approver {  //��������
    public Approver() { successor = null; }
    public void processRequest(PurchaseRequest aRequest){
    	if(successor!=null) {successor.processRequest(aRequest);}
    }
    public void setSuccessor(Approver aSuccessor) { successor = aSuccessor;}
    private Approver successor;
}

class Congress extends Approver{
 	public void processRequest(PurchaseRequest aRequest){
    	if(aRequest.amount>=500000) {/*�����Ƿ������Ĵ���ʡ��*/}
    	else super.processRequest(aRequest);
    }	
}

class Director extends Approver{
 	public void processRequest(PurchaseRequest aRequest){/*�˴�����ʡ��*/}
}

class President extends Approver{
 	public void processRequest(PurchaseRequest aRequest){/*�˴�����ʡ��*/}
}

class VicePresident extends Approver{
 	public void processRequest(PurchaseRequest aRequest){/*�˴�����ʡ��*/}
}

class Test
{
	public static void main(String[] args) throws IOException{
		Congress meeting = new Congress();
		VicePresident sam = new VicePresident();
		Director larry = new Director();
		President tammy = new President();
		//����ְ����
		meeting.setSuccessor(null);
		sam.setSuccessor(tammy);
		tammy.setSuccessor(meeting);
		larry.setSuccessor(sam);
		//����һ�ɹ���������
		PurchaseRequest aRequest = new PurchaseRequest();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		aRequest.amount = Double.parseDouble(br.readLine());
		larry.processRequest(aRequest);
	}
} 