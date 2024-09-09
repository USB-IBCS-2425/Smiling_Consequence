class Pset2{
	public static void main(String[] args) {
		String name = "Ryan";
		String date = "9/8";
		System.out.println(name);
		System.out.println(date);
		System.out.println("");
		System.out.println("");

		int nstudents = 12;
		System.out.println(nstudents + " students are in our class");
		System.out.println("New student enrolled");
		nstudents += 1;
		System.out.println(nstudents + " students are in our class");

		if (nstudents >4){
			System.out.println("class will continue");
		} 
		else {
			System.out.println("class is canceled");
		}

		int charfirst = 4;
		nstudents -= charfirst;
		if (nstudents >4){
			System.out.println("class will continue");
		} 
		else {
			System.out.println("class is canceled");
		}

		boolean threegroups = (nstudents % 3 == 0);
		if (threegroups) {
			System.out.println(threegroups + " groups of " + (nstudents/3) +" are created");
		} 
		else {
			System.out.println((3 - (nstudents % 3)) + "students are required to be divided");
		}


	}
}