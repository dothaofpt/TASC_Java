
package JAVA_COLLECTION.B5;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapExample {
    // Map : là một cấu trúc dữ liệu cho phép chúng ta lưu trữ dữ liệu dưới dạng 'key-value' pair
    // (key-value: chìa khóa-giá trị)

    public static void main(String[] args) {
        // Sử dụng HashMap
        HashMap<String, Integer> bangGiaHashMap = new HashMap<>();
        bangGiaHashMap.put("Orange", 2000);
        bangGiaHashMap.put("Peach", 1000);
        bangGiaHashMap.put("Apple", 5000);

        // Sử dụng TreeMap
        TreeMap<String, Integer> bangGiaTreeMap = new TreeMap<>();
        bangGiaTreeMap.put("Orange", 2000);
        bangGiaTreeMap.put("Peach", 1000);
        bangGiaTreeMap.put("Apple", 5000);
        // Su dung LinkedHashMap
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Orange", 2000);
        linkedHashMap.put("Apple", 3000);
        linkedHashMap.put("Banana", 2500);

        // In giá trị từ HashMap
        System.out.println("HashMap:");
        System.out.println(bangGiaHashMap.get("Peach")); // In ra: 1000
        System.out.println(bangGiaHashMap.values()); // In ra: [2000, 1000, 5000]

        for (String fruits : bangGiaHashMap.keySet()) {
            System.out.println(fruits + "_" + bangGiaHashMap.get(fruits));
        }

        System.out.println(bangGiaHashMap.containsKey("Orange")); // In ra: true
        System.out.println(bangGiaHashMap.containsValue(10000));  // In ra: false

        System.out.println();

        // In giá trị từ TreeMap
        System.out.println("TreeMap:");
        System.out.println(bangGiaTreeMap.get("Peach")); // In ra: 1000
        System.out.println(bangGiaTreeMap.values()); // In ra: [5000, 1000, 2000]

        for (String fruits : bangGiaTreeMap.keySet()) {
            System.out.println(fruits + "_" + bangGiaTreeMap.get(fruits));
        }

        System.out.println(bangGiaTreeMap.containsKey("Orange")); // In ra: true
        System.out.println(bangGiaTreeMap.containsValue(10000));  // In ra: false
        System.out.println();

        // In giá trị từ LinkedHashMap
        System.out.println("LinkedHashMap:");
        System.out.println(linkedHashMap.get("Peach")); // In ra: 1000
        System.out.println(linkedHashMap.values()); // In ra: [5000, 1000, 2000]

        for (String fruits : linkedHashMap.keySet()) {
            System.out.println(fruits + "_" + linkedHashMap.get(fruits));
        }

        System.out.println(linkedHashMap.containsKey("Orange")); // In ra: true
        System.out.println(linkedHashMap.containsValue(10000));  // In ra: false
        System.out.println();
    }
//    ===> Điểm khác biệt lớn nhất giữa TreeMap và HashMap là TreeMap sắp xếp các phần tử theo thứ tự của key.
//    Theo mặc định, TreeMap sẽ sắp xếp các phần tử theo thứ tự tự nhiên của key (alphabet, số học)


}
