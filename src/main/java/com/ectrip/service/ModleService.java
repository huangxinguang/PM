package com.ectrip.service;

import com.ectrip.model.Modle;
import com.ectrip.model.ModlePrototype;
import com.ectrip.model.Version;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/5/16 0016.
 */
public interface ModleService {

    /**
     * 新增项目模块
     * @return int
     */
    void saveModle(Modle modle);

    /**
     * 查询模块
     * @param modleId
     * @return
     */
    Modle queryModleById(Integer modleId);

    List<Modle> queryModleList(List<Integer> modleIdList);

    /**
     * 修改项目模块
     * @param modle
     * @return int
     */
    void updateModle(Modle modle);

    void delModle(Integer id);

    /**
     * 项目模块分页条件查询
     * @param pageNo
     * @param pageSize
     * @param projectId
     * @param modleName
     * @param modleState
     * @return pageInfo
     */
    PageInfo<Modle> queryModleList(Integer pageNo, Integer pageSize, Integer projectId, String modleName, String modleState);

    PageInfo<Version> queryModleVersionList(Integer pageNo, Integer pageSize, Integer modleId);
    /**
     * 获取项目模块列表
     * @param projectId
     * @return list
     */
    List<Modle> findProjectModleList(Integer projectId);


}
