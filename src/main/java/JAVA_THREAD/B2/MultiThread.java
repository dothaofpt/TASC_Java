package JAVA_THREAD.B2;

public class MultiThread {
    public  static class OddNumbers implements  Runnable{


        @Override
        public void run() {
            int []number = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
            for( int i = 0 ; i<number.length; i+=2){
                System.out.println("So le:" +number[i]);
            }
        }
    }
    public static class EvenNUmbers implements  Runnable{

        @Override
        public void run() {
            int []numbers = {1,2,3,4,5,6,7,8};
            for( int i = 1 ; i<numbers.length; i+=2){
                System.out.println("So chan:" + numbers[i]);
            }
        }
    }

    public static void main(String[] args) {
        OddNumbers oddNumbers = new OddNumbers();
        EvenNUmbers evenNUmbers = new EvenNUmbers();
//        khoi tao doi tuong thread
        Thread oddThread = new Thread(oddNumbers);
        Thread evenThread = new Thread(evenNUmbers);
        oddThread.start();
        evenThread.start();

    }
}
