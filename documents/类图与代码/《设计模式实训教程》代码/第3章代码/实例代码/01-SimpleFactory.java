//抽象产品
interface Shape
{
	public void draw();
	public void erase();
}

//具体产品
class Circle implements Shape
{
	public void draw()
	{
		System.out.println("绘制圆形");
	}
	public void erase()
	{
		System.out.println("删除圆形");
	}
}

//具体产品
class Rectangle implements Shape
{
	public void draw()
	{
		System.out.println("绘制矩形");
	}
	public void erase()
	{
		System.out.println("删除矩形");
	}
}

//具体产品
class Triangle implements Shape
{
	public void draw()
	{
		System.out.println("绘制三角形");
	}
	public void erase()
	{
		System.out.println("删除三角形");
	}
}

//工厂
class ShapeFactory
{
	//静态工厂方法
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
			throw new UnsupportedShapeException("不支持该形状！");
		}
	} 
}

//自定义异常类
class UnsupportedShapeException extends Exception
{
	public UnsupportedShapeException(String message)
	{
		super(message);
	}
}

//客户端测试类
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
