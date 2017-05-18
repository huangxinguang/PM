package com.ectrip.model;

/**
 * Created by Administrator on 2017/5/9 0009.
 * 需求实体类
 */
public class Demand {

    private Integer id;//自增主键
    private String demandName;//需求名称
    private String demandDescribe;//需求描述
    private String putTime;//提出时间
    private String putUserId;//提出人
    private String exceptEndTime;//预期完成时间
    private String actualEndTime;//实际完成时间
    private String completeUserId;//完成人
    private Integer demandStatus;//需求状态，0;已完成，1：完成中

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDemandName() {
        return demandName;
    }

    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }

    public String getDemandDescribe() {
        return demandDescribe;
    }

    public void setDemandDescribe(String demandDescribe) {
        this.demandDescribe = demandDescribe;
    }

    public String getPutTime() {
        return putTime;
    }

    public void setPutTime(String putTime) {
        this.putTime = putTime;
    }

    public String getPutUserId() {
        return putUserId;
    }

    public void setPutUserId(String putUserId) {
        this.putUserId = putUserId;
    }

    public String getExceptEndTime() {
        return exceptEndTime;
    }

    public void setExceptEndTime(String exceptEndTime) {
        this.exceptEndTime = exceptEndTime;
    }

    public String getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(String actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public String getCompleteUserId() {
        return completeUserId;
    }

    public void setCompleteUserId(String completeUserId) {
        this.completeUserId = completeUserId;
    }

    public Integer getDemandStatus() {
        return demandStatus;
    }

    public void setDemandStatus(Integer demandStatus) {
        this.demandStatus = demandStatus;
    }

    public Demand() {
    }

    public Demand(Integer id, String demandName, String demandDescribe, String putTime, String putUserId, String exceptEndTime, String actualEndTime, String completeUserId, Integer demandStatus) {
        this.id = id;
        this.demandName = demandName;
        this.demandDescribe = demandDescribe;
        this.putTime = putTime;
        this.putUserId = putUserId;
        this.exceptEndTime = exceptEndTime;
        this.actualEndTime = actualEndTime;
        this.completeUserId = completeUserId;
        this.demandStatus = demandStatus;
    }
}
