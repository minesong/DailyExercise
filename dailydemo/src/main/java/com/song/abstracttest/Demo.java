package com.song.abstracttest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;

import javax.swing.*;

public class Demo extends JDialog {
    final JTextField jtf1, jtf2, jtf3, jtf4, jtf5;//
    //final JLabel jlinfo;
    public Demo() {
        setTitle("多项输入对话框");
        setModal(true);
        setSize(300, 200);//对话框的大小
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//关闭后销毁对话框
        setLocationRelativeTo(null);
        JLabel jl1 = new JLabel("姓名:");
        jtf1 = new JTextField(10);
        JLabel jl2 = new JLabel("学号:");
        jtf2 = new JTextField(10);
        JLabel jl3 = new JLabel("年龄:");
        jtf3 = new JTextField(10);
        JLabel jl4 = new JLabel("性别:");
        jtf4 = new JTextField(10);
        JLabel jl5 = new JLabel("籍贯:");
        jtf5 = new JTextField(10);
        JPanel jp = new JPanel(new GridLayout(8, 2));
        jp.add(new JLabel("xxxx"));
        jp.add(new JLabel());
        jp.add(jl1);
        jp.add(jtf1);
        jp.add(jl2);
        jp.add(jtf2);
        jp.add(jl3);
        jp.add(jtf4);
        jp.add(jl4);
        jp.add(jtf3);
        jp.add(jl5);
        jp.add(jtf5);

        jp.add(new JLabel("Active"), 12);
        jp.add(new JLabel());

        jp.add(new JLabel("Plug"), 14);
        jp.add(new JLabel());
        JButton jb = new JButton("确认输入");
        //jlinfo = new JLabel("信息:",JLabel.CENTER);
        jb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String info = "姓名:" + jtf1.getText() + " 学号:" + jtf2.getText() + " 年龄:" + jtf3.getText();
                System.out.println(info);
            }
        });

        add(jp);
        //add(jlinfo,BorderLayout.NORTH);
        add(jb, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        new Demo().setVisible(true);
    }
}
