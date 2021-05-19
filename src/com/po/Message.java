package com.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述:message表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2019-04-07
 */
public class Message  implements Serializable{
    /**
     * 
     */
    private String messageId;

    /**
     * 
     */
    private String sendId;

    /**
     * 
     */
    private String receiveId;

    /**
     * 
     */
    private Date messageTime;

    /**
     * 
     */
    private String messContext;

    /**
     * 
     * @return messageId 
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * 
     * @param messageId 
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId == null ? null : messageId.trim();
    }

    /**
     * 
     * @return sendId 
     */
    public String getSendId() {
        return sendId;
    }

    /**
     * 
     * @param sendId 
     */
    public void setSendId(String sendId) {
        this.sendId = sendId == null ? null : sendId.trim();
    }

    /**
     * 
     * @return receiveId 
     */
    public String getReceiveId() {
        return receiveId;
    }

    /**
     * 
     * @param receiveId 
     */
    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId == null ? null : receiveId.trim();
    }

    /**
     * 
     * @return messageTime 
     */
    public Date getMessageTime() {
        return messageTime;
    }

    /**
     * 
     * @param messageTime 
     */
    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    /**
     * 
     * @return messContext 
     */
    public String getMessContext() {
        return messContext;
    }

    /**
     * 
     * @param messContext 
     */
    public void setMessContext(String messContext) {
        this.messContext = messContext == null ? null : messContext.trim();
    }
}