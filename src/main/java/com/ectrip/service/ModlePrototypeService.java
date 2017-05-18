package com.ectrip.service;

import com.ectrip.model.ModlePrototype;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by huangxinguang on 2017/4/20 下午2:18.
 * </p>
 * Desc:
 */
public interface ModlePrototypeService {

    PageInfo<ModlePrototype> findModlePrototypeListPage(Integer pageNo, Integer pageSize, String modlePrototypeName);

    List<ModlePrototype> queryModlePrototype();

    void saveModlePrototype(Integer id, String modlePrototypeName, String modlePrototypeDescribe);

    ModlePrototype findModlePrototype(Integer id);
}
