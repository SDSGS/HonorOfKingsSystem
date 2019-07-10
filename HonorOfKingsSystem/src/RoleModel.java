
//人物角色建模
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;
public class RoleModel  extends AbstractTableModel {

    Vector roleData;
    Vector columnName;

    Statement stat = null;
    Connection conn = null;
    ResultSet rs = null;

    public void init(String sql){

        if(sql.equals(""))
            sql = "select * from hero";

        columnName = new Vector();
        columnName.add("英雄");
        columnName.add("称号");
        columnName.add("位置");
        columnName.add("特长");
        columnName.add("属性");
        columnName.add("价格");
        columnName.add("招式");


        roleData = new Vector();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载  观测正常");
            String url = "jdbc:mysql://localhost:3306/hero";
            String user = "root";
            String PINcode = "012357";

            conn = DriverManager.getConnection(url,user,PINcode);
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            while(rs.next()){
                Vector vect = new Vector();
                vect.add(rs.getString(1));
                vect.add(rs.getString(2));
                vect.add(rs.getString(3));
                vect.add(rs.getString(4));
                vect.add(rs.getString(5));
                vect.add(rs.getString(6));
                vect.add(rs.getString(7));
                roleData.add(vect);



            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(rs!=null){ rs.close(); rs = null;}
              //  if(stat!=null){rs.close();rs = null;}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public RoleModel(){ this.init(""); }//初始化

    public RoleModel(String sql){this.init(sql);}//获取sql语句并初始化数据

    public int getRowCount(){ return this.roleData.size();}//返回行数

    public int getColumnCount(){ return this.columnName.size();}//返回列数

    public Object getValueAt(int row, int column){ return ((Vector)(this.roleData.get(row))).get(column);}//获得行列数据

    public  String getColumnName(int column){ return (String)this.columnName.get(column);}//获得属性名

}
