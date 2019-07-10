import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;
        import java.sql.Statement;

public class Conn_DB {
    Connection con;
    String url = null;
    //Statement stmt;

    public void connection() throws ClassNotFoundException {
        url = "jdbc:mysql://localhost:3306/hero?"
                + "user=root & password=012357 & useUnicode=true & characterEnunicode=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url);
            System.out.println("连接成功");
            //stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
