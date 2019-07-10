import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransFile{

 TransFile(){

        try {

            Class.forName("com.mysql.jdbc.Driver");

            // 数据库用户
            String user = "root";

            // 数据库密码
            String password = "012357";

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hero", user, password);

            Statement stmt = conn.createStatement();

            // 查询 , 从数据库 db_sale 的 product 表中查询
            ResultSet rs = stmt.executeQuery("SELECT *from hero");

            // 创建输出文件 result.txt
            File file = new File("d://result.txt");
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));

            while (rs.next()) {

                writer.write(String.valueOf(rs.getString(1)) + "\t");
                writer.write(rs.getString(2) + "\t");
                writer.write(String.valueOf(rs.getString(3)));
                writer.write("\r\n");

                //System.out.println(rs.getLong(1));
                //System.out.println(rs.getString(2));
                //System.out.println(rs.getLong(3));
            }

            writer.flush();
            writer.close();

            rs.close();
            stmt.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}