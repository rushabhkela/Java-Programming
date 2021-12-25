import java.util.*;
import java.io.*;
import java.lang.*;

public class LongestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
		int n = sc.nextInt();
        System.out.print("Enter m: ");
		int m = sc.nextInt();
		String arr1[] = new String[n + 10];
		String arr2[] = new String[n + 10];
		String longestPalString = "";

        System.out.println("Enter the strings: ");
		for (int i = 1; i <= n; i++)
		{
			String a = sc.next();
			String b = new StringBuffer(a).reverse().toString();
			arr1[i] = a;
			arr2[i] = b;
			if (arr1[i].equals(arr2[i]))
            {
				longestPalString = arr1[i];
            }
		}
		for (int i = 1; i <= n; i++)
		{
			for (int j = i + 1; j <= n; j++)
			{
				if (arr2[i].equals(arr1[j]))
					longestPalString = arr1[i] + longestPalString + arr2[i];
			}
		}
        System.out.println("Longest palindrome length is : " + longestPalString.length());
        System.out.println("Longest Palindrome: " + longestPalString);
    }
}