package basic.chap20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDeleteExample {
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
            String sql = "DELETE FROM boards WHERE bwriter=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"winter");

            int rows=pstmt.executeUpdate();
            System.out.println("삭제된 행 수: "+rows);

            pstmt.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn !=null){
                try{
                    conn.close();

                }catch (SQLException e){

                }
            }
        }
    }

}
