
package B5;

import java.util.ArrayList;
import java.util.List;

public class Heap {


//    trước hết tạo 1 class
    public class Book {
        String nameBook;
        String author;

        public Book(String nameBook, String author) {
            this.nameBook = nameBook;
            this.author = author;
        }


//        xuất ra chuỗi in ra đối tượng
        @Override
        public String toString() {
            return "Book{nameBook='" + nameBook + "', author='" + author + "'}";
        }
    }

//    tạo 1 danh sach book
    private List<Book> listBook = new ArrayList<>();

//    tạo 1 phương thức thêm book
    public void addBook(String nameBook, String author) {
        Book book = new Book(nameBook, author);
        listBook.add(book);
    }

//    hiện thị ra danh sách book
    public void displayBooks() {
        System.out.println("In ra cac danh sach book:");
        for (Book book : listBook) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.addBook("Python Programming", "Author A");
        heap.addBook("Java Programming", "Author B");
        heap.displayBooks();
    }
}
