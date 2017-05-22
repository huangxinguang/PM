package com.ectrip.service.impl;

import com.ectrip.dao.ModleDAO;
import com.ectrip.dao.ModlePrototypeDAO;
import com.ectrip.model.Modle;
import com.ectrip.model.ModlePrototype;
import com.ectrip.service.ModleService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/5/16 0016.
 */
@Service
public class ModleServiceImpl implements ModleService {

    @Autowired
    private ModleDAO modleDAO;

    @Autowired
    private ModlePrototypeDAO modlePrototypeDAO;

    /**
     * 新增项目模块
     */
    public void saveModle(Modle modle){
        if(modle.getId() != null) {
            modleDAO.updateModle(modle);
        }else {
            modleDAO.saveModle(modle);
        }
    }

    @Override
    public Modle queryModleById(Integer modleId) {
        return modleDAO.queryModleById(modleId);
    }

    @Override
    public List<Modle> queryModleList(List<Integer> modleIdList) {
        return modleDAO.queryModleListByIds(modleIdList);
    }

    /**
     * 修改项目模块
     * @param modle
     */
    public void updateModle(Modle modle){
        modleDAO.updateModle(modle);
    }

    @Override
    public void delModle(Integer id) {
        modleDAO.delModle(id);
    }

    /**
     * 项目模块分页条件查询
     * @param pageNo
     * @param pageSize
     * @param projectId
     * @param modleName
     * @param modleState
     * @return pageInfo
     */
    public PageInfo<Modle> queryModleList(Integer pageNo, Integer pageSize, Integer projectId, String modleName, String modleState){
        List<Modle> list = modleDAO.queryModle(pageNo,pageSize,projectId,modleName,modleState);
        return new PageInfo<>(list);
    }

    /**
     * 获取项目模块列表
     * @param projectId
     * @return list
     */
    public List<Modle> findProjectModleList(Integer projectId){
        return modleDAO.queryModleList(projectId);
    }

}
