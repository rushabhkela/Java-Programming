import java.util.*;
import java.lang.*;
import java.io.*;

public class Queries
{
    static int day = 1;
	public static void main (String[] args)
	{
        int i;
        int n = args.length;
        ArrayList<String> queriesList = new ArrayList<String>(Arrays.asList(args));  
        queriesList.remove(n-1);

        System.out.println("CAT2 MARKS QUERIES");
        System.out.println("Queries recieved on each day: ");

        queriesList.forEach(q -> System.out.println("Day " + (day++) + " : " + q));

        System.out.println("Maximum queries that can be answered on a day is " + args[n-1]);

        long[] arr;
        long k = Integer.parseInt(args[n-1]);
        arr = new long[n];
        for (i = 0; i < n - 1; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }

        long leftover = 0;
        for (i = 0; i < n; i++) {
            if(arr[i] > k){
                leftover = arr[i]-k;
                if(i+1 < n) {
                    arr[i + 1] += leftover;
                }
            }
            else if (arr[i] < k){
                System.out.println("First day when Prof. Jaisankar was free was day " + (i+1));
                break;
            }
            if(i==n-1 && leftover >= 0){
                long aa = leftover/k;
                long ans = i+1+aa+1;
                System.out.println("First day when Prof. Jaisankar was free was day " + (ans));
            }
        }
	}
}
