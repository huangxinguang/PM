package com.ectrip.service.impl;

import com.ectrip.dao.ModlePrototypeDAO;
import com.ectrip.dao.ProjectDao;
import com.ectrip.dao.ProjectInfoDAO;
import com.ectrip.model.ModlePrototype;
import com.ectrip.model.Project;
import com.ectrip.model.ProjectInfo;
import com.ectrip.service.ModlePrototypeService;
import com.ectrip.service.ProjectService;
import com.ectrip.utils.DateUtil;
import com.ectrip.vo.ProjectInfoVO;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by huangxinguang on 2017/5/11.
 */
@Service
public class ModlePrototypeServiceImpl implements ModlePrototypeService {

    @Autowired
    ModlePrototypeDAO modlePrototypeDAO;

    @Override
    public PageInfo<ModlePrototype> findModlePrototypeListPage(Integer pageNo, Integer pageSize, String modlePrototypeName) {
        List<ModlePrototype> list = modlePrototypeDAO.findModlePrototypeListPage(pageNo, pageSize, modlePrototypeName);
        return new PageInfo<>(list);
    }


    @Override
    public void saveModlePrototype(ModlePrototype modlePrototype) {
        modlePrototype.setOperateTime(DateUtil.getDateTime(new Date()));
        if(modlePrototype.getId() == null){
            modlePrototypeDAO.saveModlePrototype(modlePrototype);
        }else{
            modlePrototypeDAO.updateModlePrototype(modlePrototype);
        }
    }

    @Override
    public void delModlePrototype(Integer modelProId) {
        modlePrototypeDAO.delModlePrototype(modelProId);
    }

    public ModlePrototype findModlePrototypeById(Integer id) {
        return modlePrototypeDAO.findModlePrototype(id);
    }

    @Override
    public List<ModlePrototype> findAllModlePrototypeList() {
        return modlePrototypeDAO.findAllModlePrototypeList();
    }

}
