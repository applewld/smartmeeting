package com.hznu.smartmeeting.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 部门成员表
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
public class DepartmentMember implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 部门类型
     */
    private Integer departmentType;
    /**
     * 人员id
     */
    private Integer personalId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(Integer departmentType) {
        this.departmentType = departmentType;
    }

    public Integer getPersonalId() {
        return personalId;
    }

    public void setPersonalId(Integer personalId) {
        this.personalId = personalId;
    }

    @Override
    public String toString() {
        return "DepartmentMember{" +
        ", id=" + id +
        ", departmentType=" + departmentType +
        ", personalId=" + personalId +
        "}";
    }
}
