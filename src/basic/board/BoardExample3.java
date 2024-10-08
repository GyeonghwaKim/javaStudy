package basic.board;

import java.sql.*;
import java.util.Scanner;


public class BoardExample3 {
    //Field
    private Scanner scanner=new Scanner(System.in);
    private Connection conn;

    public BoardExample3() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thisisjava",
                    "java",
                    "1234"
            );
        }catch (Exception e){
            e.printStackTrace();
            exit();
        }
    }

    //Constructor
    //Method
    public void list(){
        System.out.println();
         System.out.println("[게시물 목록]");
         System.out.println("-------------------------------------------------------");
         System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
         System.out.println("-------------------------------------------------------");

         try{
             String query = "SELECT * FROM boards ORDER BY bno DESC";
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs=pstmt.executeQuery();
             while (rs.next()){
                 Board board = new Board();
                 board.setBno(rs.getInt("bno"));
                 board.setBtitle(rs.getString("btitle"));
                 board.setBwriter(rs.getString("bwriter"));
                 board.setBdate(rs.getDate("bdate"));

                 System.out.printf("%-6s%-12s%-16s%-40s \n",
                          board.getBno(),
                          board.getBwriter(),
                          board.getBdate(),
                          board.getBtitle());
             }
             rs.close();
             pstmt.close();
         }catch(SQLException e){
             e.printStackTrace();
             exit();
         }

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
        BoardExample3 boardExample = new BoardExample3();
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
