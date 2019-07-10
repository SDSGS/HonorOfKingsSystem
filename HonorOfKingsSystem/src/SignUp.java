import java.awt.*;
import java.util.*;

class SignUp extends Panel {
    public void paint(Graphics g)
    {
        int height = 150;
        int width = 450;
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width-1, height-1);
        Random r = new Random();
        for(int i = 0;i<100;i++)//绘制一个举行框
        {
            int x = r.nextInt(width)-1;
            int y = r.nextInt(height)-1;
            g.drawOval(x, y, 2, 2);
        }
        g.setFont(new Font("楷体",Font.BOLD,40));
        g.setColor(Color.RED);
        char[] tmp = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<4;i++)//生成验证码
        {
            int pos = r.nextInt(tmp.length);
            char c = tmp[pos];
            sb.append(c + " ");
        }
        g.drawString(sb.toString(), 130, 80);//打印验证码字符串
    }
}