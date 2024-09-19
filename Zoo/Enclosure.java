class Enclosure {
	String humanName;
	int humanNum;
	String name;
	boolean open;

	public void addAnimal(human human) {
		this.humanNum += 1;
		this.humanName += human.getname();
	}
	public String gethumanNum() {
		return humanNum;
	}
	public boolean isopen(){
		return open;
	}
	public String gethuman(){
		return humanName;
	}
	public Enclosure(String n) {
		name = n;
		humanName = "";
		humanNum = 0;
		open = true;
	}
	public static void main(String[] args) {
		Enclosure zoo404 = new Enclosure("zoo404");

		human Jerry = new human("Jerry", 170, 200, "Male", 4);
		human Xavier = new human("Xavier", 180, 240, "Male", 5);
		human Boen = new human("Boen", 100, 100, "Male", 0);

		zoo404.addAnimal(Jerry);
		zoo404.addAnimal(Xavier);
		zoo404.addAnimal(Boen);

		System.out.println(zoo404.gethuman());
		System.out.println(zoo404.gethumanNum());
		System.out.println(zoo404.isopen());

	}

}