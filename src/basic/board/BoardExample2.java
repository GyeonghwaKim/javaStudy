package basic.board;

import java.util.Scanner;


public class BoardExample2 {
    //Field
    private Scanner scanner=new Scanner(System.in);

    //Constructor
    //Method
    public void list(){
        System.out.println();
         System.out.println("[게시물 목록]");
         System.out.println("-------------------------------------------------------");
         System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
         System.out.println("-------------------------------------------------------");
         System.out.printf("%-6s%-12s%-16s%-40s \n", "1", "winter", "2022.01.27", "게시판에 오신 것을 환영합니다.");
         System.out.printf("%-6s%-12s%-16s%-40s \n", "2", "winter", "2022.01.27", "올 겨울은 많이 춥습니다.");
        mainMenu();
    }

    public void mainMenu() {
        System.out.println();
         System.out.println("-------------------------------------------------------");
         System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
         System.out.print("메뉴 선택: ");
        String selectedMenu = scanner.nextLine();
        System.out.println();

        switch (selectedMenu){
            case "1"->create();
            case "2"->read();
            case "3"->clear();
            case "4"->exit();
        }
    }

    public static void main(String[] args) {
        BoardExample2 boardExample = new BoardExample2();
        boardExample.list();
    }

    public void create(){
        System.out.println("create");
        list();
    }
    public void read(){
        System.out.println("read");

        list();

    }
    public void clear(){
        System.out.println("clear");

        list();

    }
    public void exit(){
        System.out.println("exit");
        list();

    }


}
