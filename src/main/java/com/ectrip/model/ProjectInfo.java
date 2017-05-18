package com.ectrip.model;

/**
 * Created by Administrator on 2017/5/9 0009.
 * 项目基本信息实体类
 */
public class ProjectInfo {

    private Integer id;//自增主键
    private Integer projectId;//项目表主键
    private String serverIp;//服务器IP
    private String dbServerIp;//数据库服务器IP
    private String dbUser;//数据库用户名
    private String dbPwd;//数据库密码
    private Integer dbPort;//数据库端口号
    private String hostName;//域名
    private String ssh;//包括：服务器用户名、密码、端口号、连接方式、防火墙等

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

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getDbServerIp() {
        return dbServerIp;
    }

    public void setDbServerIp(String dbServerIp) {
        this.dbServerIp = dbServerIp;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPwd() {
        return dbPwd;
    }

    public void setDbPwd(String dbPwd) {
        this.dbPwd = dbPwd;
    }

    public Integer getDbPort() {
        return dbPort;
    }

    public void setDbPort(Integer dbPort) {
        this.dbPort = dbPort;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getSsh() {
        return ssh;
    }

    public void setSsh(String ssh) {
        this.ssh = ssh;
    }

    public ProjectInfo() {
    }

    public ProjectInfo(Integer id, Integer projectId, String serverIp, String dbServerIp, String dbUser, String dbPwd, Integer dbPort, String hostName, String ssh) {
        this.id = id;
        this.projectId = projectId;
        this.serverIp = serverIp;
        this.dbServerIp = dbServerIp;
        this.dbUser = dbUser;
        this.dbPwd = dbPwd;
        this.dbPort = dbPort;
        this.hostName = hostName;
        this.ssh = ssh;
    }
}
