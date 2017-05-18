package com.ectrip.service;

import com.ectrip.model.Modle;
import com.ectrip.model.ModlePrototype;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/16 0016.
 */
public interface ModleService {

    /**
     * 新增项目模块
     * @param projectId
     * @param modlePrototypeId
     * @return int
     */
    int saveModle(Integer projectId, Integer modlePrototypeId);

    /**
     * 修改项目模块
     * @param modle
     * @return int
     */
    int updateModle(Modle modle);

    /**
     * 项目模块分页条件查询
     * @param pageNo
     * @param pageSize
     * @param projectId
     * @param modleName
     * @param modleState
     * @return pageInfo
     */
    public PageInfo<Modle> queryModleList(Integer pageNo, Integer pageSize, Integer projectId, String modleName, String modleState);

    /**
     * 获取未选中的模块原型列表
     * @param projectId
     * @return list
     */
    public List<ModlePrototype> findModlePrototypeList(Integer projectId);

}
