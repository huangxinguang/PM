package com.ectrip.dao;

import com.ectrip.model.Modle;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
public interface ModleDAO {

    /**
     * 新增模块
     * @param modle
     * @return int
     */
    void saveModle(Modle modle);

    /**
     * 批量插入
     * @param modleList
     * @return
     */
    void batchSaveModle(@Param("modleList") List<Modle> modleList);

    /**
     * 更新模块
     * @param modle
     * @return int
     */
    void updateModle(Modle modle);

    Modle queryModleById(@Param("id")Integer id);

    void delModle(@Param("id") Integer id);

    /**
     * 查找指定项目的模块列表
     * @param projectId
     * @return list
     */
    List<Modle> queryModleList(Integer projectId);
    /**
     * 查询模块列表
     */
    List<Modle> queryModleListByIds(@Param("modleIdList") List<Integer> modleIdList);

    /**
     * 条件查询
     * @param projectId
     * @param modleName
     * @param modleState
     * @return list
     */
    List<Modle> queryModle(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize,
                           @Param("projectId") Integer projectId, @Param("modleName") String modleName, @Param("modleState") String modleState);

}
