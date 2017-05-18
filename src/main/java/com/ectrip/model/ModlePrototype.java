package com.ectrip.model;

/**
 * Created by Administrator on 2017/5/12 0012.
 * 项目原型实体类
 */
public class ModlePrototype {

    private Integer id;//自增主键
    private String modlePrototypeName;//模块原型名称
    private String modlePrototypeDescribe;//模块原型描述
    private String operateTime;//操作时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModlePrototypeName() {
        return modlePrototypeName;
    }

    public void setModlePrototypeName(String modlePrototypeName) {
        this.modlePrototypeName = modlePrototypeName;
    }

    public String getModlePrototypeDescribe() {
        return modlePrototypeDescribe;
    }

    public void setModlePrototypeDescribe(String modlePrototypeDescribe) {
        this.modlePrototypeDescribe = modlePrototypeDescribe;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public ModlePrototype() {
    }

    public ModlePrototype(Integer id, String modlePrototypeName, String modlePrototypeDescribe, String operateTime) {
        this.id = id;
        this.modlePrototypeName = modlePrototypeName;
        this.modlePrototypeDescribe = modlePrototypeDescribe;
        this.operateTime = operateTime;
    }
}
