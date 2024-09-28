package chap20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class BoardUpdateExample {
    public static void main(String[] args) {

        Connection conn=null;
        try {

            //jdbc driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");
            //연결
            conn=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thisisjava",
                    "java",
                    "1234"
            );

            //syntax error 조심
            String sql = new StringBuilder()
                    .append("UPDATE boards SET ")
                    .append("btitle=?, ")
                    .append("bcontent=?, ")
                    .append("bfilename=?, ")
                    .append("bfiledata=? ")
                    .append("WHERE bno=?")
                    .toString();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"눈사람");
            pstmt.setString(2,"눈으로 만든 사람");
            pstmt.setString(3,"snowman.jpg");
            pstmt.setBlob(4,new FileInputStream("src/chap20/snowman.jpg"));
            pstmt.setInt(5,3); //boards 테이블의 게시글 번호를 직접 가지고 와야함

            int rows=pstmt.executeUpdate();
            System.out.println("저장된 행 수: "+rows);

            pstmt.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if(conn !=null){
                try{
                    conn.close();

                }catch (SQLException e){

                }
            }
        }
    }

}
