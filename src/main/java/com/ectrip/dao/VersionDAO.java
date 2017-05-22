package com.ectrip.dao;

import com.ectrip.model.Version;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
public interface VersionDAO {

    /**
     * 批量保存版本
     * @param versionList
     */
    void batchSave(@Param("versionList")List<Version> versionList);
}
