
package JAVA_THREAD.B2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThread {
    public static class OddNumbers implements Callable<List<Integer>> {

        @Override
        public List<Integer> call() {
            int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
            List<Integer> oddNumbers = new java.util.ArrayList<>();
            for (int i = 0; i < numbers.length; i += 2) {
                oddNumbers.add(numbers[i]);
            }
            return oddNumbers;
        }
    }

    public static class EvenNumbers implements Callable<List<Integer>> {

        @Override
        public List<Integer> call() {
            int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
            List<Integer> evenNumbers = new java.util.ArrayList<>();
            for (int i = 1; i < numbers.length; i += 2) {
                evenNumbers.add(numbers[i]);
            }
            return evenNumbers;
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Khởi tạo Callable cho các số lẻ và chẵn
        Callable<List<Integer>> oddTask = new OddNumbers();
        Callable<List<Integer>> evenTask = new EvenNumbers();

        // Gửi các task vào ExecutorService
        Future<List<Integer>> oddFuture = executor.submit(oddTask);
        Future<List<Integer>> evenFuture = executor.submit(evenTask);

        try {
            // Lấy kết quả trả về từ các thread
            List<Integer> oddNumbers = oddFuture.get();
            List<Integer> evenNumbers = evenFuture.get();

            // Hiển thị kết quả
            System.out.println("Số lẻ: " + oddNumbers);
            System.out.println("Số chẵn: " + evenNumbers);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Đóng ExecutorService
        executor.shutdown();
    }
}
