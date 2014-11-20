public class Door {
	public static final int CLOSED = 1;
	public static final int OPENING = 2;
	public static final int OPEN = 3;
	public static final int CLOSING = 4;
	public static final int STAYOPEN = 5;
	private int state = CLOSED;
	//定义状态变量，用不同的整数表示不同状态
	
	private void setState(int state) {
		this.state = state;  //设置传输门当前状态
	}
	public void getState() {
		//此处代码省略，本方法输出状态字符串，
		//例如，当前状态为CLOSED时，输出字符串为“CLOSED”
	}
	public void click() {
		if(state == CLOSED)  setState(OPENING);
		else if(state == OPENING)  setState(CLOSING);
		else if(state == OPEN)  setState(STAYOPEN);
	}
	//发生timeout事件时进行状态转换
	public void timeout() {
		if(state == OPEN) setState(CLOSING);
	}
	public void complete() { //发生complete事件时进行状态转换
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
	
	//设置传输门当前状态
	public void setState(DoorState state) {
		this.state = state;
	}
	public void getState() {//根据当前状态输出对应的状态字符串
		System.out.println(state.getClass().getName());
	}
	public void click() { }  //发生click事件时进行状态转换
	public void timeout() {	}  //发生timeout事件时进行状态转换
	public void complete() {  }  //发生complete事件时进行状态转换
	public static void main(String[] args){
		Door aDoor = new Door();
		aDoor.getState();  aDoor.click();  aDoor.getState();  aDoor.complete();
		aDoor.getState();  aDoor.timeout();  aDoor.getState();  return;
	}
}
public abstract class DoorState {  //定义所有状态类的基类
	protected Door door;
	public DoorState(Door door) {
		this.door = door;
	}
	public void click() {}
	public void complete() {}
	public void timeout() {}
}

class DoorClosed extends DoorState { //定义一个基本的Closed状态
	public DoorClosed (Door door) {super(door); }
	public void click() { }
	//该类定义的其余代码省略
}
//其余代码省略