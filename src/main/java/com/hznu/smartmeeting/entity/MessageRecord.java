package com.hznu.smartmeeting.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author AppleWld
 * @since 2019-05-06
 */
public class MessageRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 消息类型
     */
    private Integer messageType;
    /**
     * 消息内容
     */
    private String messageContent;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 会议id  外键
     */
    private Integer meetingId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    @Override
    public String toString() {
        return "MessageRecord{" +
        ", id=" + id +
        ", messageType=" + messageType +
        ", messageContent=" + messageContent +
        ", createTime=" + createTime +
        ", meetingId=" + meetingId +
        "}";
    }
}
