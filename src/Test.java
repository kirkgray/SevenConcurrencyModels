/**
 * Created by kirkg on 11/5/14.
 */
public class Test {

    public static void main( String[] args ) throws InterruptedException {

        System.out.println( String.format("%03d", 4) );

        thread1();

        counting();

        puzzle();
    }


    static boolean answerReady = false;
    static int answer = 0;
    static Thread t1 = new Thread() {
        public void run() {
            answer = 42;
            answerReady = true;
        }
    };
    static Thread t2 = new Thread() {
    /*    public void run() {
            if (answerReady)
                System.out.println("The meaning of life is: " + answer);
            else
                System.out.println("I don't know the answer");
        } */

        public void run() {
            while( !answerReady ) {
                try {
                    Thread.sleep(100);
                }
                catch( InterruptedException ex ) {}
            }
            System.out.println( "The meaning of life is " + answer );
        }
    };



    public static void puzzle() throws InterruptedException {

        t1.start(); t2.start();
        t1.join(); t2.join();

    }

    public static void counting() throws InterruptedException {

        class Counter {
            private int count = 0;
            public synchronized void increment() { ++count; }
            public int getCount() { return count; }
        }

        final Counter counter = new Counter();

        class CountingThread extends Thread {
            public void run() {
                for(int x = 0; x < 10000; ++x)
                    counter.increment();
            }
        }

        CountingThread t1 = new CountingThread();
        CountingThread t2 = new CountingThread();
        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println(counter.getCount());
    }

    public static void thread1() throws InterruptedException {
        Thread myThread = new Thread()
        {
            public void run() {
                System.out.println("ThreadAwesome");
            }
        };

        myThread.start();
        //Thread.yield();
        Thread.sleep(1);
        System.out.println("MainAwesome");
        myThread.join();
    }
}
