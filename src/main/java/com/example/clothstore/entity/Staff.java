package com.example.clothstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "staff")
public class Staff {
    @Id
    private String staffId;

    @Column(name = "staff_name")
    private String staffName;

    @Temporal(TemporalType.DATE)
    @Column(name = "staff_birthday")
    private Date staffBirthday;

    @Column(name = "staff_phone_number")
    private String staffPhoneNumber;

    @Column(name = "staff_address")
    private String staffAddress;

    @Column(name = "staff_password")
    private String staffPassword;

    @Temporal(TemporalType.DATE)
    @Column(name = "staff_added_date")
    private Date staffAddedDate;

    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    Set<Order> orders;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Date getStaffBirthday() {
        return staffBirthday;
    }

    public void setStaffBirthday(Date staffBirthday) {
        this.staffBirthday = staffBirthday;
    }

    public String getStaffPhoneNumber() {
        return staffPhoneNumber;
    }

    public void setStaffPhoneNumber(String staffPhoneNumber) {
        this.staffPhoneNumber = staffPhoneNumber;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public Date getStaffAddedDate() {
        return staffAddedDate;
    }

    public void setStaffAddedDate(Date staffAddedDate) {
        this.staffAddedDate = staffAddedDate;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
