package com.song.abstracttest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class Login extends JFrame {
    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        setTitle("工具");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setToolTipText("");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        textField = new JTextField();
        textField.setBounds(121, 86, 194, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        JLabel lblNewLabel = new JLabel("请输入10位数以内的字符串");
        lblNewLabel.setBounds(145, 59, 194, 15);
        contentPane.add(lblNewLabel);
        JButton btnNewButton = new JButton("确定");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ca = textField.getText();
                int n = ca.length();
                if (n > 10) {
                    JOptionPane.showMessageDialog(null, "对不起,您输入的字符串长度超过10",
                            "错误提示", JOptionPane.ERROR_MESSAGE);
                } else if (n >= 0 || n <= 10) {
                    JOptionPane.showMessageDialog(null, "字符串长度为" + n, "提示",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        btnNewButton.setBounds(172, 130, 93, 23);
        contentPane.add(btnNewButton);
    }
}