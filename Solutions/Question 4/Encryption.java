import java.util.*;
import java.io.*;
import java.lang.*;

interface security {
    int length = 8;
    void encrypt(String s);
    void decrypt(String s);
}

interface stringfun extends security {
    void read();
    void display(boolean encryptOperation, String s);
}

class PwdCheck implements stringfun {
    String password;
    Scanner sc = new Scanner(System.in);
    public void encrypt(String s) {
        StringBuffer sb = new StringBuffer(s);
        int i = 0;
        for(i=0;i<s.length();i++) {
            int temp = s.charAt(i);
            temp++;
            char encryptChar = (char)temp;
            sb.setCharAt(i, encryptChar);
        }
        this.password = sb.toString();
    }

    public void decrypt(String s) {
        StringBuffer sb = new StringBuffer(s);
        int i = 0;
        for(i=0;i<s.length();i++) {
            int temp = s.charAt(i);
            temp--;
            char decryptChar = (char)temp;
            sb.setCharAt(i, decryptChar);
        }
        this.password = sb.toString();
    }

    public void read() {
        System.out.print("Enter Password: ");
        password = sc.next();
        System.out.println("Password Saved.");
    }

    public void display(boolean b, String s) {
        if(b) {
            System.out.println("Encrypted Password: " + s);
        }
        else {
            System.out.println("Decrypted Password: " + s);
        }
    }
}

public class Encryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Data Security ---");
        int ch;
        do {
            System.out.println("\nEnter the operation you want to perform: ");
            System.out.println("1. Encrypt Password");
            System.out.println("2. Decrypt Password");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            switch(ch) 
            {
                case 1:
                    PwdCheck enc = new PwdCheck();
                    enc.read();
                    enc.encrypt(enc.password);
                    enc.display(true, enc.password);
                    break;
                
                case 2:
                    PwdCheck dec = new PwdCheck();
                    dec.read();
                    dec.decrypt(dec.password);
                    dec.display(false, dec.password);
                    break;
                
                case 3:
                    System.out.println("Thank You.");
            }
        }while(ch!=3);
    }
}
