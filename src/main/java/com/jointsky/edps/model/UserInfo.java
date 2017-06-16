package com.jointsky.edps.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by shilin on 2017/6/14.
 * 用户实体
 */
public class UserInfo {

    @ApiModelProperty(value = "用户ID",required = true)
    private String userId;
    @ApiModelProperty(value = "用户名",required = true)
    private String userAccount;
    @ApiModelProperty(value = "姓名",required = true)
    private String userName;
    @ApiModelProperty(value = "手机号",required = true)
    private String telphone;
    @ApiModelProperty(value = "电子邮件",required = true)
    private String email;
    @ApiModelProperty(value = "所在城市",required = true)
    private String region;
    @ApiModelProperty(value = "单位名称",required = true)
    private String factName;
    @ApiModelProperty(value = "密码",required = true)
    private String password;

    private String createTime;

    private String updateTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFactName() {
        return factName;
    }

    public void setFactName(String factName) {
        this.factName = factName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
