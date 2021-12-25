import java.io.*;
import java.util.*;
import java.lang.*;

public class Generics {
    public static < E > boolean isPalindrome(E str) {
        int i;
        String s = str.toString();

        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        if(sb.toString().equals(s)) {
            return true;
        }
        return false;
    }

    public static < E > boolean isPrime(E str) {
        int i;
        int n = Integer.parseInt(str.toString());
        for(i = 2; i < n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static < E > E[] changeArray(E[] arr) {
        int n = arr.length, i;

        if(arr instanceof String[])
        {
            System.out.println("\nReversing all the non - palindrome strings in array: ");
            for(i = 0; i < n; i++)
            {
                if(!isPalindrome(arr[i])) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(arr[i].toString());
                    sb.reverse();
                    arr[i] = (E)sb.toString();
                }
                else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(arr[i].toString());
                    sb.append("*");
                    arr[i] = (E)sb.toString();
                }
            }
            return arr;
        }
        if(arr instanceof Integer[]) 
        {
            System.out.println("\nReplacing all prime numbers in the array with their squares: ");
            for(i = 0; i < n; i++)
            {
                if(isPrime(arr[i])) {
                    int m = Integer.parseInt(arr[i].toString());
                    Integer sq = new Integer((int)Math.pow(m,2));
                    arr[i] = (E)sq;
                }
            }
            return arr;
        }
        return arr;
    }
    public static void main(String[] args) {
        System.out.println("GENERIC METHODS");

        Integer[] intArray = {20, 11, 78, 23, 89};
        String[] strArray = {"rushabh", "wow", "abba", "kela"};

        System.out.println("Original Integer Array: ");
        for(int i : intArray) {
            System.out.print(i + " ");
        }
        Integer[] changedIntArray = changeArray(intArray);
        System.out.println("Changed Integer Array: ");
        for(int i : changedIntArray) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        System.out.println("Original String Array: ");
        for(String str : strArray) {
            System.out.print(str + " ");
        }
        String[] changedStrArray = changeArray(strArray);
        System.out.println("Changed String Array: ");
        for(String str : changedStrArray) {
            System.out.print(str + " ");
        }
        System.out.println("\n");
    }
}