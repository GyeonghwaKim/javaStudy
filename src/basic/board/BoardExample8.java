package basic.board;

import java.sql.*;
import java.util.Scanner;


public class BoardExample8 {
    //Field
    private Scanner scanner = new Scanner(System.in);
    private Connection conn;

    public BoardExample8() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thisisjava",
                    "java",
                    "1234"
            );
        } catch (Exception e) {
            e.printStackTrace();
            exit();
        }
    }

    //Constructor
    //Method
    public void list() {
        System.out.println();
        System.out.println("[게시물 목록]");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
        System.out.println("-------------------------------------------------------");

        try {
            String query = "SELECT * FROM boards ORDER BY bno DESC";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
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
        } catch (SQLException e) {
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

        switch (selectedMenu) {
            case "1" -> create();
            case "2" -> read();
            case "3" -> clear();
            case "4" -> exit();
        }
    }

    public static void main(String[] args) {
        BoardExample8 boardExample = new BoardExample8();
        boardExample.list();
    }

    public void create() {
        Board board = new Board();
        System.out.println("[새 게시물 입력]");
        System.out.print("제목: ");
        board.setBtitle(scanner.nextLine());
        System.out.println("내용: ");
        board.setBcontent(scanner.nextLine());
        System.out.print("작성자: ");
        board.setBwriter(scanner.nextLine());

        System.out.println("-------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        if (menuNo.equals("1")) {
            try {
                String sql = "INSERT INTO boards (btitle,bcontent,bwriter,bdate) VALUES(?,?,?,now())";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, board.getBtitle());
                pstmt.setString(2, board.getBcontent());
                pstmt.setString(3, board.getBwriter());
                pstmt.executeUpdate();
                pstmt.close();


            } catch (SQLException e) {
                e.printStackTrace();
                exit();
            }
        }
        list();
    }

    public void read() {
        System.out.println("[게시물 읽기]");
        System.out.print("bno: ");
        int bno = Integer.parseInt(scanner.nextLine());

        try {
            String sql = "SELECT * FROM boards WHERE bno=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bno);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBdate(rs.getDate("bdate"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("bwriter"));

                System.out.println("#############");
                System.out.println("번호: " + board.getBno());
                System.out.println("제목: " + board.getBtitle());
                System.out.println("내용: " + board.getBcontent());
                System.out.println("작성자: " + board.getBwriter());
                System.out.println("날짜: " + board.getBdate());
                System.out.println("#############");

                //보조 메뉴 출력
                System.out.println("----------------------");
                System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
                System.out.print("메뉴 선택: ");
                String menuNo = scanner.nextLine();
                System.out.println();

                if (menuNo.equals("1")) {
                    update(board);

                } else if (menuNo.equals("2")) {
                    delete(board);
                }

            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
            exit();
        }
        list();

    }

    public void delete(Board board) {
        try {
            String sql = "DELETE FROM boards WHERE bno=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, board.getBno());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            exit();
        }
        list();
    }

    public void update(Board board) {
//수정 내용 입력받기
        System.out.println("[수정 내용 입력]");
        System.out.print("제목: ");
        board.setBtitle(scanner.nextLine());
        System.out.print("내용: ");
        board.setBcontent(scanner.nextLine());
        System.out.print("작성자: ");
        board.setBwriter(scanner.nextLine());

        //보조 메뉴 출력
        System.out.println("------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        if (menuNo.equals("1")) {
            //업데이트화면
            try {
                String sql = "UPDATE boards SET btitle=?,bcontent=?,bwriter=? where bno=?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, board.getBtitle());
                pstmt.setString(2, board.getBcontent());
                pstmt.setString(3, board.getBwriter());
                pstmt.setInt(4, board.getBno());
                pstmt.executeUpdate();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                exit();
            }
        }
        list();

    }

    public void clear() {

        System.out.println("[게시물 전체 삭제]");
        System.out.println("-------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        String menuNo = scanner.nextLine();
        if (menuNo.equals("1")) {
            try {
                String sql = "TRUNCATE TABLE boards";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();
                pstmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
                exit();
            }
        }


        list();

    }

    public void exit() {
        System.out.println("exit");
        list();

    }


}
