//�����Ʒ
interface Shape
{
	public void draw();
	public void erase();
}

//�����Ʒ
class Circle implements Shape
{
	public void draw()
	{
		System.out.println("����Բ��");
	}
	public void erase()
	{
		System.out.println("ɾ��Բ��");
	}
}

//�����Ʒ
class Rectangle implements Shape
{
	public void draw()
	{
		System.out.println("���ƾ���");
	}
	public void erase()
	{
		System.out.println("ɾ������");
	}
}

//�����Ʒ
class Triangle implements Shape
{
	public void draw()
	{
		System.out.println("����������");
	}
	public void erase()
	{
		System.out.println("ɾ��������");
	}
}

//����
class ShapeFactory
{
	//��̬��������
	public static Shape createShape(String type) throws UnsupportedShapeException
	{
		if(type.equalsIgnoreCase("c"))
		{
			return new Circle();
		}
		else if(type.equalsIgnoreCase("r"))
		{
			return new Rectangle();
		}
		else if(type.equalsIgnoreCase("t"))
		{
			return new Triangle();
		}
		else
		{
			throw new UnsupportedShapeException("��֧�ָ���״��");
		}
	} 
}

//�Զ����쳣��
class UnsupportedShapeException extends Exception
{
	public UnsupportedShapeException(String message)
	{
		super(message);
	}
}

//�ͻ��˲�����
class Client
{
	public static void main(String args[])
	{
         try
         {
         	Shape shape;
         	shape=ShapeFactory.createShape("a");
         	shape.draw();
         	shape.erase();
         }
         catch(UnsupportedShapeException e)
         {
         	System.out.println(e.getMessage());
         }
	}
}
