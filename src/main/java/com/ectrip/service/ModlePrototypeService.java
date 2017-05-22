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
    /**
     * 查询列表
     * @param pageNo
     * @param pageSize
     * @param modlePrototypeName
     * @return
     */
    PageInfo<ModlePrototype> findModlePrototypeListPage(Integer pageNo, Integer pageSize, String modlePrototypeName);

    /**
     * 保存模型
     * @param modlePrototype
     */
    void saveModlePrototype(ModlePrototype modlePrototype);

    /**
     * 删除模块
     * @param modelProId
     */
    void delModlePrototype(Integer modelProId);

    /**
     * 查询通过id
     * @param id
     * @return
     */
    ModlePrototype findModlePrototypeById(Integer id);

    /**
     * 获取所有模块原型
     * @return
     */
    List<ModlePrototype> findAllModlePrototypeList();

}
