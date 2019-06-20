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

import javax.json.Json;
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
            ArrayList<Map<String, String>> mapList1 = readExcel("/Users/scx/Desktop/code.xlsx");

            Map<String, String> place = Maps.newHashMap();
            for (Map<String, String> map : mapList1) {
                if (MapUtils.isEmpty(map)) {
                    continue;
                }
                place.put(map.get("name").substring(0, 2), map.get("code"));

            }
            System.out.println(JSON.toJSON(place));
            ArrayList<Map<String, String>> mapList = readExcel("/Users/scx/Desktop/1.xlsx");
            String res = "";
            List<PostageTemplateDetailTemp> temps = Lists.newArrayList();
            for (Map<String, String> map : mapList) {
                if (MapUtils.isEmpty(map)) {
                    continue;
                }
                PostageTemplateDetailTemp temp = new PostageTemplateDetailTemp();
                temps.add(temp);
                temp.setBeginPlace(map.get("始发地"));
                String code = place.get(map.get("目的省").substring(0, 2));
                if (StringUtils.isBlank(code)) {
                    System.out.println(JSON.toJSON(map));
                    System.out.println("-----");
                }
                temp.setEndPlace(StringUtils.deleteWhitespace(code));
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
            System.out.println(file.getPath());
            //获取文件的后缀名 \\ .是特殊字符
            String[] split = file.getName().split("\\.");
            System.out.println(split[1]);
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
        private String beginPlace;

        private String endPlace; //所适用的地址


        private BigDecimal startStandards = BigDecimal.ONE; //初始量（重量，数量，体积）

        private BigDecimal startFee; //收费

        private BigDecimal addStandards = BigDecimal.ONE; //增加量（重量，数量，体积）

        private BigDecimal addFee; //增费

        public String getBeginPlace() {
            return beginPlace;
        }

        public void setBeginPlace(String beginPlace) {
            this.beginPlace = beginPlace;
        }

        public String getEndPlace() {
            return endPlace;
        }

        public void setEndPlace(String endPlace) {
            this.endPlace = endPlace;
        }

        public BigDecimal getStartStandards() {
            return startStandards;
        }

        public void setStartStandards(BigDecimal startStandards) {
            this.startStandards = startStandards;
        }

        public BigDecimal getStartFee() {
            return startFee;
        }

        public void setStartFee(BigDecimal startFee) {
            this.startFee = startFee;
        }

        public BigDecimal getAddStandards() {
            return addStandards;
        }

        public void setAddStandards(BigDecimal addStandards) {
            this.addStandards = addStandards;
        }

        public BigDecimal getAddFee() {
            return addFee;
        }

        public void setAddFee(BigDecimal addFee) {
            this.addFee = addFee;
        }
    }

}
