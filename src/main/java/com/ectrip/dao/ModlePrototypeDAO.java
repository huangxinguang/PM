package com.ectrip.dao;

import com.ectrip.base.BaseDAO;
import com.ectrip.model.ModlePrototype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huangxinguang on 2017/5/12 0012.
 */
public interface ModlePrototypeDAO extends BaseDAO<ModlePrototype>{

    List<ModlePrototype> findModlePrototypeListPage(@Param("pageNum") Integer pageNo, @Param("pageSize") Integer pageSize, @Param("modlePrototypeName") String modlePrototypeName);

    List<ModlePrototype> findAllModlePrototypeList();

    List<ModlePrototype> findModlePrototypeList(@Param("mids")List<Integer> mids);
}
