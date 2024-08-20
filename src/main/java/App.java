import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;

    App (Scanner sc) {
        this.sc = sc;
    }

    public void run () {
        System.out.println("== 게시판 앱 ==");

        int lastId = 1;

        List<Article> articleList = new ArrayList<>();

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

                Article article = new Article(lastId, subject, content);
                articleList.add(article);

                lastId++;
            } else if (command.equals("목록")) {
                System.out.println("번호 / 제목 / 내용");
                System.out.println("----------------------");

                for(int i = articleList.size()-1; i >= 0 ; i--){
                    Article article = articleList.get(i);
                    System.out.printf("%d / %s / %s\n", article.getId(), article.getSubject(), article.getContent());
                }
            } else if (command.startsWith("삭제")) {
                String[] commandList= command.split("\\?", 2);

                String actionCode = commandList[0];
                String[] paramsStr =  commandList[1].split("=",2);

                String key = paramsStr[0];
                String value = paramsStr[1];

                int idx = Integer.parseInt(value);

                Article article = null;
                for (int i = 0; i < articleList.size(); i++){
                    if(articleList.get(i).getId() == idx) {
                        article = articleList.remove(i);
                    }
                }
                if (article == null) {
                    System.out.printf("%d번 게시물이 존재하지 않습니다.\n", idx);
                } else {
                    System.out.printf("%d번 게시물이 삭제되었습니다.\n", idx);
                }
            } else if (command.startsWith("수정")) {
                String[] commandList= command.split("\\?", 2);

                String actionCode = commandList[0];
                String[] paramsStr =  commandList[1].split("=",2);

                String key = paramsStr[0];
                String value = paramsStr[1];

                int idx = Integer.parseInt(value);

                Article article = null;
                for (int i = 0; i < articleList.size(); i++){
                    if(articleList.get(i).getId() == idx) {
                        article = articleList.get(i);
                    }
                }
            }
        }
    }
}
