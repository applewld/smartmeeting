package com.hznu.smartmeeting.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 会议与会人员表
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
public class MeetingPeople implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 例会id
     */
    private Integer meetingId;
    /**
     * 与会人员id
     */
    private Integer personalId;
    /**
     * 参会状态 0 参会（默认）1 请假  2 未到会
     */
    private Integer state;
    /**
     * 请假原因
     */
    private String reason;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public Integer getPersonalId() {
        return personalId;
    }

    public void setPersonalId(Integer personalId) {
        this.personalId = personalId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "MeetingPeople{" +
        ", id=" + id +
        ", meetingId=" + meetingId +
        ", personalId=" + personalId +
        ", state=" + state +
        ", reason=" + reason +
        "}";
    }
}
