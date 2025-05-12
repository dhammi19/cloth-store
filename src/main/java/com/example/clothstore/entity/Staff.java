package com.example.clothstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "staff")
public class Staff {
    @Id
    private String staffId;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "staff_birthday")
    private String staffBirthday;

    @Column(name = "staff_phone_number")
    private String staffPhoneNumber;

    @Column(name = "staff_address")
    private String staffAddress;

    @Column(name = "staff_password")
    private String staffPassword;

    @Column(name = "staff_added_date")
    private String staffAddedDate;

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

    public String getStaffBirthday() {
        return staffBirthday;
    }

    public void setStaffBirthday(String staffBirthday) {
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

    public String getStaffAddedDate() {
        return staffAddedDate;
    }

    public void setStaffAddedDate(String staffAddedDate) {
        this.staffAddedDate = staffAddedDate;
    }
}
