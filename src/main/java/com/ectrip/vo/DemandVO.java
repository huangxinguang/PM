package com.ectrip.vo;

/**
 * Created by huangxinguang on 2017/5/19 0019.
 */
public class DemandVO {
    private Integer id;//自增主键
    private Integer projectId;//项目ID
    private String projectName;//项目名称
    private String demandName;//需求名称
    private String demandDescribe;//需求描述
    private String putTime;//提出时间
    private String putUserId;//提出人
    private String version;
    private String exceptEndTime;//预期完成时间
    private String actualEndTime;//实际完成时间
    private String completeUserId;//完成人
    private String demandStatus;//需求状态，0;完成中，1：已完成

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public String getDemandStatus() {
        return demandStatus;
    }

    public void setDemandStatus(String demandStatus) {
        this.demandStatus = demandStatus;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public DemandVO() {
    }
}
