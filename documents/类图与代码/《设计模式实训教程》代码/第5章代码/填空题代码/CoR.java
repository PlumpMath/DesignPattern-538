import java.io.*;

class PurchaseRequest {
	public double amount;  //一个采购的金额
	public int number;  //采购单编号
	public String purpose;  //采购目的
}

class Approver {  //审批者类
    public Approver() { successor = null; }
    public void processRequest(PurchaseRequest aRequest){
    	if(successor!=null) {successor.processRequest(aRequest);}
    }
    public void setSuccessor(Approver aSuccessor) { successor = aSuccessor;}
    private Approver successor;
}

class Congress extends Approver{
 	public void processRequest(PurchaseRequest aRequest){
    	if(aRequest.amount>=500000) {/*决定是否审批的代码省略*/}
    	else super.processRequest(aRequest);
    }	
}

class Director extends Approver{
 	public void processRequest(PurchaseRequest aRequest){/*此处代码省略*/}
}

class President extends Approver{
 	public void processRequest(PurchaseRequest aRequest){/*此处代码省略*/}
}

class VicePresident extends Approver{
 	public void processRequest(PurchaseRequest aRequest){/*此处代码省略*/}
}

class Test
{
	public static void main(String[] args) throws IOException{
		Congress meeting = new Congress();
		VicePresident sam = new VicePresident();
		Director larry = new Director();
		President tammy = new President();
		//构造职责链
		meeting.setSuccessor(null);
		sam.setSuccessor(tammy);
		tammy.setSuccessor(meeting);
		larry.setSuccessor(sam);
		//构造一采购审批请求
		PurchaseRequest aRequest = new PurchaseRequest();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		aRequest.amount = Double.parseDouble(br.readLine());
		larry.processRequest(aRequest);
	}
} 