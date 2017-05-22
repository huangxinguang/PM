package com.ectrip.model;

/**
 * Created by Administrator on 2017/5/9 0009.
 * 版本实体类
 */
public class Version {

    private Integer id;//自增主键
    private String version;//申请的版本号
    private Integer modleId;//模块主键，关联模块
    private String upUserId;//升级人
    private String upTime;//升级时间
    private Integer versionId;//升级前的版本ID
    private Integer demandId;//升级对应的需求ID
    private Integer versionState;//版本状态，0：停用，1：启用

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getModleId() {
        return modleId;
    }

    public void setModleId(Integer modleId) {
        this.modleId = modleId;
    }

    public String getUpUserId() {
        return upUserId;
    }

    public void setUpUserId(String upUserId) {
        this.upUserId = upUserId;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Integer getDemandId() {
        return demandId;
    }

    public void setDemandId(Integer demandId) {
        this.demandId = demandId;
    }

    public Integer getVersionState() {
        return versionState;
    }

    public void setVersionState(Integer versionState) {
        this.versionState = versionState;
    }

    public Version() {
    }
}
