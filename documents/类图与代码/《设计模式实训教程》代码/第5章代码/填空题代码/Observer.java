import java.util.*;

interface AlarmListener
{
	public void alarm();
}

abstract class Gate
{
	public void action()
	{
		open();
		close();
	}
	
	public abstract void open();
	public abstract void close();
}

class CautionLight implements AlarmListener
{
	public void alarm()
	{
		System.out.println("��ʾ����˸��");
	}
}

class Annunciator implements AlarmListener
{
	public void alarm()
	{
		System.out.println("����������������");
	}
}

class ExitGate extends Gate implements AlarmListener
{
	public void alarm()
	{
	 	super.action();
	}
	
	public void open()
	{
		System.out.println("�����ſ�����");
	}
	
	public void close()
	{
		System.out.println("�����Źرգ�");
	}
}

class ThermoSensor
{
	private ArrayList alarmListeners = new ArrayList();
	
	public void register(AlarmListener al)
	{
		alarmListeners.add(al);
	}
	
	public void trigger()
	{
		for(Object obj:alarmListeners)
		{
			((AlarmListener)obj).alarm();
		}
	}
}

class Test
{
	public static void main(String args[])
	{
		AlarmListener light,annunciator,exitGate;
		light = new CautionLight();
		annunciator = new Annunciator();
		exitGate = new ExitGate();
		
		ThermoSensor sensor;
		sensor = new ThermoSensor();
		
		sensor.register(light);
		sensor.register(annunciator);
		sensor.register(exitGate);
		sensor.trigger();
	}
}