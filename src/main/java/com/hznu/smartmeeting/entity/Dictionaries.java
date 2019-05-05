package com.hznu.smartmeeting.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
public class Dictionaries implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 字典名称
     */
    private String name;
    /**
     * 类型名称
     */
    private String type;
    /**
     * 类型对应数字
     */
    private Integer typeNumber;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(Integer typeNumber) {
        this.typeNumber = typeNumber;
    }

    @Override
    public String toString() {
        return "Dictionaries{" +
        ", id=" + id +
        ", name=" + name +
        ", type=" + type +
        ", typeNumber=" + typeNumber +
        "}";
    }
}
