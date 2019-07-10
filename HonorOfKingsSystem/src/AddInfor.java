//向数据库添加信息
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class AddInfor extends JDialog implements ActionListener {
    JButton ADDROLE;
    JButton CONCLE;
    JTextField nameInput;
    JTextField stageNameInput;
    JTextField gameLocationInput;
    JTextField gameAdvantageInput;
    JTextField rolePropertyInput;
    JTextField rolePriceInput;
    JTextField roleSkillInput;

    public AddInfor(Frame owner, String title, boolean modal) {

        super(owner, title, modal);

        JPanel LABELAREA = new JPanel();
        JPanel TEXTAREA = new JPanel();
        JPanel BUTTONAREA = new JPanel();

        JLabel roleName = new JLabel("英雄");
        JLabel roleStageName = new JLabel("称号");
        JLabel gameLocation = new JLabel("位置");
        JLabel roleAdvantage = new JLabel("特长");
        JLabel roleProperty = new JLabel("属性");
        JLabel rolePrice = new JLabel("价格");
        JLabel roleSkill = new JLabel("技能");

        nameInput = new JTextField(10);
        stageNameInput = new JTextField(10);
        gameLocationInput = new JTextField(10);
        gameAdvantageInput = new JTextField(10);
        rolePropertyInput = new JTextField(10);
        rolePriceInput = new JTextField(10);
        roleSkillInput = new JTextField(10);

        ADDROLE = new JButton("增加角色");
        ADDROLE.addActionListener(this);
        CONCLE = new JButton("取消");
        CONCLE.addActionListener(this);

        // design LAYOUT
        LABELAREA.setLayout(new GridLayout(6, 1));
        LABELAREA.add(roleName);
        LABELAREA.add(roleStageName);
        LABELAREA.add(gameLocation);
        LABELAREA.add(roleAdvantage);
        LABELAREA.add(roleProperty);
        LABELAREA.add(rolePrice);
        LABELAREA.add(roleSkill);

        TEXTAREA.setLayout(new GridLayout(6, 1));
        TEXTAREA.add(nameInput);
        TEXTAREA.add(stageNameInput);
        TEXTAREA.add(gameLocationInput);
        TEXTAREA.add(gameAdvantageInput);
        TEXTAREA.add(rolePropertyInput);
        TEXTAREA.add(rolePriceInput);
        TEXTAREA.add(roleSkillInput);

        BUTTONAREA.setLayout(new GridLayout(1, 2));
        BUTTONAREA.add(ADDROLE);
        BUTTONAREA.add(CONCLE);

        this.add(LABELAREA, BorderLayout.WEST);
        this.add(TEXTAREA, BorderLayout.CENTER);
        this.add(BUTTONAREA, BorderLayout.SOUTH);
        this.setLocation(450,350);
        this.setSize(300, 200);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ADDROLE) {
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            System.out.println("修改完成!!!");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("数据库加载观测   正常");

                String url = "jdbc:mysql://localhost:3306/hero";
                String user = "root";
                String PINcode = "012357";
                conn = DriverManager.getConnection(url, user, PINcode);

                String sql = "insert into hero values(?,?,?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, nameInput.getText());
                pstmt.setString(2, stageNameInput.getText());
                pstmt.setString(3, gameLocationInput.getText());
                pstmt.setString(4, gameAdvantageInput.getText());
                pstmt.setString(5, rolePropertyInput.getText());
                pstmt.setString(6, "  "+rolePriceInput.getText());
                pstmt.setString(7, roleSkillInput.getText());
                pstmt.executeUpdate();
                this.dispose();
            } catch (Exception e1) {
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
}