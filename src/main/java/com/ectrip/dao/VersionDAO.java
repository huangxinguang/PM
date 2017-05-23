package com.ectrip.dao;

import com.ectrip.base.BaseDAO;
import com.ectrip.model.Version;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
public interface VersionDAO extends BaseDAO<Version> {

    /**
     * 批量保存版本
     * @param versionList
     */
    void batchSave(@Param("versionList")List<Version> versionList);

    /**
     * 通过需求id 查询版本
     * @param demandId
     * @return
     */
    List<Version> queryVersionList(Integer demandId);

    /**
     * 查看模块版本列表
     * @param modleId
     * @return
     */
    List<Version> queryModleVersionList(@Param("pageNum")Integer pageNo,@Param("pageSize")Integer pageSize,@Param("modleId") Integer modleId);

    /**
     * 批量更新版本状态
     * @param versionList
     */
    void batchUpdateState(@Param("versionList")List<Version> versionList);
}
