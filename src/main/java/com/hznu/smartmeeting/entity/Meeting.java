package com.hznu.smartmeeting.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 会议表
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
public class Meeting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 例会星期
     */
    private Integer meetingWeekday;
    /**
     * 会议开始日期
     */
    private Date startDate;
    /**
     * 会议开始时间
     */
    private Date startTime;
    /**
     * 会议结束时间
     */
    private Date endTime;
    /**
     * 会议预期时长(min)
     */
    private Integer duration;
    /**
     * 会议室id
     */
    private Integer meetingRoomId;
    /**
     * 会议状态
     */
    private Integer state;
    /**
     * 负责人
     */
    private String responsiblePeople;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 所需服务
     */
    private String requiredServices;
    /**
     * 所属部门 字典
     */
    private Integer departmentType;
    /**
     * 会议上传文件
     */
    private String documents;
    /**
     * 会议类型
     */
    private Integer meetingType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMeetingWeekday() {
        return meetingWeekday;
    }

    public void setMeetingWeekday(Integer meetingWeekday) {
        this.meetingWeekday = meetingWeekday;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getMeetingRoomId() {
        return meetingRoomId;
    }

    public void setMeetingRoomId(Integer meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getResponsiblePeople() {
        return responsiblePeople;
    }

    public void setResponsiblePeople(String responsiblePeople) {
        this.responsiblePeople = responsiblePeople;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRequiredServices() {
        return requiredServices;
    }

    public void setRequiredServices(String requiredServices) {
        this.requiredServices = requiredServices;
    }

    public Integer getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(Integer departmentType) {
        this.departmentType = departmentType;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public Integer getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(Integer meetingType) {
        this.meetingType = meetingType;
    }

    @Override
    public String toString() {
        return "Meeting{" +
        ", id=" + id +
        ", meetingWeekday=" + meetingWeekday +
        ", startDate=" + startDate +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", duration=" + duration +
        ", meetingRoomId=" + meetingRoomId +
        ", state=" + state +
        ", responsiblePeople=" + responsiblePeople +
        ", phoneNumber=" + phoneNumber +
        ", requiredServices=" + requiredServices +
        ", departmentType=" + departmentType +
        ", documents=" + documents +
        ", meetingType=" + meetingType +
        "}";
    }
}
