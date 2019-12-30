package com.newer.indexloaddata.domian;

import java.io.Serializable;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/26 - 15:42
 * 商家实体类
 */
public class Merchants implements Serializable {

    private  Integer mid ;
    private  String  merchantsName;
    private  String  merchantsImg;
    private  String  merchantsAddres;
    private  String  merchantsPhone;
    private  String  businessTime;
    private  String icon;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    public String getMerchantsImg() {
        return merchantsImg;
    }

    public void setMerchantsImg(String merchantsImg) {
        this.merchantsImg = merchantsImg;
    }

    public String getMerchantsAddres() {
        return merchantsAddres;
    }

    public void setMerchantsAddres(String merchantsAddres) {
        this.merchantsAddres = merchantsAddres;
    }

    public String getMerchantsPhone() {
        return merchantsPhone;
    }

    public void setMerchantsPhone(String merchantsPhone) {
        this.merchantsPhone = merchantsPhone;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Merchants{" +
                "mid=" + mid +
                ", merchantsName='" + merchantsName + '\'' +
                ", merchantsImg='" + merchantsImg + '\'' +
                ", merchantsAddres='" + merchantsAddres + '\'' +
                ", merchantsPhone='" + merchantsPhone + '\'' +
                ", businessTime='" + businessTime + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
