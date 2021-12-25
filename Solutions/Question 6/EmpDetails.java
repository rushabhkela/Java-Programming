import java.util.*;
import java.io.*;
import java.lang.*;

class Employee {
    String empID;
    String name;
    int yearOfBirth;
    char designation;

    Employee(String name, String empID, int yearOfBirth, char designation) {
        this.empID = empID;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.designation = designation;
    }

    void display() {
        System.out.println("\nEmployee Details: ");
        System.out.println("Name: " + this.name);
        System.out.println("Employee ID: " + this.empID);
        System.out.println("Year of Birth: " + this.yearOfBirth);
        if(Character.compare(this.designation, 'F') == 0) {
            System.out.println("Designation: Faculty");
        }
        else {
            System.out.println("Designation: Staff");
        }
    }
}

class InvalidEmployeeCode extends Exception {
    InvalidEmployeeCode(String s) {
        super(s);
    }
}

class InvalidAgeException extends Exception {
    InvalidAgeException(String s) {
        super(s);
    }
}

public class EmpDetails {
    static void validate(String empID, int yearOfBirth, char designation) throws InvalidEmployeeCode 
    {
        String year = String.valueOf(yearOfBirth).substring(2);
        String pattern = "^" + year + "-" + designation + "-[0-9]{3}$"; 
        if(!empID.matches(pattern)) {
            throw new InvalidEmployeeCode("Invalid Employee Code");
        }
    }
    static void retire(Employee e) throws InvalidAgeException {
        int current_year = Calendar.getInstance().get(Calendar.YEAR);
        if(current_year - e.yearOfBirth > 65) {
            throw new InvalidAgeException("Age above 65. Must retire now.");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the employee details: ");
        System.out.print("Enter Name: ");
        String name = sc.next() + sc.nextLine();
        System.out.print("Enter Employee ID: ");
        String empID = sc.next();
        System.out.print("Enter Year of Birth: ");
        int yearOfBirth = sc.nextInt();
        System.out.print("Enter Designation (F - Faculty, S - Staff): ");
        char designation = sc.next().charAt(0);

        boolean flag=false;
        try {
            validate(empID, yearOfBirth, designation);
        }
        catch(InvalidEmployeeCode err) {
            flag = true;
            System.out.println(err);
        }

        if(!flag) {
            System.out.println("VALID DETAILS");
            Employee obj = new Employee(name, empID, yearOfBirth, designation);
            flag = false;
            try {
                retire(obj);
            }
            catch(InvalidAgeException err) {
                flag = true;
                System.out.println(err);
                int current_year = Calendar.getInstance().get(Calendar.YEAR);
                int age = current_year - obj.yearOfBirth;
                String[] id = obj.empID.split("-");
                int num = Integer.parseInt(id[2]);
                int bonus = num*age;
                System.out.println("Bonus Awarded is " + bonus);
            }
            if(!flag) {
                obj.display();
            }
            else {
                System.out.println("Retired.");
            }
        }
        else {
            System.out.println("INVALID DETAILS");
        }
    }
}
