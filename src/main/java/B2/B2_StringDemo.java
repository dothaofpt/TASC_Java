public class B2_StringDemo {
    public static void main(String[] args) {
//   1:     create String
        String s1 = "Person";
        String s2 =  new String("Person");
        String s3 = "Talk";

//        So sánh bằng equals()
        System.out.println("s1 equals s2: " + s1.equals(s2)); // true
        System.out.println("s1 equals s3: " + s1.equals(s3)); //false
//         So sánh bằng compareTo()
        System.out.println("s1 compareTo s2: " + s1.compareTo(s2)); //0
        System.out.println("s1 compareTo s3: " + s1.compareTo(s3)); // negative value
//        so sánh bằng ==
        System.out.println("s1 == s2: " +(s1 == s2)); // false
        System.out.println("s1 == \"Person\": " +(s1 == "Person")); //true
    }
}
