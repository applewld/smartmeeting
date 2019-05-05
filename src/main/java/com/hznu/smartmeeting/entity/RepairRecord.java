package com.hznu.smartmeeting.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 报修记录表
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
public class RepairRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 报修人
     */
    private String reportPeople;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 报修内容
     */
    private String reportContent;
    /**
     * 图片（路径）
     */
    private String picture;
    /**
     * 报修时间
     */
    private Date reportTime;
    /**
     * 报修状态 0 新申请 1 正在处理 2 已处理
     */
    private Integer reportState;
    /**
     * 报修会议室id
     */
    private Integer meetingRoomId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportPeople() {
        return reportPeople;
    }

    public void setReportPeople(String reportPeople) {
        this.reportPeople = reportPeople;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Integer getReportState() {
        return reportState;
    }

    public void setReportState(Integer reportState) {
        this.reportState = reportState;
    }

    public Integer getMeetingRoomId() {
        return meetingRoomId;
    }

    public void setMeetingRoomId(Integer meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }

    @Override
    public String toString() {
        return "RepairRecord{" +
        ", id=" + id +
        ", reportPeople=" + reportPeople +
        ", phoneNumber=" + phoneNumber +
        ", reportContent=" + reportContent +
        ", picture=" + picture +
        ", reportTime=" + reportTime +
        ", reportState=" + reportState +
        ", meetingRoomId=" + meetingRoomId +
        "}";
    }
}
