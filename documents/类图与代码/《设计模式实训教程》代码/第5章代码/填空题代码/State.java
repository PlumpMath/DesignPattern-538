public class Door {
	public static final int CLOSED = 1;
	public static final int OPENING = 2;
	public static final int OPEN = 3;
	public static final int CLOSING = 4;
	public static final int STAYOPEN = 5;
	private int state = CLOSED;
	//����״̬�������ò�ͬ��������ʾ��ͬ״̬
	
	private void setState(int state) {
		this.state = state;  //���ô����ŵ�ǰ״̬
	}
	public void getState() {
		//�˴�����ʡ�ԣ����������״̬�ַ�����
		//���磬��ǰ״̬ΪCLOSEDʱ������ַ���Ϊ��CLOSED��
	}
	public void click() {
		if(state == CLOSED)  setState(OPENING);
		else if(state == OPENING)  setState(CLOSING);
		else if(state == OPEN)  setState(STAYOPEN);
	}
	//����timeout�¼�ʱ����״̬ת��
	public void timeout() {
		if(state == OPEN) setState(CLOSING);
	}
	public void complete() { //����complete�¼�ʱ����״̬ת��
		if(state == OPENING)  setState(OPEN);
		else if(state == CLOSING)  setState(CLOSED);
	}
	public static void main(String[] args) {
		Door aDoor = new Door();
		aDoor.getState();  aDoor.click();  aDoor.getState();  aDoor.complete();
		aDoor.getState();  aDoor.click();  aDoor.getState();  aDoor.click();
		aDoor.getState();  return;		
	}
}

public class Door {
	public final DoorState CLOSED = new DoorClosed(this);
	public final DoorState OPENING = new DoorOpening(this);
	public final DoorState OPEN = new DoorOpen(this);
	public final DoorState CLOSING = new DoorClosing(this);
	public final DoorState STAYOPEN = new DoorStayOpen(this);
	private DoorState state = CLOSED;
	
	//���ô����ŵ�ǰ״̬
	public void setState(DoorState state) {
		this.state = state;
	}
	public void getState() {//���ݵ�ǰ״̬�����Ӧ��״̬�ַ���
		System.out.println(state.getClass().getName());
	}
	public void click() { }  //����click�¼�ʱ����״̬ת��
	public void timeout() {	}  //����timeout�¼�ʱ����״̬ת��
	public void complete() {  }  //����complete�¼�ʱ����״̬ת��
	public static void main(String[] args){
		Door aDoor = new Door();
		aDoor.getState();  aDoor.click();  aDoor.getState();  aDoor.complete();
		aDoor.getState();  aDoor.timeout();  aDoor.getState();  return;
	}
}
public abstract class DoorState {  //��������״̬��Ļ���
	protected Door door;
	public DoorState(Door door) {
		this.door = door;
	}
	public void click() {}
	public void complete() {}
	public void timeout() {}
}

class DoorClosed extends DoorState { //����һ��������Closed״̬
	public DoorClosed (Door door) {super(door); }
	public void click() { }
	//���ඨ����������ʡ��
}
//�������ʡ��