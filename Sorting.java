import java.util.*;

public class Sorting {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    public static int[] generateRandomArray(int length) {
        int[] randomArray = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            randomArray[i] = random.nextInt(2000); 
        }

        return randomArray;
    }

    public static void main(String[] args) {
    	int num = 2000;
        int[] arr = generateRandomArray(num);
        
        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));
        long startTime = System.nanoTime(); 
        bubbleSort(arr);
        long endTime = System.nanoTime(); 

        long executionTime = endTime - startTime;


        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Exec time:");
        System.out.println(executionTime);
    }
}
