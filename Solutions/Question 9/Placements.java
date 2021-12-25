import java.io.*;
import java.util.*;

public class Placements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,i,m;
        System.out.println("Placement And Training Office, VIT");
        System.out.print("Enter number of students: ");
        n = sc.nextInt();

        HashMap<String, String[]> jobOffers = new HashMap<String, String[]>();
        System.out.println("Enter the Job Offers: ");
        for(i = 0; i < n; i++)
        {
            System.out.println("Student " + (i+1) + ": ");
            System.out.print("Enter Name: ");
            String name = sc.next() + sc.nextLine();
            System.out.print("Enter the offers given: ");
            String offers = sc.nextLine();

            String[] arr = offers.split(",");
            jobOffers.put(name, arr);
        }

        System.out.print("\nEnter number of companies: ");
        m = sc.nextInt();
        HashMap<String, Long> packages = new HashMap<String, Long>();
        for(i = 0; i < m; i++)
        {
            System.out.print("\nEnter company name: ");
            String company = sc.next() + sc.nextLine();
            System.out.print("Enter package offered: ");
            long packageOffer = sc.nextLong();

            packages.put(company, packageOffer);
        }

        System.out.println("Data Saved.");

        // Add or delete student from 'jobOffers' hashmap
        System.out.println("Edit Registered Students : ");
        int ch;
        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            switch(ch) 
            {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next() + sc.nextLine();
                    System.out.print("Enter the offers given: ");
                    String offers = sc.nextLine();
                    String[] arr = offers.split(",");
                    jobOffers.put(name, arr);
                    System.out.println("Student added.");
                    break;

                case 2:
                    System.out.print("Enter name of student to remove: ");
                    String rem = sc.next() + sc.nextLine();
                    jobOffers.remove(rem);
                    System.out.println("Student Removed.");
                    break;

                case 3:
                    System.out.println("Exit\n");
            }
        }while(ch!=3);

        // Iterating over the hashmaps 
        System.out.println("FINAL LISTS : ");
        System.out.println("\nStudent\t\t\tCompanies");
        Set<Map.Entry<String, String[]> > set1 = jobOffers.entrySet();
        set1.forEach((e) -> {
            System.out.println(e.getKey() + "\t\t" + String.join(", ", e.getValue()));
        });

        System.out.println("\n\nCompanies\tPackage Offered");
        Set<Map.Entry<String, Long> > set2 = packages.entrySet();
        set2.forEach((e) -> {
            System.out.println(e.getKey() + "\t" + e.getValue());
        });

        // Displaying the offers to students along with highest offer
        ArrayList<Long> acceptedOffers = new ArrayList<Long>();
        System.out.println("\n\nJob Offers of Students");
        set1.forEach((e) -> {
            System.out.println("\nFor student " + e.getKey() + ", the offers are from ");
            String[] array = e.getValue();
            String accept = array[0];
            for(String s: array) {
                System.out.println(s + " with package of Rs. " + packages.get(s));

                if(packages.get(s) > packages.get(accept)) {
                    accept = s;
                }
            }
            System.out.println("Student will choose " + accept + " offer.");
            acceptedOffers.add(packages.get(accept));
        });

        Iterator<Long> itr = acceptedOffers.iterator();
        long sum = 0;
        while(itr.hasNext()) {
            sum += itr.next();
        }
        double avgCTC = Math.round(((double)sum/n)*100)/100.0;
        System.out.println("Average CTC of current year: Rs. " + avgCTC);
    }
}
