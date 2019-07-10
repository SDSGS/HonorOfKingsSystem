import javax.print.attribute.standard.JobName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckCode extends JFrame implements ActionListener {
    CheckCode(){
        super();
    SignUp verficationCode ;
    JPanel jp = new JPanel();
    JPanel jp2 = new JPanel();

    JButton jb1 =new JButton("确定");
    jb1.addActionListener(this);
    JTextField jt = new JTextField(10);
    JLabel jl = new JLabel("验证码");
    verficationCode = new SignUp();
    verficationCode.setSize(100, 50);
    verficationCode.setLocation(400,300);
    this.add(verficationCode);
    jp2.add(jl);
    jp2.add(jt);
    jp2.add(jb1);
    this.add(jp2);
    this.setLocation(300,300);
    this.setVisible(true);
    this.setLayout(new GridLayout(0,1));
    this.setSize(400,400);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

      //  if (e.getSource() == jb1) {
        this.dispose();;
            new Test();
        //}
    }
}
