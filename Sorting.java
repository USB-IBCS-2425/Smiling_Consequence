import java.util.*;

public class Sorting {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,2,1,6,5,4,3,8,9,0};
        
        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }
}
