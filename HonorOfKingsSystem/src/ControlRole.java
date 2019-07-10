import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
public class ControlRole extends JDialog implements ActionListener {

    JButton ADDROLE;
    JButton CONCLE;
    JTextField nameInput;
    JTextField stageNameInput;
    JTextField gameLocationInput;
    JTextField gameAdvantageInput;
    JTextField rolePropertyInput;
    JTextField rolePriceInput;
    JTextField roleSkillInput;

 ControlRole(Test test, String 修改学术, boolean b, RoleModel sm, int rowNum){

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

     this.setSize(300, 200);
     this.setVisible(true);
 }
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() ==ADDROLE ){
            Connection ct = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try{
                //1.加载驱动
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("加载成功");
                //2.连接数据库
                //定义固定格式的参数
                String url = "jdbc:mysql://localhost:3306/hero";
                String user = "root";
                String passwd = "012357";
                ct = DriverManager.getConnection(url,user,passwd);

                //与编译语句对象

                String strsql = "insert into stu values(?,?,?,?,?,?)";
                pstmt = ct.prepareStatement(strsql);

                //给对象赋值
                pstmt.setString(1,nameInput.getText());
                pstmt.setString(2,stageNameInput.getText());
                pstmt.setString(3,gameAdvantageInput.getText());
                pstmt.setString(4,gameLocationInput.getText());
                pstmt.setString(5,rolePriceInput.getText());
                pstmt.setString(6,rolePropertyInput.getText());
                pstmt.setString(7,roleSkillInput.getText());
                pstmt.executeUpdate();

                this.dispose();//关闭学生对话框

            }catch(Exception arg1){
                arg1.printStackTrace();
            }finally{
                try{
                    if(rs!=null){
                        rs.close();
                        rs = null;
                    }
                    if(pstmt != null){
                        pstmt.close();
                        pstmt = null;
                    }
                    if(ct != null){
                        ct.close();
                        ct = null;
                    }
                }catch(Exception arg2){
                    arg2.printStackTrace();
                }
            }

        }

    }

}
