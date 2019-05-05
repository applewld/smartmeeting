package com.hznu.smartmeeting.mybeans;

import org.springframework.stereotype.Component;

@Component
public class LoginInfo {//封装登录信息
    private String username;
    private String password;
    private boolean rememberMe;
    private String captcha; //验证码：图形或短信验证码

    public boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
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

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String toString()
    {
        return "\nusername:"+username+"\npassword:"+password+"\ncaptcha:"+captcha;
    }
}
