package com.song.write; /**
 * Created by scx on 2019/7/15.
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.List;

public class WriterTo extends JFrame implements ActionListener {
    JButton b;
    JTextArea t;
    JLabel l;
    private int max_num = 15;
    static Map<String, List<Person>> personMap = new LinkedHashMap<>();

    public WriterTo() {
        super("填写文件全部路径,多个文件请用换行,文件不能重名");
        l = new JLabel("请输入内容：");
        t = new JTextArea(8, 20);
        b = new JButton("写入");
        b.addActionListener(this);
        this.add(l);
        this.add(t);
        this.add(b);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            if (t.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "请输入内容~", "错误", JOptionPane.ERROR_MESSAGE);
                t.grabFocus();
            } else {
                write(t.getText());
                personMap = new LinkedHashMap<>();
            }
        }
    }

    public void write(String line) {
        try {
            String[] files = line.split("\n");

            for (String file : files) {
                if (file.length() <= 0) {
                    continue;
                }
                file = file.trim();
                List<Map<String, String>> excel = ExcelUtil.readExcel(file);
                if (excel == null || excel.size() == 0) {
                    JOptionPane.showMessageDialog(null, "文件格式错误~" + file, "错误", JOptionPane.ERROR_MESSAGE);
                }
                List<Person> list = new ArrayList<>();
                for (Map<String, String> p : excel) {
                    String name = p.get("姓名");
                    String phone = p.get("电话");
                    if (name == null || name.trim().length() == 0
                            || phone == null || phone.trim().length() == 0) {
                        continue;
                    }
                    Person person = new Person();
                    person.setName(name.trim());
                    person.setPhone(phone.trim());
                    list.add(person);
                }
                personMap.put(file, list);
            }
            Map<String, List<Person>> hasReaded = new LinkedHashMap<>();

            int t = 0;
            for (Map.Entry<String, List<Person>> entry : personMap.entrySet()) {
                t += entry.getValue().size();
            }
            if (t < max_num) {
                JOptionPane.showMessageDialog(null, "总数据量不足:" + max_num, "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int i = 0;
            while (i < max_num) {
                for (Map.Entry<String, List<Person>> entry : personMap.entrySet()) {
                    List<Person> personList = new ArrayList<>(entry.getValue());
                    List<Person> has = hasReaded.get(entry.getKey());
                    if (has == null) {
                        has = new ArrayList<>();
                        hasReaded.put(entry.getKey(), has);
                    }
                    personList.removeAll(has);
                    if (personList.size() <= 0) {
                        continue;
                    }
                    int r = new Random().nextInt(personList.size());
                    has.add(personList.get(r));
                    i++;
                    if (i >= max_num) {
                        break;
                    }
                }
            }

            ExcelUtil.createExcel(hasReaded, 1);
            ExcelUtil.createExcel(hasReaded, 2);
            ExcelUtil.createExcel(hasReaded, 3);

            JOptionPane.showMessageDialog(null, "写入成功", "提示", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "文件格式错误~" + line, "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) throws IOException {
        new WriterTo();


    }

    class Person implements Serializable {
        private String phone;
        private String name;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (phone != null ? !phone.equals(person.phone) : person.phone != null) return false;
            return name != null ? name.equals(person.name) : person.name == null;
        }

        @Override
        public int hashCode() {
            int result = phone != null ? phone.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }
}
