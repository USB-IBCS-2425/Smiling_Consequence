import java.util.*;

public class LoopArrayPractice2{
	public static int roleDice(int x){
		int[] dice = new int[x];
		for (int i = 1; i <= x; i++){
			dice[i-1] = i;
		}
		int ind = (int)(Math.random() * x);
		int res = dice[ind];
		return res;
	}

	public static int luckyDice(int x){
		int p1 = roleDice(x);
		int p2 = roleDice(x);
		if (p1 > p2){
			return p1;
		}
		return p2;
	}

	public static boolean evenOrOdd(int[] x){
		boolean b = true;
		int even = 0;
		int odd = 0;
		for (int i = 0; i < x.length; i++){
			int n = x[i];
			if(n % 2 == 0){
				even += 1;
			}
			else{
				odd += 1;
			}
		}
		if(odd == even){
			System.out.println("Warning: The num of odd and even numbers in this array is the same.");
		}
		if(odd > even){
			b = false;
		}
		return b;
	}

	public static String[] nickName(String[] names) {
        String[] nicknames = new String[names.length];
        
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            int length = name.length();
            

            int startIndex = (int) (Math.random() * length); 
            int endIndex = startIndex + 1 + (int) (Math.random() * (length - startIndex)); 

            nicknames[i] = name.substring(startIndex, endIndex);
        }
        
        return nicknames;
    }

    public static boolean isPalindrome(String str) {
        int len = str.length();
        
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false; 
            }
        }
        
        return true; 
    }


	public static void main(String[] args) {
		for (int i = 0; i < 5; i++){
			int a1 = roleDice(6);
			System.out.println(a1);
		}
		for (int i = 0; i < 5; i++){
			int a2 = luckyDice(6);
			System.out.println(a2);
		}
		int[] arr1 = {1, 2, 3, 5, 7};
		boolean a3 = evenOrOdd(arr1);
		System.out.println(a3);
		int[] arr2 = {1, 2, 4, 5, 7, 8};
		boolean a4 = evenOrOdd(arr2);
		System.out.println(a4);

		String[] names = {"Zack", "Emily", "John", "Sophia"};
        String[] resultNicknames = nickName(names);

        for (int i = 0; i < names.length; i++) {
            System.out.println(resultNicknames[i]);
        }

        System.out.println(isPalindrome("racecar")); 
        System.out.println(isPalindrome("apple"));    
        System.out.println(isPalindrome("madam"));    
        System.out.println(isPalindrome("noon"));       
        System.out.println(isPalindrome("hello"));     


	}
}