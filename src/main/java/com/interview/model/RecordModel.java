package com.interview.model;

import com.interview.grouper.RecordGrouper;

/**
 *
 * Simple Model for a Record. This will be used to group up by {@link RecordGrouper}
 * @author Trung Tran
 **/
public class RecordModel {

    private String accountNumber;
    private String callingNumber;
    private String dialledNumber;
    private String startTime;
    private String endTime;
    private String callType;
    private String callCost;

    public RecordModel() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDialledNumber() {
        return dialledNumber;
    }

    public void setDialledNumber(String dialledNumber) {
        this.dialledNumber = dialledNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getCallCost() {
        return callCost;
    }

    public void setCallCost(String callCost) {
        this.callCost = callCost;
    }

    public String getCallingNumber() {
        return callingNumber;
    }

    public void setCallingNumber(String callingNumber) {
        this.callingNumber = callingNumber;
    }
}
