package com.newer.logreg.domian;

/**
 * @author 梁虔硕版权所有 哈哈哈哈
 * @date 2019/12/30 - 10:19
 *  封装错误信息和user
 */
public class Login {
  private   User user;
   private   String msg;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Login{" +
                "user=" + user +
                ", msg='" + msg + '\'' +
                '}';
    }
}
