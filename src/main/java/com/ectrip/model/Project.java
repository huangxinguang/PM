package com.ectrip.model;

/**
 * Created by Administrator on 2017/5/9 0009.
 * 项目实体类
 */
public class Project {

    private Integer id;//自增主键
    private String projectName;//项目名称
    private String projectLeader;//项目负责人
    private String phone;//负责人电话
    private String qq;//负责人QQ
    private String email;//负责人邮箱
    private String operateTime;//操作时间
    private String projectStatus;//项目状态 0(开发中)/1(升级中)/2(已完成)

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public Project() {
    }

    public Project(Integer id, String projectName, String projectLeader, String phone, String qq, String email, String operateTime,String projectStatus) {
        this.id = id;
        this.projectName = projectName;
        this.projectLeader = projectLeader;
        this.phone = phone;
        this.qq = qq;
        this.email = email;
        this.operateTime = operateTime;
        this.projectStatus = projectStatus;
    }
}
