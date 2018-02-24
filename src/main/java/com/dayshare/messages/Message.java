package com.dayshare.messages;


import com.dayshare.parent.Parent;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="private_messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long messageId;
    @Column(name = "sender_id")
    private int senderId;
    @ManyToOne
    @JoinColumn(name = "recipient_id", insertable=false, updatable = false)
    private Parent recipient;
    @Column(name = "recipient_id")
    private int recipientId;
    @Column(name = "date_time")
    private Date dateTime;
    @Column(name = "message_text")
    private String messageText;
    private Boolean unread;
    @Column(name = "socketId")
    private int socketId;

    public Message() {
    }

    public Message(int senderId, Parent recipient, int recipientId, Date dateTime, String messageText, Boolean unread, int socketId) {
        this.senderId = senderId;
        this.recipient = recipient;
        this.recipientId = recipientId;
        this.dateTime = dateTime;
        this.messageText = messageText;
        this.unread = unread;
        this.socketId = socketId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public Parent getRecipient() {
        return recipient;
    }

    public void setRecipient(Parent recipient) {
        this.recipient = recipient;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Boolean getUnread() {
        return unread;
    }

    public void setUnread(Boolean unread) {
        this.unread = unread;
    }

    public int getSocketId() {
        return socketId;
    }

    public void setSocketId(int socketId) {
        this.socketId = socketId;
    }
}
