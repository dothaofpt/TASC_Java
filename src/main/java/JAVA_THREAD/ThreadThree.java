package JAVA_THREAD;

public class ThreadThree implements  Runnable{
String name;
Thread t;

public ThreadThree(String name) {
    this.name = name;


}

    @Override
    public void run() {


    for (int i =0; i<10; i ++){
        System.out.println(name + ">>" + i) ;


    }
    }
}
