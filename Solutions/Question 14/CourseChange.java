import java.lang.*;
import java.util.*;

class Count
{
    int type1;
    int type2;
    int type3;
    int arr[]=new int[2000];
    static int i=0;
    static int k = 0;
    Count(int arr[])
    {
        type1=0;
        type2=0;
        type3=0;
        this.arr=arr;
    }
    void types_count()
    {
        while(i<arr.length)
        {
            synchronized(this)
            {
                if(arr[i]==1)
                    type1++;
                else if(arr[i]==2)
                    type2++;
                else
                    type3++;

                i++;
            }
            try {
                Thread.sleep(300);
            }
            catch(Exception e) {}
        }
    }

    int[] fxn() {
        int array[]=new int[3];
        array[0]=type1;
        array[1]=type2;
        array[2]=type3;
        System.out.println("\nTotal votes of type 1 - Lab Only : "+array[0]);
        System.out.println("Total types of type 2 - Embedded Theory, Lab, Project : "+array[1]);
        System.out.println("Total types of type 3 - Lab and Project : "+array[2]+"\n");
        return array;
    }
}
class MyRunnable implements Runnable
{
    Count c;
    MyRunnable(Count temp) {
        c=temp;
    }
    public void run() {
        c.types_count();
    }
}

public class CourseChange
{
    public static void main(String args[])
    {
        int array[]=new int[2000];
        System.out.println(" -- COURSE TYPE CHANGE FOR CSE1007 - JAVA PROGRAMMING --");
        System.out.println("Counting started..");
        for(int i=0;i<2000;i++)
        {
            array[i]=(int)(Math.random()*3+1);
            
        }
        Count obj=new Count(array);
        MyRunnable r = new MyRunnable(obj);
        Thread t1=new Thread(r);
        Thread t2=new Thread(r);
        Thread t3=new Thread(r);
        Thread t4=new Thread(r);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }
        catch(Exception e){}
        int arr[]=new int[3];
        // arr[0] for Type - 1 (Lab Only)
        // arr[1] for Type - 2 (Embedded Theory, Lab, Project)
        // arr[2] for Type - 3 (Lab and Project)
        
        System.out.println("\nRESULTS : ");
        arr=obj.fxn();
        if(arr[0]>=arr[1] && arr[0]>=arr[2])
        {
            if(arr[0]==arr[1])
            {
                System.out.println("Type - 1 (Lab Only) and Type - 2 (Embedded Theory, Lab, Project) are tied");
            }
            else if(arr[0]==arr[2])
            {
                System.out.println("Type - 1 (Lab Only) and Type - 3 (Lab and Project) are tied");
            }
            else
            {
                System.out.println("Type - 1 (Lab Only) is in majority");
            }
        }
        else if(arr[1]>=arr[0] && arr[1]>=arr[2])
        {
            if(arr[0]==arr[1])
            {
                System.out.println("Type - 1 (Lab Only) and Type - 2 (Embedded Theory, Lab, Project) are tied");
            }
            else if(arr[1]==arr[2])
            {
                System.out.println("Type - 2 (Embedded Theory, Lab, Project) and Type - 3 (Lab and Project) are tied");
            }
            else
            {
                System.out.println("Type - 2 (Embedded Theory, Lab, Project) is in majority");
            }
        }
        else if(arr[2]>=arr[1] && arr[2]>=arr[0])
        {
            if(arr[2]==arr[0])
            {
                System.out.println("Type - 1 (Lab Only) and Type - 3 (Lab and Project) are tied");
            }
            else if(arr[1]==arr[2])
            {
                System.out.println("Type - 2 (Embedded Theory, Lab, Project) and Type - 3 (Lab and Project) are tied");
            }
            else
            {
                System.out.println("Type - 3 (Lab and Project) is in majority");
            }
        }
    }
}
