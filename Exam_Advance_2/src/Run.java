import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Run {
    private static Scanner sc = new Scanner(System.in);
    private static Stack<String> str = new Stack<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập câu\n" +
                    "2. Đảo ngược câu\n" +
                    "3. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    string();
                    break;
                case 2:
                    reverseStr();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không hợp lệ mời nhập lại!");
            }
        }
    }

    private static void string() {
        System.out.print("Nhập câu: ");
        String inputSentence = sc.nextLine();
        String[] words = inputSentence.split(" ");
        for (String word : words) {
            str.push(word);
        }
    }

    private static void reverseStr() {
        System.out.print("Câu đảo ngược: ");
        while (!str.isEmpty()) {
            System.out.print(str.pop() + " ");
        }
        System.out.println();
    }
}
