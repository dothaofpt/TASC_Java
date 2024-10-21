package DESIGNPATTERN;

import static java.lang.Thread.sleep;

public final class Singleton {
    // muc dich: chi muon ton tai va chi 1 instance cua class
    private static Singleton instance;
    public String value;
    private Singleton(String value){
        try{
            sleep(1000);

        }catch (InterruptedException ex ){
            ex.printStackTrace();
        }
        this.value = value;
    }


    public  static Singleton getInstance(String value){
        if(instance ==null) {
            instance = new Singleton(value);

        }
        return instance;
    }
    public void getConnection(){

    }

}
