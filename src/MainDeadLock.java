import static java.lang.Thread.*;

public class MainDeadLock {
    public static void main(String args[]){
        Object verrou1 = new Object();
        Object verrou2 = new Object();

        Thread ps1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Start of Thread ps1");
                synchronized (verrou1) {
                    System.out.println("Locked on verrou 1");
                    try {
                        sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (verrou2) {
                        System.out.println("Locked on verrou 2");
                    }
                }
                System.out.println("End of ps1");
            }
        };
        Thread ps2 = new Thread() {
            @Override
            public void run() {
                System.out.println("Start of Thread ps1");
                synchronized (verrou2) {
                    System.out.println("Locked on verrou 2");
                    try {
                        sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (verrou1) {
                        System.out.println("Locked on verrou 1");
                    }
                }
                System.out.println("End of ps1");
            }
        };
    ps1.start();
    ps2.start();

    }
}
