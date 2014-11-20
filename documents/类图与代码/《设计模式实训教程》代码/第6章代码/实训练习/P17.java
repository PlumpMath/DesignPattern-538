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
		car.setEngine("V型10缸/燃油直喷式汽油机");
	}
	public void buildGearbox()
	{
		car.setGearbox("6速手自一体式变速器");
	}
	public void buildWheels()
	{
		car.setWheels("19英寸的5轮辐铸铝轮毂和265/35 R19轮胎");
	}
	public void buildStereo()
	{
		car.setStereo("5环绕声道BOSE音响系统");
	}
	public void paintBody()
	{
		car.setColor("幻影黑");
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
		System.out.println("发动机：" + car.getEngine());
		System.out.println("变速箱：" + car.getGearbox());
		System.out.println("轮胎：" + car.getWheels());
		System.out.println("音响系统：" + car.getStereo());
		System.out.println("颜色：" + car.getColor());
	}
}