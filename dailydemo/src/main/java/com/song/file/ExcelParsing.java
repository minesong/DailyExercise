package com.song.file;

import com.alibaba.fastjson.JSON;
import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

public class ExcelParsing {
    private static ArrayList<Map<String, String>> mapArrayList1 = new ArrayList<>();
    private static ArrayList<Map<String, String>> mapArrayList2 = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println();
        try {

            ArrayList<Map<String, String>> mapList = readExcel("/Users/scx/Desktop/1.xlsx");
            String res = "";
            List<PostageTemplateDetailTemp> temps = Lists.newArrayList();
            for (Map<String, String> map : mapList) {
                if (MapUtils.isEmpty(map)) {
                    continue;
                }
                PostageTemplateDetailTemp temp = new PostageTemplateDetailTemp();
                temps.add(temp);
                temp.setStartAddress(StringUtils.deleteWhitespace(map.get("始发地")));
                temp.setDestination(StringUtils.deleteWhitespace(map.get("目的省")));
                temp.setStartFee(new BigDecimal(map.get("首重1kg")).setScale(2, BigDecimal.ROUND_HALF_UP));
                temp.setAddFee(new BigDecimal(map.get("续重1KG")).setScale(2, BigDecimal.ROUND_HALF_UP));
            }
            String s2 = StringUtils.deleteWhitespace(JSON.toJSONString(temps));
            System.out.println(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 从指定路径读取Excel文件，返回类型为List<Map<String,String>>
     *
     * @param path
     * @throws Exception
     */
    public static ArrayList<Map<String, String>> readExcel(String path) throws Exception {


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
                        //System.out.println(value);
                        //获取此单元格对应第一行的值
                        String key = sheet.getRow(0).getCell(cIndex).getStringCellValue();
                        //System.out.println(key);
                        //第一行中的作为键，第n行的作为值
                        map.put(String.valueOf(key), value);
                        //System.out.println(map);
                    }
                }
                mapList.add(map);
            }
            wb.close();

        }

        return mapList;

    }

    static void parse(ArrayList<Map<String, String>> mapList1, ArrayList<Map<String, String>> mapList2) {
        boolean f = false;
        Iterator<Map<String, String>> iterator = mapList1.iterator();
        while (iterator.hasNext()) {
            Map<String, String> map1 = iterator.next();
            f = false;
            String key1 = map1.get("订单号");
            for (Map<String, String> map2 : mapList2) {
                String key2 = map2.get("订单号");
                if (StringUtils.equals(key1, key2) && map1.get("商品名称").equals(map2.get("商品名称"))) {
                    f = true;
                    break;
                }
            }
            if (!f)
                mapArrayList1.add(map1);
        }

        iterator = mapList2.iterator();
        while (iterator.hasNext()) {
            f = false;
            Map<String, String> map2 = iterator.next();
            String key2 = map2.get("订单号");
            for (Map<String, String> map1 : mapList1) {
                String key1 = map1.get("订单号");
                if (StringUtils.equals(key1, key2) && map1.get("商品名称").equals(map2.get("商品名称"))) {
                    f = true;
                    break;
                }
            }
            if (!f)
                mapArrayList2.add(map2);
        }

    }

    public static class PostageTemplateDetailTemp implements Serializable {
        private String startAddress;

        private String destination; //所适用的地址



        private BigDecimal startFee; //收费


        private BigDecimal addFee; //增费

        public String getStartAddress() {
            return startAddress;
        }

        public void setStartAddress(String startAddress) {
            this.startAddress = startAddress;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public BigDecimal getStartFee() {
            return startFee;
        }

        public void setStartFee(BigDecimal startFee) {
            this.startFee = startFee;
        }

        public BigDecimal getAddFee() {
            return addFee;
        }

        public void setAddFee(BigDecimal addFee) {
            this.addFee = addFee;
        }
    }

}
