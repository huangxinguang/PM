package com.ectrip.dao;

import com.ectrip.model.ModlePrototype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huangxinguang on 2017/5/12 0012.
 */
public interface ModlePrototypeDAO {

    List<ModlePrototype> queryModlePrototype();

    List<ModlePrototype> findModlePrototypeListPage(@Param("pageNum") Integer pageNo, @Param("pageSize") Integer pageSize, @Param("modlePrototypeName") String modlePrototypeName);

    void saveModlePrototype(ModlePrototype modlePrototype);

    void delModlePrototype(@Param("id") Integer id);

    void updateModlePrototype(ModlePrototype modlePrototype);

    ModlePrototype findModlePrototype(@Param("id") Integer id);

    List<ModlePrototype> findAllModlePrototypeList();

    List<ModlePrototype> findModlePrototypeList(@Param("mids")List<Integer> mids);
}
