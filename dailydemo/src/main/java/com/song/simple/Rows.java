package com.song.simple;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rows")
public class Rows {

    @Element(name = "productCategory", required = false)
    private String productCategory;

    @Element(name = "sortName", required = false)
    private String sortName;

    @Element(name = "productBrand", required = false)
    private String productBrand;

    @Element(name = "productID", required = false)
    private String productID;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Element(name = "brandName", required = false)
    private String brandName;

    @Element(name = "productName", required = false)
    private String productName;

    @Element(name = "color", required = false)
    private String color;

    @Element(name = "sizeNo", required = false)
    private String sizeNo;

    @Element(name = "saleNum", required = false)
    private String saleNum;

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSizeNo() {
        return sizeNo;
    }

    public void setSizeNo(String sizeNo) {
        this.sizeNo = sizeNo;
    }

    public String getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(String saleNum) {
        this.saleNum = saleNum;
    }
    public String toString() {
        return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
    }
}
