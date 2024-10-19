package JAVA_THREAD;

public class ThreadTwo extends Thread {
    String name;
    public ThreadTwo (String name){
        this.name = name;
    }
     @Override
    public void run(){
        for (int i = 0; i<10; i++){
            System.out.println(name +">>" + i);

        }
     }

}
