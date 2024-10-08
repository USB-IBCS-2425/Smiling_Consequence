import java.util.*;
class ChompBistro {
    private String[] employees;
    private String[] menuItems;
    private int dayOfWeek;

    public ChompBistro(String[] employees, String[] menuItems) {
        this.employees = employees;
        this.menuItems = menuItems;
        this.dayOfWeek = 1; 
    }


    public String getEmployees() {
        StringBuilder sb = new StringBuilder();
        for (String employee : employees) {
            sb.append(employee).append(" ");
        }
        return sb.toString().trim();
    }


    public String getMenuItems() {
        StringBuilder sb = new StringBuilder();
        for (String item : menuItems) {
            sb.append(item).append(" ");
        }
        return sb.toString().trim();
    }


    public int getDay() {
        return dayOfWeek;
    }


    public void setDay(int day) {
        if (day >= 1 && day <= 5) {
            this.dayOfWeek = day;
        } else {
            System.out.println("Invalid day. Please enter a number between 1 and 5.");
        }
    }


    public String generateMenu() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(menuItems.length);
            sb.append(menuItems[randomIndex]).append(" ");
        }
        return sb.toString().trim();
    }


    public String whoWorking() {
        if (dayOfWeek == 1) {
            return employees[0] + " and " + employees[1];
        } else if (dayOfWeek == 2) {
            return employees[1] + " and " + employees[2];
        } else if (dayOfWeek == 3) {
            return employees[2] + " and " + employees[3];
        } else if (dayOfWeek == 4) {
            return employees[3] + " and " + employees[4];
        } else { // dayOfWeek == 5
            return employees[4] + " and " + employees[0];
        }
    }


    public static void main(String[] args) {
        String[] employees = {"John", "Sarah", "Tom", "Emma", "Jake"};
        String[] menuItems = {"Burger", "Pizza", "Salad", "Pasta", "Soup", "Steak"};

        ChompBistro bistro = new ChompBistro(employees, menuItems);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Chomp Bistro! Please choose an option:");
            System.out.println("1. See the Menu of the Day");
            System.out.println("2. See who is working today");
            System.out.println("3. Change day");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Today's Menu: " + bistro.generateMenu());
                    break;
                case 2:
                    System.out.println("Today working: " + bistro.whoWorking());
                    break;
                case 3:
                    System.out.print("Enter a day (1-5): ");
                    int day = scanner.nextInt();
                    bistro.setDay(day);
                    System.out.println("Day has been changed to " + bistro.getDay());
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
