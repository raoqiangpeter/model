package com.raoqiang.model.pmml.entry;

/**
 * 权限设置类，调用系统的用户名和密码需要验证
 */
public class AnthInfo {


    private String username;

    private String password;

    /**
     * 构造方法
     * @param username  业务系统用户名
     * @param password  业务系统用户名对应的密码
     */
    public AnthInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AnthInfo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AnthInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
