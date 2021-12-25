import java.io.*;
import java.util.*;

class StudentDetails implements Serializable {
    String regNo;
    String name;
    double cgpa;
    String proctor_name;
    double ncgpa;

    StudentDetails(String regNo, String name, double cgpa, String proctor_name) {
        this.regNo = regNo;
        this.name = name;
        this.cgpa = cgpa;
        this.proctor_name = proctor_name;
    }

    void display() {
        System.out.print(this.name + "\t");
        System.out.print(this.regNo + "\t");
        System.out.print(" " + this.cgpa + "\t");
        System.out.print(this.ncgpa + "\t");
        System.out.print(this.proctor_name + "\t");
        System.out.println();
    }
}
public class Counselling {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n,i,j;
        System.out.println(" -- VIT HOSTEL COUNSELLING -- ");
        System.out.print("Enter the number of students: ");
        n = sc.nextInt();

        StudentDetails[] students;
        students = new StudentDetails[n];
        double topper_cgpa = 0;
        FileOutputStream fos = new FileOutputStream("hostel.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for(i = 0; i < n; i++)
        {
            System.out.println("\nEnter the student details: ");
            System.out.print("Enter Register Number: ");
            String regNo = sc.next();
            sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter proctor name: ");
            String proctor_name = sc.nextLine();

            topper_cgpa = Math.max(topper_cgpa, cgpa);

            students[i] = new StudentDetails(regNo, name, cgpa, proctor_name);
            oos.writeObject(students[i]);
        }
        System.out.println("\nStudent Data Saved.");
        System.out.println("Reading Data from file.");
        System.out.println("Calculating NCGPA of students.");

        FileInputStream fis = new FileInputStream("hostel.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        for(i = 0; i < n; i++)
        {
            StudentDetails sd = (StudentDetails)ois.readObject();
            sd.ncgpa = Math.round((sd.cgpa/topper_cgpa)*1000)/100.0;
            students[i] = sd;
        }

        for (i = 0; i < n-1; i++)
        {
            int max_idx = i;
            for (j = i+1; j < n; j++)
                if (students[j].ncgpa > students[max_idx].ncgpa)
                    max_idx = j;

            StudentDetails temp = students[max_idx];
            students[max_idx] = students[i];
            students[i] = temp;
        }
        System.out.println("Rank List of Students: ");
        System.out.println("Rank    Student Name   Register Number   CGPA   NCGPA   Proctor Name");
        for(i = 0; i < n; i++)
        {
            System.out.print((i+1) + "\t");
            students[i].display();
        }
        System.out.println("\nRank List Published.");
        System.out.println("Hostel Rooms Allotted.");
    }
}