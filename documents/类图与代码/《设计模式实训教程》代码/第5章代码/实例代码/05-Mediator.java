//���󴰿��ࣺ�����н���
abstract class Dialog
{
	public void showDialog()
	{
		System.out.println("��ʾ������");
	}
	public abstract void widgetChanged(Widget widget);
}

//�¶�ת���������ࣺ�����н���
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
		if(widget==editBox1)  //�����¶��ı���
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

//���󴰿ڲ����ࣺ����ͬ����
abstract class Widget
{
	protected Dialog dialog;
	public void setDialog(Dialog dialog)
	{
		this.dialog = dialog;
	}
	public abstract void changed();
}

//�����¶��ı��򣺾���ͬ����
class FahrenheitEditBox extends Widget
{
	private double value = 50;
	public void setText(double value)
	{
		this.value = value;
		System.out.println("�����¶�����Ϊ" + this.value + "��");		
	}
	public double getText()
	{
		System.out.println("��ȡ�ı����еĻ����¶ȣ�" + this.value + "��");
		return this.value;
	}
	public void changed()
	{
		System.out.println("�����¶��ı���ֵ�ı䣺");
		dialog.widgetChanged(this);
	}
}

//�����¶��ı��򣺾���ͬ����
class CelsiusEditBox extends Widget
{
	private double value = 10;
	public void setText(double value)
	{
		this.value = value;
		System.out.println("�����¶�����Ϊ" + this.value + "��");
	}
	public double getText()
	{
		System.out.println("��ȡ�ı����е������¶ȣ�" + this.value + "��");
		return this.value;
	}
	public void changed()
	{
		dialog.widgetChanged(this);
	}
}

//�¶ȵ�����������ͬ����
class TemperatureBar extends Widget
{
	private double barValue = 10;
	public void setBarValue(double value)
	{
		this.barValue = value;
		System.out.println("�¶ȵ�����ֵΪ" + this.barValue + "���϶ȡ�");
	}
	public double getBarValue()
	{
		System.out.println("��ȡ�¶ȵ������������¶ȣ�" + this.barValue + "��");
		return this.barValue;
	}
	public void changed()
	{
		dialog.widgetChanged(this);
	}
}

//��ť�ࣺͬ����
abstract class Button extends Widget
{
}

//�����¶Ƚ��Ͱ�ť������ͬ����
class FahrenheitLower extends Button
{
	public void changed()
	{
		System.out.println("��������¶Ƚ��Ͱ�ť��");
		dialog.widgetChanged(this);
	}
}

//�����¶����߰�ť������ͬ����
class FahrenheitRaise extends Button
{
	public void changed()
	{
		System.out.println("��������¶����߰�ť��");
		dialog.widgetChanged(this);
	}
}

//�����¶Ƚ��Ͱ�ť������ͬ����
class CelsiusLower extends Button
{
	public void changed()
	{
		System.out.println("��������¶Ƚ��Ͱ�ť��");
		dialog.widgetChanged(this);
	}
}

//�����¶����߰�ť������ͬ����
class CelsiusRaise extends Button
{
	public void changed()
	{
		System.out.println("��������¶����߰�ť��");
		dialog.widgetChanged(this);
	}
}

//�ͻ��˲�����
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
