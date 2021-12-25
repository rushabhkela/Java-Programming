import java.util.*;

abstract class Hospitals {
    String name;
    String type;
    int code;
    String email;
    String patient_name;
    abstract int amount();
    abstract void display();

    Hospitals(String name, String type, int code, String email, String patient_name)
    {
        this.name = name;
        this.type = type;
        this.code = code;
        this.email = email;
        this.patient_name = patient_name;
    }
}

class PrivateHospital extends Hospitals {
    public PrivateHospital(String name, String type, int code, String email, String patient_name) {
        super(name,type,code,email,patient_name);
    }
    public int amount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Treatment Details:");
        System.out.print("Enter number of hours for treatment : ");
        int hr = sc.nextInt();
        System.out.print("Enter the treatment cost : ");
        int n  = sc.nextInt();
        
        int total_cost = 500*hr + n;
        return total_cost;
    }
    public void display() {
        System.out.println("\nPRIVATE HOSPITAL BILL");
        System.out.println("Hospital Name: " + this.name);
        System.out.println("Hospital Code: " + this.code);
        System.out.println("Email: " + this.email);
        System.out.println("Patient Name:  " + this.patient_name);
        System.out.println("Amount to be paid by the patient: Rs. " + this.amount());
    }
}

class GovernmentHospital extends Hospitals {
    public GovernmentHospital(String name, String type, int code, String email, String patient_name) {
        super(name,type,code,email,patient_name);
    }
    public int amount() {
        int treatment = 2000;
        int room = 5000;
        int total_cost = treatment + room;
        return total_cost;
    }
    public void display() {
        System.out.println("\nGOVERNMENT HOSPITAL BILL");
        System.out.println("Hospital Name: " + this.name);
        System.out.println("Hospital Code: " + this.code);
        System.out.println("Email: " + this.email);
        System.out.println("Patient Name:  " + this.patient_name);
        System.out.println("Amount to be paid by the patient: Rs. " + this.amount());
    }
}


public class HospitalBills {
    public static void main(String[] args) {
        System.out.println("HOSPITAL BILLS");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter hospital name: ");
        String name = sc.next() + sc.nextLine();
        System.out.print("Enter hospital code: ");
        int code = sc.nextInt();
        System.out.print("Enter hospital type (Private/Government): ");
        String type = sc.next();
        System.out.print("Enter hospital email: ");
        String email = sc.next();
        sc.nextLine();
        System.out.print("Enter patient name: ");
        String patient_name = sc.nextLine();
        
        if(type.equals("Private"))
        {
            Hospitals obj = new PrivateHospital(name, type, code, email, patient_name);
            obj.display();
        }
        else 
        {
            Hospitals obj = new GovernmentHospital(name, type, code, email, patient_name);
            obj.display();
        }
    }
}

