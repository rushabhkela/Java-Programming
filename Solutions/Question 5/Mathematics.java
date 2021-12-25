import java.util.*;
import java.io.*;
import java.lang.*;

import correctformula.*;
import rushabhformula.*;

public class Mathematics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Pythagorean Triplets that satisfy both a^2 + b^2 = c^2 and c = a^2 - b are");
        int[][] correct = PythagoreanTriplets.correct(n);
        int[][] rushabh = RushabhTriplets.rushabh(n);

        ans:
            for (int[] ctr : rushabh) {
                for (int[] rtr : correct) {
                    if(Arrays.equals(ctr, new int[]{0,0,0})) {
                        break ans;
                    }
                    if(Arrays.equals(ctr, rtr))
                    {
                        System.out.println("(" + ctr[0] + ", " + ctr[1] + ", " + ctr[2] + ")");
                    }   
                }
            }
    }
}
