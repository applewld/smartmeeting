package com.hznu.smartmeeting.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 组成员表
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
public class GroupMember implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 组类型
     */
    private Integer groupType;
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

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public Integer getPersonalId() {
        return personalId;
    }

    public void setPersonalId(Integer personalId) {
        this.personalId = personalId;
    }

    @Override
    public String toString() {
        return "GroupMember{" +
        ", id=" + id +
        ", groupType=" + groupType +
        ", personalId=" + personalId +
        "}";
    }
}
