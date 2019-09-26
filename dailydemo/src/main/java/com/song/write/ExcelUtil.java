package com.song.write;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by scx on 2019/7/15.
 */
public class ExcelUtil {


    /**
     * 从指定路径读取Excel文件，返回类型为List<Map<String,String>>
     *
     * @param path
     * @throws Exception
     */
    public static List<Map<String, String>> readExcel(String path) throws Exception {

        ArrayList<Map<String, String>> mapList = new ArrayList<>();
        File file = new File(path);
        //判断文件是否存在
        if (file.isFile() && file.exists()) {
            //获取文件的后缀名 \\ .是特殊字符
            String[] split = file.getName().split("\\.");
            Workbook wb;
            //根据文件后缀（xls/xlsx）进行判断
            if ("xls".equals(split[1])) {
//              //获取文件流对象
                FileInputStream inputStream = new FileInputStream(file);
                wb = new HSSFWorkbook(inputStream);
            } else if ("xlsx".equals(split[1])) {
                wb = new XSSFWorkbook(file);
            } else {
                System.out.println("文件类型错误");
                return null;
            }

            //开始解析
            Sheet sheet = wb.getSheetAt(0);
            //第一行是列名，所以从第二行开始遍历
            int firstRowNum = sheet.getFirstRowNum() + 1;
            int lastRowNum = sheet.getLastRowNum();

            //遍历行
            for (int rIndex = firstRowNum; rIndex <= lastRowNum; rIndex++) {
                Map map = new HashMap();
                //获取当前行的内容
                Row row = sheet.getRow(rIndex);
                if (row != null) {
                    int firstCellNum = row.getFirstCellNum();
                    int lastCellNum = row.getLastCellNum();
                    for (int cIndex = firstCellNum; cIndex < lastCellNum; cIndex++) {
                        if (row.getCell(cIndex) == null) {
                            continue;
                        }
                        row.getCell(cIndex).setCellType(Cell.CELL_TYPE_STRING);
                        //获取单元格的值
                        String value = row.getCell(cIndex).getStringCellValue();
                        //获取此单元格对应第一行的值
                        String key = sheet.getRow(0).getCell(cIndex).getStringCellValue();
                        //System.out.println(key);
                        //第一行中的作为键，第n行的作为值
                        map.put(String.valueOf(key), value);
                    }
                }
                mapList.add(map);
            }
            wb.close();

        } else {
            throw new Exception("文件不存在，请检查路径" + path);
        }

        return mapList;

    }

    /**
     * 生成excel
     *
     * @throws IOException
     */
    public static void createExcel(Map<String, List<WriterTo.Person>> datalist, int type) throws IOException {
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        // 建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("sheet1");
        // 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row0 = sheet.createRow(0);
        // 添加表头
        if (type == 1) {
            row0.createCell(0).setCellValue("姓名");

        } else if (type == 2) {
            row0.createCell(0).setCellValue("电话");
        } else {
            row0.createCell(0).setCellValue("姓名");
            row0.createCell(1).setCellValue("电话");
        }

        //格式化数字
        NumberFormat nf = NumberFormat.getInstance();
        // 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        int j = 0;
        for (List<WriterTo.Person> dataL : datalist.values())
            // 在sheet里创建往下的行
            for (WriterTo.Person db : dataL) {
                HSSFRow row = sheet.createRow(j + 1);
                if (type == 1) {
                    row.createCell(0).setCellValue(db.getName());
                } else if (type == 2) {
                    row.createCell(0).setCellValue(db.getPhone());
                } else {
                    row.createCell(0).setCellValue(db.getName());
                    row.createCell(1).setCellValue(db.getPhone());
                }
                j++;

            }
        //输出Excel文件1
        List<String> keys = new ArrayList<>(datalist.keySet());
        String key = keys.get(0);
        int inx = key.lastIndexOf("/");
        FileOutputStream output = new FileOutputStream(key.substring(0, inx + 1) + type + ".xls");
        wb.write(output);//写入磁盘
        output.close();
    }

}
