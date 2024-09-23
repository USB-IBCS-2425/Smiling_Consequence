class Wallet {
	private int money;
	private int id;

	public Wallet(){
		this.money = money;
		this.id = id;
	}
	public int getMoney(){
		return this.money;
	}
	public int getid(){
		return this.id;
	}
	public void setMoney(int a){
		this.money = a;
	}
	public void setid(int a){
		this.id = a;
	}

	public void payday(int a){
		this.money += a;
	}

	public void pay(int a){
		this.money -= a;
	}
	public static void main(String[] args) {
		Wallet mywallet = new Wallet();
		mywallet.setMoney(1000);
		mywallet.setid(7205466);
		mywallet.payday(2000);
		mywallet.pay(500);
		System.out.println(mywallet.getMoney());
		System.out.println(mywallet.getid());
	}

}


class Shape {
	double area;

	public double getarea(){
		return area;
	}
	public Shape(){
		this.area = 0;
	}
	
	public static void main(String[] args) {
		
		Rectangle rectangle = new Rectangle(2,5);
		Circle circle = new Circle(3);
		System.out.println(rectangle.getarea());
		System.out.println(circle.getarea());
}
}

class Rectangle extends Shape{
	int length;
	int width;

	public Rectangle(int length, int width){
	this.length = length;
	this.width = width;
	}
	@Override public double getarea(){
		return length*width;
	}
}

class Circle extends Shape{
	int radius;

	public Circle(int radius){
	this.radius = radius;
	}
	@Override public double getarea(){
		return radius * radius * 3.142;
	}
	
	
}

