package com.ectrip.dao;

import com.ectrip.model.Modle;
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
    int saveModle(Modle modle);

    /**
     * 更新模块
     * @param modle
     * @return int
     */
    int updateModle(Modle modle);

    /**
     * 查找指定项目的模块列表
     * @param projectId
     * @return list
     */
    List<Modle> queryModleList(Integer projectId);

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
