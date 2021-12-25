import java.util.*;
  
public class Hospital {
    public static void main(String[] args) throws InterruptedException
    {
        final Admit obj = new Admit();
        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                try {
                    obj.admitPatient();
                }
                catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run()
            {
                try {
                    obj.dischargePatient();
                }
                catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });
  
        t1.start();
        t2.start();
  
        try {
            t1.join();
            t2.join();
        }
        catch(InterruptedException e) {
            System.out.println(e);
        }
       
    }
  
    public static class Admit {
        Queue<Integer> queue = new PriorityQueue<>();
        int capacity = 20;
  
        public void admitPatient() throws InterruptedException
        {
            int value = 1;
            while (true) {
                synchronized (this)
                {
                    while (queue.size() >= capacity)
                        wait();
  
                    System.out.println("Patient " + value + " admitted.");
  
                    queue.add(value++);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
  
        public void dischargePatient() throws InterruptedException
        {
            while (true) {
                synchronized (this)
                {
                    while (queue.isEmpty())
                        wait();

                    int val = queue.poll();
  
                    System.out.println("Patient " + val + " discharged.");
                    notify();
  
                    Thread.sleep(1000);
                }
            }
        }
    }
}