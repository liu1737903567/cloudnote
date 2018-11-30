package com.oracle.cloudnote.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {

    private String id;
    @NotBlank(message = "用户名不能为空")
    private String name;
    private String nickname;
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, message = "密码不能小于6位")
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
