import java.util.*;
import java.io.*;
import java.lang.*;

public class DistrictVaccine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,i,j,k,p;

        System.out.println("Maharashtra COVID-19 Vaccination Drive");
        System.out.print("Enter the number of districts: ");
        n = sc.nextInt();

        String[] district = new String[n];
        int[][] centres = new int[n][];
        boolean[] free = new boolean[n];
        int[] left = new int[n];
        System.out.println("\nEnter the details of each district: ");
        for(i=0;i<n;i++)
        {
            free[i] = false;
            System.out.println("\nDistrict " + (i+1));
            System.out.print("Enter Name: ");
            district[i] = sc.next();
            System.out.print("Enter number of vaccination centres: ");
            k = sc.nextInt();
            System.out.print("Enter number of people registered: ");
            p = sc.nextInt();

            centres[i] = new int[k];
            for(j=0;j<k;j++)
            {
                if(p > 40) {
                    centres[i][j] = 40;
                    p -= 40;
                }
                else if (p > 0) {
                    centres[i][j] = p;
                    p -= p;
                }
                else {
                    centres[i][j] = 0;
                    free[i] = true;
                }
            }
            left[i] = p;
        }

        // Traversing the jagged array using foreach loop
        System.out.println();
        k = 0;
        for (int[] cv : centres) {
            System.out.print(district[k++] + ": ");
            for (int num : cv) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // Printing the districts where all people were not able to vaccinate
        k=0;
        for (int[] cv : centres) {
            if(left[k] != 0) {
                System.out.println("Only " + 40*cv.length + " people were able to vaccinate in " + district[k] + " and " + left[k] + " people were left.");
            }
            k++;
        }

        // Districts with free centres
        k=0;
        for (int[] cv : centres) {
            int cnt = 0;
            if(free[k]) {
                for (int num : cv) {
                    if(num != 0) {
                        cnt++;
                    }
                }
                System.out.println(district[k] + " had " + cnt + " centres free on that day.");
            }
            k++;
        }
    }
}