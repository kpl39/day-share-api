package com.dayshare.emails;

import com.dayshare.parent.Parent;
import com.dayshare.parent.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Email {

    private Long senderId;
    private Parent sender;
    private Long recipientId;
    private Parent recipient;
    private String subject;
    private String messageBody;

    public Email() {
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Parent getSender() {
        return sender;
    }

    public void setSender(Parent sender) {
        this.sender = sender;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public Parent getRecipient() {
        return recipient;
    }

    public void setRecipient(Parent recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
