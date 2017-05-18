package com.ectrip.model;

/**
 * Created by Administrator on 2017/5/9 0009.
 * 项目模块实体类
 */
public class Modle {

    private Integer id;//自增主键
    private Integer projectId;//项目表主键
    private String modleName;//模块名称
    private String modleDescribe;//模块描述
    private String modleState;//模块状态，0：开发中，1：已完成

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

    public String getModleName() {
        return modleName;
    }

    public void setModleName(String modleName) {
        this.modleName = modleName;
    }

    public String getModleDescribe() {
        return modleDescribe;
    }

    public void setModleDescribe(String modleDescribe) {
        this.modleDescribe = modleDescribe;
    }

    public String getModleState() {
        return modleState;
    }

    public void setModleState(String modleState) {
        this.modleState = modleState;
    }

    public Modle() {
    }

    public Modle(Integer id, Integer projectId, String modleName, String modleDescribe, String modleState) {
        this.id = id;
        this.projectId = projectId;
        this.modleName = modleName;
        this.modleDescribe = modleDescribe;
        this.modleState = modleState;
    }
}
