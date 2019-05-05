package com.hznu.smartmeeting.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 会议室表
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
public class MeetingRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 门牌号
     */
    private String roomNumber;
    /**
     * 会议室标签
     */
    private Integer roomType;
    /**
     * 会议室状态
     */
    private Integer state;
    /**
     * 会议室可容纳人数
     */
    private Integer capacity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "MeetingRoom{" +
        ", id=" + id +
        ", roomNumber=" + roomNumber +
        ", roomType=" + roomType +
        ", state=" + state +
        ", capacity=" + capacity +
        "}";
    }
}
