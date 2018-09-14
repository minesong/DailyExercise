package com.song.file;

import java.io.*;

public abstract class Parsing {
    /**
     * 替换动作的实现
     *
     * @param txtPath 将要操作的文件对象路径
     * @param idNum   需要查找的行
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
            while ((line = br.readLine()) != null) {
                if (!isRepSucc && line.contains(idNum)) {
                    String target = spiltAndReplace(line);
                    if (target != null) {
                        int idx = line.indexOf(target);
                        line = line.substring(0, idx) + newStr + line.substring(idx + target.length());
                        isRepSucc = true;
                    }
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

    /**
     * 获取需要替换掉的字符串
     *
     * @param line
     * @return
     */
    public abstract String spiltAndReplace(String line);

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
