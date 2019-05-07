package com.hznu.smartmeeting.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 人员表
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 所属部门
     */
    private Integer departmentType;
    /**
     * 所属组
     */
    private Integer groupType;
    /**
     * 职位
     */
    private String position;
    /**
     * 人脸信息
     */
    private String faceInfo;
    /**
     * 绑定微信号
     */
    private String wechatId;
    /**
     * 账号
     */
    private String accountNumber;
    /**
     * 密码
     */
    private String password;
    /**
     * 所属企业
     */
    private Integer administratorId;
    /**
     * 头像路径
     */
    private String avatar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(Integer departmentType) {
        this.departmentType = departmentType;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFaceInfo() {
        return faceInfo;
    }

    public void setFaceInfo(String faceInfo) {
        this.faceInfo = faceInfo;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    @Override
    public String toString() {
        return "Personal{" +
        ", id=" + id +
        ", name=" + name +
        ", phoneNumber=" + phoneNumber +
        ", departmentType=" + departmentType +
        ", groupType=" + groupType +
        ", position=" + position +
        ", faceInfo=" + faceInfo +
        ", wechatId=" + wechatId +
        ", accountNumber=" + accountNumber +
        ", password=" + password +
        ", administratorId=" + administratorId +
                ", avatar=" + avatar +
        "}";
    }
}
