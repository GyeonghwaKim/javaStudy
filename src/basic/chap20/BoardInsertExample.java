package basic.chap20;

import jdk.jshell.StatementSnippet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class BoardInsertExample {
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

            String sql = "INSERT INTO boards (btitle,bcontent,bwriter,bdate,bfilename,bfiledata) VALUES(?,?,?,now(),?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,"눈사람");
            pstmt.setString(2,"눈으로 만든 사람");
            pstmt.setString(3,"winter");
            pstmt.setString(4,"snow.jpg");
            pstmt.setBlob(5,new FileInputStream("src/basic.chap20/snowman.jpg"));

            int rows=pstmt.executeUpdate();
            System.out.println("저장된 행 수: "+rows);

            if(rows==1){
                ResultSet rs = pstmt.getGeneratedKeys();
                if(rs.next()){
                    int bno=rs.getInt(1);
                    System.out.println("저장된 bno:"+bno);
                }
                rs.close();
            }

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
