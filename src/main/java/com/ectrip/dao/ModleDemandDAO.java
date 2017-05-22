package com.ectrip.dao;

import com.ectrip.model.ModleDemand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huangxinguang on 2017/5/17 0017.
 */
public interface ModleDemandDAO {
    /**
     * 批量保存
     * @param modleDemandList
     */
    void batchSave(@Param("modleDemandList") List<ModleDemand> modleDemandList);

    /**
     * 通过需求id查询模块列表
     * @param demandId
     * @return
     */
    List<ModleDemand> findModleDemandList(@Param("demandId")Integer demandId);
}
