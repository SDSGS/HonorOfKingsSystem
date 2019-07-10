import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateInfor extends Dialog implements ActionListener {
    JPanel p  =new JPanel();
    JButton updatePrice;
    JLabel heroPrice;
    JTextField inputPrice;
    JLabel roleName;
    JTextField  name;
    UpdateInfor(Frame owner, String title, boolean modal){
        super(owner, title, modal);
        heroPrice = new JLabel("新的价格");
        updatePrice = new JButton("修改");
        inputPrice = new JTextField(10);
        name = new JTextField(10);
        roleName = new JLabel("名字");
        p.add(heroPrice);
        p.add(inputPrice);
        p.add(roleName);
        p.add(name);
        p.add(updatePrice);
        p.setLayout(new GridLayout(3, 2));
        updatePrice.addActionListener(this);
        this.add(p);
        this.setLocation(450,350);
        this.setSize(300, 200);
        this.setVisible(true);
        this.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        {
            if (e.getSource() == updatePrice) {
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                System.out.println("修改完成!");
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    System.out.println("数据库加载观测   正常");

                    String url = "jdbc:mysql://localhost:3306/hero";
                    String user = "root";
                    String PINcode = "012357";
                    conn = DriverManager.getConnection(url, user, PINcode);

                    String sql = "update hero set rolePrice =? where  roleName =?";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, inputPrice.getText());
                    pstmt.setString(2, name.getText());
                    pstmt.executeUpdate();
                    this.dispose();
                }

                catch (Exception e1) {

                    e1.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                            rs = null;
                        }
                        if (pstmt != null) {
                            pstmt.close();
                            pstmt = null;
                        }
                    /*if (conn != null) {
                        conn.close();
                        conn = null;
                    }*/
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }

            }
        }
    }}
