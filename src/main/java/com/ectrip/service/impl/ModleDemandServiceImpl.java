package com.ectrip.service.impl;

import com.ectrip.dao.ModleDemandDAO;
import com.ectrip.model.ModleDemand;
import com.ectrip.service.ModleDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangxinguang on 2017/5/22 下午2:50.
 */

@Service
public class ModleDemandServiceImpl implements ModleDemandService {

    @Autowired
    private ModleDemandDAO modleDemandDAO;

    @Override
    public List<ModleDemand> findModleDemandList(Integer demandId) {
        return modleDemandDAO.findModleDemandList(demandId);
    }
}
