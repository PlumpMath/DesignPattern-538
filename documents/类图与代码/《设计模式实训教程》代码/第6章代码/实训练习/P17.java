class AudiCar
{
	private String engine;
	private String gearbox;
	private String wheels;
	private String stereo;
	private String color;
	public void setEngine(String engine) {
		this.engine = engine; 
	}
	public void setGearbox(String gearbox) {
		this.gearbox = gearbox; 
	}
	public void setWheels(String wheels) {
		this.wheels = wheels; 
	}
	public void setStereo(String stereo) {
		this.stereo = stereo; 
	}
	public void setColor(String color) {
		this.color = color; 
	}
	public String getEngine() {
		return (this.engine); 
	}
	public String getGearbox() {
		return (this.gearbox); 
	}
	public String getWheels() {
		return (this.wheels); 
	}
	public String getStereo() {
		return (this.stereo); 
	}
	public String getColor() {
		return (this.color); 
	}
}

class CarDirector
{
	private AudiCarBuilder carBuilder;
	public void setCarBuilder(AudiCarBuilder carBuilder)
	{
		this.carBuilder = carBuilder;
	}
	public void construct()
	{
		carBuilder.buildEngine();
		carBuilder.buildGearbox();
		carBuilder.buildWheels();
		carBuilder.buildStereo();
		carBuilder.paintBody();
	}
	public AudiCar getCar()
	{
		return carBuilder.getCar();
	}
}

abstract class AudiCarBuilder
{
	protected AudiCar car;
	public AudiCarBuilder()
	{
		car = new AudiCar();
	}
	public abstract void buildEngine();
	public abstract void buildGearbox();
	public abstract void buildWheels();
	public abstract void buildStereo();
	public abstract void paintBody();
	public AudiCar getCar()
	{
		return this.car;
	}
}

class AudiS6Builder extends AudiCarBuilder
{
	public void buildEngine()
	{
		car.setEngine("V��10��/ȼ��ֱ��ʽ���ͻ�");
	}
	public void buildGearbox()
	{
		car.setGearbox("6������һ��ʽ������");
	}
	public void buildWheels()
	{
		car.setWheels("19Ӣ���5�ַ�������챺�265/35 R19��̥");
	}
	public void buildStereo()
	{
		car.setStereo("5��������BOSE����ϵͳ");
	}
	public void paintBody()
	{
		car.setColor("��Ӱ��");
	}
}

class Client
{
	public static void main(String args[])
	{
		CarDirector director = new CarDirector();
		AudiCarBuilder builder;
		builder = new AudiS6Builder();
		director.setCarBuilder(builder);
		director.construct();
		AudiCar car;
		car = director.getCar();
		System.out.println("��������" + car.getEngine());
		System.out.println("�����䣺" + car.getGearbox());
		System.out.println("��̥��" + car.getWheels());
		System.out.println("����ϵͳ��" + car.getStereo());
		System.out.println("��ɫ��" + car.getColor());
	}
}