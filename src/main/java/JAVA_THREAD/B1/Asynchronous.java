package JAVA_THREAD.B1;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Asynchronous{

    public class WeatherApp {
        private static final HttpClient client = HttpClient.newHttpClient();

        public static void getWeatherData() {
            String apiKey = "93995fc42575be3d739c325650f3dbb2";
            String city = "Hanoi";
            String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .timeout(Duration.ofSeconds(10))
                    .build();

            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(System.out::println)
                    .join();
        }

    }
    public class Clock {
        public static void displayClock() {
            while (true) {
                System.out.println(java.time.LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        // Chạy phương thức lấy dữ liệu thời tiết bất đồng bộ
        new Thread(WeatherApp::getWeatherData).start();

        // Hiển thị đồng hồ đếm giờ đồng thời
        Clock.displayClock();
    }

}

