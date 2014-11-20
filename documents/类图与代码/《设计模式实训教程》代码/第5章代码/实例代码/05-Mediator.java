//抽象窗口类：抽象中介者
abstract class Dialog
{
	public void showDialog()
	{
		System.out.println("显示主界面");
	}
	public abstract void widgetChanged(Widget widget);
}

//温度转换器窗口类：具体中介者
class TemperatureConvertorDialog extends Dialog
{
	public FahrenheitEditBox editBox1;
	public CelsiusEditBox editBox2;
	public TemperatureBar tempBar;
	public FahrenheitLower fLower;
	public CelsiusLower cLower;
	public FahrenheitRaise fRaise;
	public CelsiusRaise cRaise;
	public void widgetChanged(Widget widget)
	{
		if(widget==editBox1)  //华氏温度文本框
		{
			double value = editBox1.getText();
			double temp = (value - 32) * 5 /9;
			editBox2.setText(temp);
			tempBar.setBarValue(temp);
		}
		else if(widget==editBox2)
		{
			double value = editBox2.getText();
			double temp = 9 * value /5 +32;
			editBox1.setText(temp);
			tempBar.setBarValue(value);
		}
		else if(widget==tempBar)
		{
			double value = tempBar.getBarValue();
			double temp = 9 * value /5 +32;
			editBox1.setText(temp);
			tempBar.setBarValue(value);	
		}
		else if(widget==fLower)
		{
			double temp1 = editBox1.getText() - 1;
			editBox1.setText(temp1);
			double temp2 = (temp1 - 32) * 5 /9;
			editBox2.setText(temp2);
			tempBar.setBarValue(temp2);	
		}
		else if(widget==fRaise)
		{
			double temp1 = editBox1.getText() + 1;
			editBox1.setText(temp1);
			double temp2 = (temp1 - 32) * 5 /9;
			editBox2.setText(temp2);
			tempBar.setBarValue(temp2);				
		}
		else if(widget==cLower)
		{
			double temp1 = editBox2.getText() - 1;
			editBox2.setText(temp1);
			tempBar.setBarValue(temp1);
			double temp2 = 9 * temp1 /5 +32;
			editBox1.setText(temp2);			
		}
		else if(widget==cRaise)
		{
			double temp1 = editBox2.getText() + 1;
			editBox2.setText(temp1);
			tempBar.setBarValue(temp1);
			double temp2 = 9 * temp1 /5 +32;
			editBox1.setText(temp2);			
		}
	}
}

//抽象窗口部件类：抽象同事类
abstract class Widget
{
	protected Dialog dialog;
	public void setDialog(Dialog dialog)
	{
		this.dialog = dialog;
	}
	public abstract void changed();
}

//华氏温度文本框：具体同事类
class FahrenheitEditBox extends Widget
{
	private double value = 50;
	public void setText(double value)
	{
		this.value = value;
		System.out.println("华氏温度设置为" + this.value + "。");		
	}
	public double getText()
	{
		System.out.println("获取文本框中的华氏温度：" + this.value + "。");
		return this.value;
	}
	public void changed()
	{
		System.out.println("华氏温度文本框值改变：");
		dialog.widgetChanged(this);
	}
}

//摄氏温度文本框：具体同事类
class CelsiusEditBox extends Widget
{
	private double value = 10;
	public void setText(double value)
	{
		this.value = value;
		System.out.println("摄氏温度设置为" + this.value + "。");
	}
	public double getText()
	{
		System.out.println("获取文本框中的摄氏温度：" + this.value + "。");
		return this.value;
	}
	public void changed()
	{
		dialog.widgetChanged(this);
	}
}

//温度调节条：具体同事类
class TemperatureBar extends Widget
{
	private double barValue = 10;
	public void setBarValue(double value)
	{
		this.barValue = value;
		System.out.println("温度调节条值为" + this.barValue + "摄氏度。");
	}
	public double getBarValue()
	{
		System.out.println("获取温度调节条的摄氏温度：" + this.barValue + "。");
		return this.barValue;
	}
	public void changed()
	{
		dialog.widgetChanged(this);
	}
}

//按钮类：同事类
abstract class Button extends Widget
{
}

//华氏温度降低按钮：具体同事类
class FahrenheitLower extends Button
{
	public void changed()
	{
		System.out.println("点击华氏温度降低按钮：");
		dialog.widgetChanged(this);
	}
}

//华氏温度升高按钮：具体同事类
class FahrenheitRaise extends Button
{
	public void changed()
	{
		System.out.println("点击华氏温度升高按钮：");
		dialog.widgetChanged(this);
	}
}

//摄氏温度降低按钮：具体同事类
class CelsiusLower extends Button
{
	public void changed()
	{
		System.out.println("点击摄氏温度降低按钮：");
		dialog.widgetChanged(this);
	}
}

//摄氏温度升高按钮：具体同事类
class CelsiusRaise extends Button
{
	public void changed()
	{
		System.out.println("点击摄氏温度升高按钮：");
		dialog.widgetChanged(this);
	}
}

//客户端测试类
class Client
{
	public static void main(String args[])
	{
		TemperatureConvertorDialog dialog;
		dialog = new TemperatureConvertorDialog();
		FahrenheitEditBox editBox1 = new FahrenheitEditBox();
		CelsiusEditBox editBox2 = new CelsiusEditBox();
	    TemperatureBar tempBar = new TemperatureBar();
	    FahrenheitLower fLower = new FahrenheitLower();
	    CelsiusLower cLower = new CelsiusLower();
        FahrenheitRaise fRaise = new FahrenheitRaise();
	    CelsiusRaise cRaise = new CelsiusRaise();
		editBox1.setDialog(dialog);
		editBox2.setDialog(dialog);
		tempBar.setDialog(dialog);
		fLower.setDialog(dialog);
		cLower.setDialog(dialog);
		fRaise.setDialog(dialog);
		cRaise.setDialog(dialog);
		dialog.showDialog();
		dialog.editBox1 = editBox1;
		dialog.editBox2 = editBox2;
		dialog.tempBar = tempBar;
		dialog.fLower = fLower;
		dialog.cLower = cLower;
		dialog.fRaise = fRaise;
		dialog.cRaise = cRaise;
		editBox1.changed();
		System.out.println("-------------------");
		fRaise.changed();
		System.out.println("-------------------");
		tempBar.setBarValue(20);
		tempBar.changed();
		System.out.println("-------------------");
	}
}
