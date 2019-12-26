package com.newer.logreg.domian;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/25 - 13:02
 *
 */
public class User {
    //占时只有这些字段 后期根据功能在加
    private  Integer uId; //用户id
    private  String userName;//用户名
    private  String  password;//用户密码
    private  String email;//用户邮箱
    private  String   phone;//手机号码

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
