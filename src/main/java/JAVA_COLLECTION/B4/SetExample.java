package JAVA_COLLECTION.B4;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
//    Set la mot cau truc du lieu khong cho phep su lap lai cua phan tu
// Set thi khong cho phep cac phan tu trung lap
//    Khong nhung the trong set khong co phuong thuc get vi no khong duy tri vi tri cu the

    public static void main(String[] args) {
        Set<String> tenSet = new HashSet<>();
        tenSet.add("Tien");
        tenSet.add("Tai");
        tenSet.add("Thao");
        // loc cac phan tu cua set ( dung cong for)
for (String ten : tenSet) {
    System.out.println(ten);
}
//

//       HashSet khong duy tri vi tri cua cac phan tu
        System.out.println(tenSet);


Set<String> personSet = new LinkedHashSet<>();
       personSet.add("Linh");
       personSet.add("Thao");
       personSet.add("Nhi");
//   Nhung voi LinkedHashSet thi sap xep cac phan tu thoe thu tu
        System.out.println(personSet);

        Set<String> studentSet = new TreeSet<>();
         studentSet.add("Tien");
         studentSet.add("Minh");
         studentSet.add("Lan");
        //    neu nhu muon remove 1 gia tri nao do thi phai khai bao gia tri do
//    vi set khong co vi tri cu the cho moi gia tri
         tenSet.remove("Tien");
        System.out.println(tenSet);
//        kiem tra xem phan tu co chua trong mang hay khong
        System.out.println(tenSet.contains("Teo"));
//        kiem tra xem mang co rong khong
        System.out.println(tenSet.isEmpty());
//        kiem tra xem kich co cua 1 mang
        System.out.println(tenSet.size());




    }


}
