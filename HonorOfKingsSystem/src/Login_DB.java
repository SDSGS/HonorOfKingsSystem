//登陆的数据库操作
import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.Statement;

        import javax.swing.*;

public class Login_DB extends Conn_DB implements ActionListener {
    JTextField accT, nameT;
    JButton okB, registB;
    Register re;
    ResultSet rs;

    public void setaccountT(JTextField a) {
        accT = a;
    }

    public void setnameT(JTextField n) {
        nameT = n;
    }

    public void setButton(JButton b1, JButton b2) {
        okB = b1;
        registB = b2;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okB) {
            if (accT.getText().equals(""))            //判断用户输入是否为空；
                JOptionPane.showMessageDialog(null, "请填写！");
            else if (nameT.getText().equals(""))
                JOptionPane.showMessageDialog(null, "请输入姓名");
            else {
                String accountT = accT.getText();
                String namesT = nameT.getText();
                String mdCode= new MD5().encryption(namesT);
                try {
                    connection();        //加载conn_db类，连接数据库；
                    boolean com = compareWithSql(accountT, mdCode);
                    if (com) {

                       new CheckCode();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "账号或姓名不正确，请重新输入");
                        accT.setText("");
                        nameT.setText("");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        } else if (e.getSource() == registB) {
            new JFrame().dispose();
            re = new Register();
        }
    }

    //用户输入检查
    boolean compareWithSql(String accountT, String namesT) throws Exception {
        String sql;
        Connection con = super.con;
        Statement stmt = con.createStatement();
        sql = "select * from my";
//		System.out.println(sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {                //用户输入的信息和数据库中的信息做比较，判断输入是否正确；
            String acc = rs.getString(1);
            String names = rs.getString(2);
            if (acc.equals(accountT) && names.equals(namesT)) {
                //break;
                return true;
            }
//			System.out.println(acc + "   " + names);
//			System.out.println(accountT + "   " + namesT);

        }
//		System.out.println("hahahaha");
        return false;

    }
}