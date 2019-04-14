package club.gsjblog.soulsoother.test;


import club.gsjblog.soulsoother.utils.PropertiesUtils;

import javax.swing.*;
import java.awt.*;

public class Mytest {


    public static void main(String[] args) {
//        String des = PropertiesUtils.getPropertieByKey("classpath:base.properties", "jitang06");
//        System.out.println(des);

        // 布局
        JFrame f = new JFrame("文本编辑功能窗口");
        f.setBounds(200, 150, 350, 227);
        f.setLayout(null);

        JPanel dialogPanel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(" 内容");
        label.setPreferredSize(new Dimension(30, 30));
        dialogPanel.add(label, BorderLayout.CENTER);
        f.setContentPane(dialogPanel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }


    public void fun(){
        String path = this.getClass().getClassLoader().getResource("/").getPath();


    }
}
