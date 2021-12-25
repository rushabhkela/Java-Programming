import java.util.*;
import java.io.*;
import java.lang.*;

class Student {
    String name, regNo;
    long mobile;
    String email, proctor_name;

    Student(String name, String regNo, long mobile, String email, String proctor_name) {
        this.name = name;
        this.regNo = regNo;
        this.mobile = mobile;
        this.email = email;
        this.proctor_name = proctor_name;
    }

}

class Marks extends Student {
    double cat1;
    double cat2;
    double da1;
    double quiz1;
    double quiz2;
    double fat;
    Marks(String name, String regNo, long mobile, String email, String proctor_name, double cat1, double cat2, double quiz1, double quiz2, double da1, double fat) {
        super(name, regNo, mobile, email, proctor_name);
        this.cat1 = cat1;
        this.cat2 = cat2;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.da1 = da1;
        this.fat = fat;
    }
}

class Result extends Marks {
    double total;
    Result(String name, String regNo, long mobile, String email, String proctor_name, double cat1, double cat2, double quiz1, double quiz2, double da1, double fat) {
        super(name, regNo, mobile, email, proctor_name, cat1, cat2, quiz1, quiz2, da1, fat);
        this.total = (cat1/50)*15 + (cat2/50)*15 + quiz1 + quiz2 + da1 + (fat/100)*40;
    }
    static double calcAvg(Result[] arr) {
        double sum = 0, avg = 0;
        for(Result r: arr) {
            sum += r.total;
        }
        avg = sum / arr.length;
        return avg;
    }
    static double calcSD(Result[] arr) {
        double sum = 0, sd;
        double u = calcAvg(arr);
        for(Result r: arr) {
            sum += Math.pow((r.total - u), 2);
        }
        sd = Math.sqrt(sum / arr.length);
        return sd;
    }

    void display(String grade) {
        System.out.println("\nResult of Student " + this.name + " (" + this.regNo + "): ");
        System.out.println("Mobile Number: " + this.mobile);
        System.out.println("Email: " + this.email);
        System.out.println("Proctor Name: " + this.proctor_name);
        System.out.println("TOTAL MARKS OBTAINED: " + this.total);
        System.out.println("GRADE: " + grade);
    }
}
public class Grades {
    public static void main(String[] args) {
        System.out.println("---------------------------------");
        System.out.println("|\tVIT GRADING SYSTEM\t|");
        System.out.println("---------------------------------");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students in the class: ");
        int n = sc.nextInt();
        int i;
        String name, regNo, email, proctor_name;
        long mobile;
        double cat1, cat2, quiz1, quiz2, da1, fat;

        Result[] slot = new Result[n];
        for(i=0;i<n;i++)
        {
            System.out.println("\nEnter Student Details: ");
            System.out.print("Enter Name: ");
            name = sc.next() + sc.nextLine();
            System.out.print("Enter Register Number: ");
            regNo = sc.next();
            System.out.print("Enter Mobile: ");
            mobile = sc.nextLong();
            System.out.print("Enter EMail: ");
            email = sc.next();
            sc.nextLine();
            System.out.print("Enter Proctor Name: ");
            proctor_name = sc.nextLine();
            System.out.println("Mark Entry: ");
            System.out.print("CAT1 (out of 50): ");
            cat1 = sc.nextDouble();
            System.out.print("CAT2 (out of 50): ");
            cat2 = sc.nextDouble();
            System.out.print("Digital Assignment: ");
            da1 = sc.nextDouble();
            System.out.print("Quiz 1: ");
            quiz1 = sc.nextDouble();
            System.out.print("Quiz 2: ");
            quiz2 = sc.nextDouble();
            System.out.print("Final Assessment Test (out of 100): ");
            fat = sc.nextDouble();

            slot[i] = new Result(name, regNo, mobile, email, proctor_name, cat1, cat2, quiz1, quiz2, da1, fat);
        }

        double avg = Result.calcAvg(slot);
        avg = Math.round(avg*100)/100.0;
        double sd = Result.calcSD(slot);
        sd = Math.round(sd*100)/100.0;
        System.out.println("\nCLASS RESULT");
        System.out.println("Total number of students: " + slot.length);
        System.out.println("Class Average: " + avg);
        System.out.println("SD: " + sd);

        for(Result r: slot) {
            if(r.total >= avg + 1.5*sd) {
                r.display("S");
            }
            else if(r.total >= avg + 0.5*sd) {
                r.display("A");
            }
            else if(r.total >= avg - 0.5*sd) {
                r.display("B");
            }
            else if(r.total >= avg - 1*sd) {
                r.display("C");
            }
            else if(r.total >= avg - 1.5*sd) {
                r.display("D");
            }
            else if(r.total >= avg - 2*sd) {
                r.display("E");
            }
            else {
                r.display("F");
            }
        }
    }
}
