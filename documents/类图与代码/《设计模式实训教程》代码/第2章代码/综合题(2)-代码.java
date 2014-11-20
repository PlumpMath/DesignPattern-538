class Rectangle 
{
    private double width;
    private double height;

    public Rectangle(double width,double height)
    {
        this.width=width;
        this.height=height;
    }    
    public double getHeight() 
    {
        return height;
    }
    public void setHeight(double height) 
    {
        this.height = height;
    }
    public double getWidth()
    {
        return width;
    }
    public void setWidth(double width) 
    {
        this.width = width;
    }
}

class Square extends Rectangle
{
	public Square(double size)
	{
		super(size,size);
	}
	
    public void setHeight(double height) 
    {
        super.setHeight(height);
        super.setWidth(height);
    }
    public void setWidth(double width) 
    {
        super.setHeight(width);
        super.setWidth(width);
    }
}

class Client
{
	public static void main(String args[])
	{
		Rectangle r;
		r = new Square(0.0);
		r.setWidth(5.0);
		r.setWidth(10.00);
		double area = calculateArea(r);
		if(50.00==area)
		{
			System.out.println("这是长方形或长方形的子类！");
		}
		else
		{
			System.out.println("这不是长方形！");
		}
	}
	
	public static double calculateArea(Rectangle r)
    {
    	return r.getHeight() * r.getWidth();
    }
}