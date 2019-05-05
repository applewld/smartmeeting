package com.hznu.smartmeeting.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 会议室设备表
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
public class MeetingRoomDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 会议室id 外键
     */
    private Integer meetingRoomId;
    /**
     * 硬件类型
     */
    private Integer deviceType;
    /**
     * 设备状态
     */
    private Integer state;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMeetingRoomId() {
        return meetingRoomId;
    }

    public void setMeetingRoomId(Integer meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "MeetingRoomDevice{" +
        ", id=" + id +
        ", meetingRoomId=" + meetingRoomId +
        ", deviceType=" + deviceType +
        ", state=" + state +
        "}";
    }
}
