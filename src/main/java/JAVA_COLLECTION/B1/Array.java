
package JAVA_COLLECTION.B1;

// Array là một mảng có kích thước cố định không thể thay đổi
// Giúp gộp chung nhóm các đối tượng có chung tính chất lại với nhau

public class Array {
    public static void main(String[] args) {
        // Khai báo mảng
        String[] mangStr;
        Float[] mangFl;
        Double[] mangDb;
        int[] mangNguyen3 = new int[]{1, 2, 3, 4, 5, 6, 7};

        // Khởi tạo mảng kèm theo kích thước
        String[] mangStr2 = new String[12]; // chứa tối đa 12 phần tử
        int[] mangNguyen2 = new int[7];

        // Khởi tạo mảng kèm giá trị ban đầu
        String[] mangStr3 = new String[]{"chi pheo", "thi no", "ong giao"};

        // Truy xuất phần tử của mảng dựa theo index
        System.out.println(mangNguyen3[2]); // In ra: 3

        // System.out.println(mangStr3[3]); // Sẽ gây ra lỗi vì quá kích thước của mảng
        System.out.println(mangStr2[0]); // In ra: null
        System.out.println(mangStr2[1]); // In ra: null

        // Khi chưa khởi tạo giá trị của mảng khi in sẽ ra null
        mangStr = new String[]{"hello", "bye"};
        System.out.println(mangStr[0]); // In ra: hello

        // Độ dài của mảng
        System.out.println(mangNguyen3.length); // In ra: 7

        // Duyệt các phần tử của mảng
        int[] mang4 = new int[]{1, 2, 3, 4, 5, 6, 7};
        for (int pt : mang4) {
            System.out.println(pt);
        }

        String[] mang5 = new String[]{"chi pheo", "thi no", "ong giao"};
        for (String pt : mang5) {
            System.out.println(pt + "\t");
        }

        // Duyệt qua index
        for (int i = 0; i < mang4.length; i++) {
            System.out.println(mang4[i]);
        }

        // Thay đổi giá trị của mảng
        String[] mang6 = new String[]{"chi pheo", "thi no", "ong giao"};
        mang6[0] = "obama";

        // Duyệt mảng
        System.out.println("Mảng sau khi thay đổi:");
        for (int i = 0; i < mang6.length; i++) {
            System.out.println(mang6[i]);
        }

        // Cập nhật toàn bộ danh sách
        int[] mang7 = new int[]{1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < mang7.length; i++) {
            mang7[i] += 5;
        }

        // Duyệt mảng 7 sau khi thay đổi
        System.out.println("Mảng sau khi thay đổi:");
        for (int i = 0; i < mang7.length; i++) {
            System.out.println(mang7[i]);
        }
    }
}
