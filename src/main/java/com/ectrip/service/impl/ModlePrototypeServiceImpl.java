package com.ectrip.service.impl;

import com.ectrip.dao.ModlePrototypeDAO;
import com.ectrip.dao.ProjectDao;
import com.ectrip.dao.ProjectInfoDAO;
import com.ectrip.model.ModlePrototype;
import com.ectrip.model.Project;
import com.ectrip.model.ProjectInfo;
import com.ectrip.service.ModlePrototypeService;
import com.ectrip.service.ProjectService;
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
 * Created by 23626 on 2017/5/11.
 */
@Service
public class ModlePrototypeServiceImpl implements ModlePrototypeService {

    @Autowired
    ModlePrototypeDAO modlePrototypeDAO;

    private Logger logger = LoggerFactory.getLogger(ModlePrototypeServiceImpl.class);

    @Override
    public PageInfo<ModlePrototype> findModlePrototypeListPage(Integer pageNo, Integer pageSize, String modlePrototypeName) {
        List<ModlePrototype> list = modlePrototypeDAO.findModlePrototypeListPage(pageNo, pageSize, modlePrototypeName);
        logger.info("查询数据:{}", list.toString());
        return new PageInfo<>(list);
    }

    @Override
    public List<ModlePrototype> queryModlePrototype() {
        List<ModlePrototype> list = modlePrototypeDAO.queryModlePrototype();
        logger.info("查询数据:{}", list.toString());
        return list;
    }

    @Override
    public void saveModlePrototype(Integer id, String modlePrototypeName, String modlePrototypeDescribe) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ModlePrototype modlePrototype = new ModlePrototype();
        modlePrototype.setModlePrototypeName(modlePrototypeName);
        modlePrototype.setModlePrototypeDescribe(modlePrototypeDescribe);
        modlePrototype.setOperateTime(sdf.format(new Date()));
        if(id == null){
            modlePrototypeDAO.saveModlePrototype(modlePrototype);
        }else{
            modlePrototype.setId(id);
            modlePrototypeDAO.updateModlePrototype(modlePrototype);
        }
    }

    @Override
    public ModlePrototype findModlePrototype(Integer id) {
        return modlePrototypeDAO.findModlePrototype(id);
    }
}
