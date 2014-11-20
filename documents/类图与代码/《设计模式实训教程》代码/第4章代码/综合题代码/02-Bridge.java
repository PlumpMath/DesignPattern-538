abstract class Manufacturer
{
	protected Appliance appliance;
	public abstract void produce();
	public void setAppliance(Appliance appliance)
	{
		this.appliance = appliance;
	}
}

class Haier extends Manufacturer
{
	public void produce()
	{
		System.out.println("��������������");
		appliance.assemble();
	}
}