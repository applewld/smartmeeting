package com.hznu.smartmeeting.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author AppleWld
 * @since 2019-01-18
 */
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 公司名称
     */
    private String corporateName;
    /**
     * 企业类型
     */
    private Integer enterprisesType;
    /**
     * 法定代表人
     */
    private String legalRepresentative;
    /**
     * 工商注册号
     */
    private String commercialRegistrationNumber;
    /**
     * 账号
     */
    private String accountNumber;
    /**
     * 密码
     */
    private String password;
    /**
     * 注册时间
     */
    private Date registerTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public Integer getEnterprisesType() {
        return enterprisesType;
    }

    public void setEnterprisesType(Integer enterprisesType) {
        this.enterprisesType = enterprisesType;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getCommercialRegistrationNumber() {
        return commercialRegistrationNumber;
    }

    public void setCommercialRegistrationNumber(String commercialRegistrationNumber) {
        this.commercialRegistrationNumber = commercialRegistrationNumber;
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

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "Administrator{" +
        ", id=" + id +
        ", corporateName=" + corporateName +
        ", enterprisesType=" + enterprisesType +
        ", legalRepresentative=" + legalRepresentative +
        ", commercialRegistrationNumber=" + commercialRegistrationNumber +
        ", accountNumber=" + accountNumber +
        ", password=" + password +
        ", registerTime=" + registerTime +
        "}";
    }
}
