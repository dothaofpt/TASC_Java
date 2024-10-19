
package JAVA_THREAD;

public class ExampleThread {
    public static void main(String[] args) {
        // Thread main => luong chinh => khoi tao dau tien khi

        // Cach 1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // goi toi xu ly code trong phan nay => khi ma t1.start() dc goi
                for (int i = 0; i < 10; i++) {
                    System.out.println("t1 >> " + i);
                }
            }
        });

        // Bắt đầu luồng t1
        t1.start();

        // Tao theo cach 2
        Thread t2 = new ThreadTwo( "T2");
        t2.start();

//        Tao theo cach 3
        ThreadThree r = new ThreadThree("T3");
        Thread t3 =new Thread(r);
        t3.start();

//        // luong main thread
        for(int i = 0; i<10; i ++){
            System.out.println("Main thread >>"+i);
        }
    }
}
