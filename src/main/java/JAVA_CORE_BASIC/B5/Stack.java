package B5;

public class Stack {
   public static  int calculateFactorial(int n){

       int result=1;


      for( int i=1; i<=n;i++){
          result *=i;
       }
      return result;
   }

    public static void main(String[] args) {
       int n =5;
       int factorial = calculateFactorial(n);
        System.out.println(factorial);
    }
}
