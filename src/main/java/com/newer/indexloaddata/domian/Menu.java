package com.newer.indexloaddata.domian;

import java.io.Serializable;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/26 - 21:14
 */
public class Menu implements Serializable {
    private  Integer meId;
    private  String menuName;
    private  Integer menuPrice;
    private  Integer menuNum;
    private  Integer comment;
    private  Integer merchantsId;
    private String pictureurl;
    private  Merchants merchants;
    private  Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Merchants getMerchants() {
        return merchants;
    }

    public void setMerchants(Merchants merchants) {
        this.merchants = merchants;
    }

    public Integer getMeId() {
        return meId;
    }

    public void setMeId(Integer meId) {
        this.meId = meId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(Integer menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Integer getMenuNum() {
        return menuNum;
    }

    public void setMenuNum(Integer menuNum) {
        this.menuNum = menuNum;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getMerchantsId() {
        return merchantsId;
    }

    public void setMerchantsId(Integer merchantsId) {
        this.merchantsId = merchantsId;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "meId=" + meId +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", menuNum=" + menuNum +
                ", comment=" + comment +
                ", merchantsId=" + merchantsId +
                ", pictureurl='" + pictureurl + '\'' +
                ", merchants=" + merchants +
                '}';
    }
}
