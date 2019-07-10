//测试运行主题 Main()位置
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;

public class Test extends JFrame implements ActionListener {
    JPanel jp1,jp2,jp3;
    JLabel jl1,jl2;
    JButton jb1,jb2,jb3,jb4,jb5;
    JTable jt;
    JScrollPane jsp;
    JTextField jtf;
    RoleModel sm;
    //定义连接数据库的变量
    Statement stat = null;
    PreparedStatement ps;
    Connection ct = null;
    ResultSet rs = null;

    JLabel insidePicture = new JLabel(new ImageIcon("C:\\Users\\admin\\Documents\\AAA\\HonorOfKingsSystem\\LoginPicture\\bei.jpg"));
    //构造函数
    public Test(){
        jp3 = new JPanel();
        jp1 = new JPanel();
        jtf = new JTextField(10);
        jb1 = new JButton("查询");
        jb1.addActionListener(this);
        jl1 = new JLabel("请输入名字：");

        jp1.add(jl1);
        jp1.add(jtf);
        jp1.add(jb1);

        jb2 = new JButton("添加角色");
        jb2.addActionListener(this);
        jb3 = new JButton("修改信息");
        jb3.addActionListener(this);
        jb4 = new JButton("删除任务");
        jb4.addActionListener(this);
        jb5 = new JButton("导出文件");
        jb5.addActionListener(this);
        jp2 = new JPanel();
        jp3.add(insidePicture);
        jp2.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);
        jp2.add(jb5);
        //创建模型对象
        sm = new RoleModel();


        //初始化
        jt = new JTable(sm);

        jsp = new JScrollPane(jt);

        //将jsp放入到jframe中
        this.add(jsp,BorderLayout.CENTER);
        this.add(jp1,"North");
        this.add(jp2,"South");
        this.add(jp3,BorderLayout.WEST);
        this.setSize(1000, 400);
        this.setLocation(300, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == jb1) {//查询
            System.out.println("用户希望被查询...");
            String name = this.jtf.getText().trim();
            String sql = "select * from hero where roleName = '" + name + "' ";
            sm = new RoleModel(sql);
            jt.setModel(sm);

        }
        else if (arg0.getSource() == jb2) {//添加
            System.out.println("添加...");
            AddInfor sa = new AddInfor(this, "添加", true);
            sm = new RoleModel();
            jt.setModel(sm);
        }
        else if (arg0.getSource() == jb4) {
            int rowNum = this.jt.getSelectedRow();
            if (rowNum == -1) {
                JOptionPane.showMessageDialog(this, "请选中一行");
                return;
            }
            String Id = (String) sm.getValueAt(rowNum, 0);
            System.out.println("Id：   " + Id);
            try {

                Class.forName("com.mysql.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/hero";
                String user = "root";
                String PINcode = "012357";

                ct = DriverManager.getConnection(url, user, PINcode);
                System.out.println("连接成功");
                ps = ct.prepareStatement("delete from hero where roleName = ?");
                ps.setString(1, Id);
                ps.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                        rs = null;

                    }
                    if (ps != null) {
                        ps.close();
                        ps = null;
                    }
                    if (ct != null) {
                        ct.close();
                        ct = null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            sm = new RoleModel();

            jt.setModel(sm);
        }
        /**********************************************************************/
        else if (arg0.getSource() == jb3){
            System.out.println("修改...");
            UpdateInfor sa = new UpdateInfor(this, "修改", true);
            sm = new RoleModel();
            jt.setModel(sm);
        }
        /*****************************************************************************************/
        else if (arg0.getSource() == jb5) {
          new TransFile();
          JOptionPane.showMessageDialog(this, "导出成功");
        }
    }
}



          /*  int rowNum = this.jt.getSelectedRow();//getSelectedRow返回点中的行
            if(rowNum == -1){
                JOptionPane.showMessageDialog(this, "请选中一行");
                return ;
            }
            String stuId = (String)sm.getValueAt(rowNum, 0);
            System.out.println("Id：   "+stuId);

            try{
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/hero";
                String user = "root";
                String PINcode = "012357";

                ct = DriverManager.getConnection(url, user,PINcode);
                System.out.println("数据库驱动连接成功");
                ps = ct.prepareStatement("delete from hero where roleName = ?");
                ps.setString(1,stuId);
                ps.executeUpdate();

            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    if(rs!= null){
                        rs.close();
                        rs = null;

                    }
                    if(ps!= null){
                        ps.close();
                        ps = null;
                    }
                    if(ct != null){
                        ct.close();
                        ct = null;
                    }
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
            sm = new RoleModel();
            jt.setModel(sm);
    }
}
*/
