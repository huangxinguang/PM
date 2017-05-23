package com.ectrip.dao;

import com.ectrip.base.BaseDAO;
import com.ectrip.model.ModleDemand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huangxinguang on 2017/5/17 0017.
 */
public interface ModleDemandDAO extends BaseDAO<ModleDemand>{
    /**
     * 批量保存
     * @param modleDemandList
     */
    void batchSave(@Param("modleDemandList") List<ModleDemand> modleDemandList);

    /**
     * 批量删除
     * @param modleDemandIdList
     */
    void batchDelete(@Param("modleDemandIdList") List<Integer> modleDemandIdList);

    /**
     * 通过需求id查询模块列表
     * @param demandId
     * @return
     */
    List<ModleDemand> findModleDemandList(@Param("demandId")Integer demandId);
}
