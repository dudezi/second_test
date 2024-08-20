import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("== 게시판 앱 ==");

        Scanner sc = new Scanner(System.in);

        int lastId = 1;

        while (true) {
            System.out.printf("명령) ");
            String command = sc.nextLine().trim();

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                System.out.print("제목 : ");
                String subject = sc.nextLine().trim();
                System.out.print("내용 : ");
                String content = sc.nextLine().trim();
                System.out.printf("%d번게시물이 등록되었습니다.\n", lastId);
                lastId++;
            }
        }
    }
}
