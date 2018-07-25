package com.song.abstracttest;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class day21 extends JFrame {

    public day21(String title) throws Exception {
        super(title);
        // TODO Auto-generated constructor stub
        this.setSize(500, 100);
        this.setLocation(300, 200);
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        this.setLayout(new BorderLayout());
        this.add(getLabel(), BorderLayout.NORTH);
        this.add(getNamePwdPandel(), BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private Component getLabel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("用户登录"), BorderLayout.EAST);
        return panel;
    }

    private Component getNamePwdPandel() {
        // TODO Auto-generated method stub
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel jlabel = new JLabel("用户名");
        JTextField name = new JTextField();
        panel.add(jlabel, BorderLayout.WEST);
        panel.add(name, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) throws Exception {
        day21 DAY21 = new day21("标签和文本框");
    }
}

