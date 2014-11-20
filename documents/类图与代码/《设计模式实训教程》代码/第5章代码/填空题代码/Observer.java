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
		System.out.println("警示灯闪烁！");
	}
}

class Annunciator implements AlarmListener
{
	public void alarm()
	{
		System.out.println("报警器发出警报！");
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
		System.out.println("逃生门开启！");
	}
	
	public void close()
	{
		System.out.println("隔热门关闭！");
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