package basic.chap20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInsertExample {
    public static void main(String[] args) {

        Connection conn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thisisjava",
                    "java",
                    "1234"
            );

            String sql = "INSERT INTO users (userid,username,userpassword,userage,useremail) VALUES(?,?,?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"winter");
            pstmt.setString(2,"한겨울");
            pstmt.setString(3,"12345");
            pstmt.setInt(4,25);
            pstmt.setString(5,"winter@mycompany.com");

            int rows=pstmt.executeUpdate();
            System.out.println("저장된 행 수: "+rows);

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
