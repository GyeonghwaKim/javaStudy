package basic.chap20;

import java.sql.*;

public class UserSelectExample {
    public static void main(String[] args) {

        Connection conn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thisisjava",
                    "java",
                    "1234"
            );

            String sql = "SELECT userid, username, userpassword, userage, useremail FROM users WHERE userid=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"winter");

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setUserId(rs.getString("userid"));
                user.setUserName(rs.getString("username"));
                user.setUserAge(rs.getInt("userage"));
                user.setUserEmail(rs.getString("useremail"));
                user.setUserPassword(rs.getString("userpassword"));
                System.out.println(user);

            }else{
                System.out.println("사용자 아이디가 존재하지 않음");
            }
rs.close();
            pstmt.close();

        }catch (Exception e){
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
