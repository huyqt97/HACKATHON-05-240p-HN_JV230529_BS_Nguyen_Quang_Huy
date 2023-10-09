import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Run {
    private static Scanner sc = new Scanner(System.in);
    private static Queue<String> quereParents = new LinkedList<>();
    public static void main(String[] args) {
        while (true){
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập tên phụ huynh nộp hồ sơ\n" +
                    "2. Phụ huynh tiếp theo\n" +
                    "3. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    inputData();
                    break;
                case 2:
                    printAndDelete();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("không hợp lệ mời nhập lại!");
            }
        }
    }
    public static void inputData(){
        System.out.print("Nhập tên phụ huynh: ");
        String parentName = sc.nextLine();
        quereParents.offer(parentName);
        System.out.println("Tên phụ huynh đã được thêm vào danh sách.");
    }
    public static void printAndDelete(){
        if (!quereParents.isEmpty()) {
            String nextParent = quereParents.poll();
            System.out.println("Phụ huynh đầu tiên trong danh sách: " + nextParent);
        } else {
            System.out.println("Danh sách rỗng.");
        }
    }
}
