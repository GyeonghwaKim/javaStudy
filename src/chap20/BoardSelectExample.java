package chap20;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

public class BoardSelectExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/thisisjava", "java", "1234");

            String sql = "SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata FROM boards WHERE bwriter=?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "winter");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));
                board.setBfilename(rs.getString("bfilename"));
                board.setBfiledata(rs.getBlob("bfiledata"));

                System.out.println(board);

                Blob blob = board.getBfiledata();
                if(blob!=null){
                    InputStream is = blob.getBinaryStream();
                    FileOutputStream os = new FileOutputStream("C:\\Temp\\" + board.getBfilename());
                    is.transferTo(os);
                    os.flush();
                    os.close();
                    is.close();

                }
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
e.printStackTrace();
        } finally {
            if(conn !=null){
                try {
                    conn.close();
                }catch (Exception e){

                }
            }

        }
    }
}
