package com.ectrip.model;

/**
 * Created by Administrator on 2017/5/9 0009.
 * 模块需求关联实体类
 */
public class ModleDemand {

    private Integer id;//自增主键
    private Integer modleId;//模块主键关联
    private Integer demandId;//需求主键关联

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getModleId() {
        return modleId;
    }

    public void setModleId(Integer modleId) {
        this.modleId = modleId;
    }

    public Integer getDemandId() {
        return demandId;
    }

    public void setDemandId(Integer demandId) {
        this.demandId = demandId;
    }

    public ModleDemand() {
    }

    public ModleDemand(Integer id, Integer modleId, Integer demandId) {
        this.id = id;
        this.modleId = modleId;
        this.demandId = demandId;
    }
}
