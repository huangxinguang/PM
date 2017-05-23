package com.ectrip.dao;

import com.ectrip.base.BaseDAO;
import com.ectrip.model.Modle;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
public interface ModleDAO extends BaseDAO<Modle>{

    /**
     * 批量插入
     * @param modleList
     * @return
     */
    void batchSave(@Param("modleList") List<Modle> modleList);


    void batchUpdateState(@Param("modleList") List<Modle> modleList);


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
