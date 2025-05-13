package com.example.clothstore.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "feedback")
public class Feedback {
    @Id
    private String feedbackId;

    @Column(name = "feedback_content")
    private String feedbackContent;

    @Column(name = "is_read")
    private Boolean isRead;

    @Temporal(TemporalType.DATE)
    @Column(name = "sent_date")
    private Date sentDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
