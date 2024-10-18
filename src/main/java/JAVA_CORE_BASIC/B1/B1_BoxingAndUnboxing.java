package B1;



public class B1_BoxingAndUnboxing {

    public static void main(String[] args) {


        int num = 10;
//        Boxing là quá trình chuyển đổi một giá trị kiểu dữ liệu nguyên thủy thành một đối tượng của lớp tương ứng.
        Integer boxedNum = Integer.valueOf(num);
        System.out.println(boxedNum);
//        Unboxing là quá trình chuyển đổi một đối tượng của lớp tương ứng thành giá trị kiểu dữ liệu nguyên thủy.
        Integer boxedNum2 = Integer.valueOf(10);
        int num2 = boxedNum2.intValue();
        System.out.println(num2);

    }
}

