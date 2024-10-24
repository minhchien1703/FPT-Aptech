package threads;

class Thread1 extends Thread {
    public void run() {
        for (int i = 0; i < 5000; i++) {
            System.out.print(" " + i);
        }
    }
}

class Thread2 extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print("||");
        }
    }
}

class Parent {}

class MyThread extends Parent implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("no : " + i);
        }
    }

    public void start() throws Exception {
        Thread th = new Thread(this);
        th.start();
    }
}

public class ThreadMain {
    public static void main(String[] args) {

        Thread1 th1 = new Thread1();
        Thread2 th2 = new Thread2();
        th1.run();
        th2.run();

        try {
            MyThread myThread = new MyThread();
            myThread.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
