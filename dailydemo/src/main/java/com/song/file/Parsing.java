package com.song.file;

import java.io.*;
import java.util.Objects;

public  class Parsing {
    /**
     * 替换动作的实现
     *
     * @param txtPath 将要操作的文件对象路径
     * @param idNum   需要查找的行/老字符串
     * @param newStr  用于替换的字符串
     */
    public boolean replaceStr(String txtPath, String idNum, String newStr) {
        boolean isRepSucc = false;
        if (!checkStringIsNotBlankAll(txtPath, idNum, newStr)) {
            //传递的参数有误
            return isRepSucc;
        }
        InputStreamReader reader = null;
        BufferedReader br = null;
        OutputStreamWriter writer = null;
        BufferedWriter bw = null;
        StringBuffer sb = new StringBuffer("");
        String line = "";
        try {
            reader = new InputStreamReader(new FileInputStream(txtPath));
            br = new BufferedReader(reader);
            boolean codeBegin = false;
            boolean dataEdnd = false;
            while ((line = br.readLine()) != null) {
                String tmp = line.replace(" ", "");
                if (tmp.equals("/*CODE*/")) {
                    codeBegin = true;
                }
                if (tmp.equals("/*DATA*/")) {
                    dataEdnd = true;
                }
                if (codeBegin && !dataEdnd) {
                    line = line.replace(idNum, newStr);
                }
                if (dataEdnd) {
                    line = line.replace(idNum, newStr);
                }
                sb.append(line + "\r");
            }
            br.close();
            reader.close();

            writer = new OutputStreamWriter(new FileOutputStream(txtPath));
            bw = new BufferedWriter(writer);
            bw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clolseStream(bw, writer, br, reader);

        }
        return isRepSucc;

    }

    /*
    字符串的非空校验
     */
    private Boolean checkStringIsNotBlankAll(String... str) {
        if (str == null || str.length == 0) {
            return false;
        }
        for (String s : str) {
            if (s == null || s.trim().length() == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 流的关闭操作
     *
     * @param stream
     */
    public void clolseStream(Closeable... stream) {
        if (stream == null) {
            return;
        }
        try {
            for (Closeable closeable : stream) {
                if (closeable != null) {
                    closeable.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
