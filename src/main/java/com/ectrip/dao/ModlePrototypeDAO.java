package com.ectrip.dao;

import com.ectrip.model.ModlePrototype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/12 0012.
 */
public interface ModlePrototypeDAO {

    List<ModlePrototype> queryModlePrototype();

    List<ModlePrototype> findModlePrototypeListPage(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize, @Param("modlePrototypeName") String modlePrototypeName);

    void saveModlePrototype(ModlePrototype modlePrototype);

    void updateModlePrototype(ModlePrototype modlePrototype);

    ModlePrototype findModlePrototype(@Param("id") Integer id);
}
