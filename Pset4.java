import java.util.*;

class Student {
    private String name;
    private int raffleNumber;

    public Student(String name, int raffleNumber) {
        this.name = name;
        this.raffleNumber = raffleNumber;
    }

    public String getName() {
        return name;
    }

    public int getRaffleNumber() {
        return raffleNumber;
    }
}

class Raffle {
    private Student[] students;
    private boolean[] hasWon;

    public Raffle(Student[] students) {
        this.students = students;
        this.hasWon = new boolean[students.length]; 
    }

    public void chooseWinner() {
        if (allWinners()) {
            System.out.println("All students have already won.");
            return;
        }

        Random random = new Random();
        int winnerIndex;
        do {
            winnerIndex = random.nextInt(students.length);
        } while (hasWon[winnerIndex]); // Ensure student hasn't already won

        hasWon[winnerIndex] = true;
        Student winner = students[winnerIndex];
        System.out.println("Winner: " + winner.getName() + ", Raffle Number: " + winner.getRaffleNumber());
    }

    private boolean allWinners() {
        for (boolean won : hasWon) {
            if (!won) return false;
        }
        return true;
    }
}


class Fibonacci {
    private int[] sequence;
    private int filledNumbers;

    public Fibonacci() {
        this.sequence = new int[20];
        this.sequence[0] = 0;
        this.sequence[1] = 1;
        this.filledNumbers = 2;
    }

    public void updateSequence(int n) {
        if (n <= 2) {
            return;
        }
        for (int i = filledNumbers; i < n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        filledNumbers = n;
    }

    public void printSequence() {
        for (int i = 0; i < filledNumbers; i++) {
            System.out.print(sequence[i] + " ");
        }
        System.out.println();
    }
}

public class Pset4 {
    public static void main(String[] args) {
        Student[] students = new Student[10];
        students[0] = new Student("Ryan", 1234);
        students[1] = new Student("Bob", 5678);
        students[2] = new Student("Brian", 9000);
        students[3] = new Student("David", 1122);
        students[4] = new Student("Xavier", 3344);
        students[5] = new Student("Abby", 5566);
        students[6] = new Student("Jerry", 7788);
        students[7] = new Student("Noah", 9900);
        students[8] = new Student("Angel", 2233);
        students[9] = new Student("Jack", 4455);

        Raffle raffle = new Raffle(students);
        raffle.chooseWinner();
        raffle.chooseWinner();
        raffle.chooseWinner();

        Fibonacci fibonacci = new Fibonacci();
        fibonacci.updateSequence(5);
        fibonacci.printSequence();

        fibonacci.updateSequence(10);
        fibonacci.printSequence();
    }
}
