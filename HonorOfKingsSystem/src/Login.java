//注册
import javazoom.jl.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.nio.file.LinkOption;
import java.sql.*;
import java.util.Scanner;

public class Login extends JFrame implements ActionListener {

    SignUp verficationCode;//验证码
    JPanel headArea;//头像
    JTextField accountNumber;//账号
    JPasswordField password;//密码
    JCheckBoxMenuItem rememberCode;//确认密码
    JCheckBoxMenuItem autoLogin;//自动登陆
    JButton signUp;//注册
    JButton refindCode; //找回密码
    JLabel upPicture;
    JLabel headPicture;
    JButton Login;//登陆

    public Login() {
        Login_DB log = new Login_DB();
        upPicture = new JLabel(new ImageIcon("LoginPicture/img.PNG"));
        headPicture = new JLabel(new ImageIcon("LoginPicture/headPicture.PNG"));
        headArea = new JPanel();
        accountNumber = new JTextField(15);
        password = new JPasswordField(15);

        signUp = new JButton("<html><a >注册账号</a></html>\"");
        signUp.setForeground(new Color(30, 160, 230));
        signUp.setFont(new Font("字体", Font.PLAIN, 16));
        signUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        signUp.addActionListener(this);
        refindCode = new JButton("<html><a >找回密码</a></html>");
        refindCode.setForeground(new Color(30, 160, 230));
        refindCode.setFont(new Font("宋体", Font.PLAIN, 16));
        refindCode.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        rememberCode = new JCheckBoxMenuItem("记住密码");
        rememberCode.setFont(new Font("宋体", Font.PLAIN, 16));
        rememberCode.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        refindCode.addActionListener(this);

        autoLogin = new JCheckBoxMenuItem("自动登陆");
        autoLogin.setFont(new Font("宋体", Font.PLAIN, 16));
        autoLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        Login = new JButton("登 陆");
        Login.setBounds(100, 125, 230, 35);
        Login.setFont(new Font("宋体", Font.PLAIN, 16));
        Login.setBackground(new Color(0, 178, 238));
        Login.setForeground(Color.BLACK);
        Login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Login.addActionListener(log);
        Login.addActionListener(this);
        signUp.addActionListener(log);
        log.setaccountT(password);
        log.setnameT(accountNumber);
        log.setButton(Login,signUp);

        headArea.add(signUp);
        headArea.add(refindCode);
        headArea.add(headPicture);
        headArea.add(rememberCode);
        headArea.add(autoLogin);
        headArea.add(accountNumber);
        headArea.add(password);
        headArea.add(Login);
        headArea.setSize(500, 190);
        headArea.setLayout(null);
        headArea.setBackground(Color.white);
        headPicture.setBounds(20, 0, 90, 90);

        accountNumber.setFont(new Font("宋体", Font.PLAIN, 16));
        accountNumber.setBounds(120, 15, 170, 37);

        password.setBounds(120, 48, 170, 37);
        password.setFont(new Font("宋体", Font.PLAIN, 16));

        signUp.setBounds(300, 54, 100, 30);
        refindCode.setBounds(300, 17, 100, 30);

        rememberCode.setBounds(50, 90, 120, 20);
        autoLogin.setBounds(200, 90, 120, 20);

        verficationCode = new SignUp();
        verficationCode.setSize(100, 50);
        //this.add(verficationCode);
        this.add(upPicture, BorderLayout.NORTH);
        this.add(headArea, BorderLayout.CENTER);
        this.setSize(450, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(600, 300);
        //this.setResizable(false);
        this.setVisible(true);
    }
        public void actionPerformed (ActionEvent e) {
            if (e.getSource() == refindCode) {//找回密码
                // String accNumber  = accountNumber.getText().toString();
                // JOptionPane.showMessageDialog(null,accNumber);
                JOptionPane.showMessageDialog(null, "该功能暂时未上线");
            }
            // if (e.getSource() == signUp) {//注册

            //      JOptionPane.showMessageDialog(null, "请联系管理员进行注册");
            //  }


            if (e.getSource() == Login) {
                if (accountNumber.getText().toString() == null) JOptionPane.showMessageDialog(null, "账号未输入");
                String accNumberString = accountNumber.getText().toString();
                String passwordString = password.getPassword().toString();
                this.dispose();
              /*  if (accNumberString.length() < 1) {
                    JOptionPane.showMessageDialog(null, "账号长度不合法");

                }
                else   {this.setVisible(false);
                    new Test();}

                }*/
            }


        }

}
