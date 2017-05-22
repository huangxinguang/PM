package com.ectrip.service.impl;

import com.ectrip.dao.DemandDAO;
import com.ectrip.dao.ModleDemandDAO;
import com.ectrip.dao.VersionDAO;
import com.ectrip.model.Demand;
import com.ectrip.model.ModleDemand;
import com.ectrip.model.Version;
import com.ectrip.service.DemandService;
import com.ectrip.utils.DateUtil;
import com.ectrip.vo.DemandVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by huangxinguang on 2017/5/22 上午9:29.
 */
@Service
public class DemandServiceImpl implements DemandService {

    @Autowired
    private ModleDemandDAO modleDemandDAO;

    @Autowired
    private DemandDAO demandDAO;

    @Autowired
    private VersionDAO versionDAO;

    public PageInfo<DemandVO> queryDemandListPage(Integer pageNo,Integer pagesSize,Integer projectId,String projectName,String demandName) {
        List<DemandVO> demandVOList = demandDAO.findDemandListPage(pageNo,pagesSize,projectId,projectName,demandName);
        return new PageInfo<>(demandVOList);
    }


    public void saveDemand(Demand demand,List<Integer> modleIdList) {
        //保存需求
        demand.setDemandStatus("0");
        demand.setPutTime(DateUtil.getDateTime(new Date()));
        demandDAO.saveDemand(demand);

        //组装模块并批量保存
        List<ModleDemand> modleDemandList = new ArrayList<>();
        ModleDemand modleDemand = null;
        for(Integer modleId:modleIdList) {
            modleDemand = new ModleDemand();
            modleDemand.setModleId(modleId);
            modleDemand.setDemandId(demand.getId());
            modleDemandList.add(modleDemand);
        }
        modleDemandDAO.batchSave(modleDemandList);

    }

    @Override
    public void updateDemand(Demand demand, List<Integer> modleIdList) {
        demandDAO.updateDemand(demand);
        //List<ModleDemand> modleDemandList = modleDemandDAO.findModleDemandList(demand.getId());
    }

    @Override
    public Demand queryDemand(Integer demandId) {
        return demandDAO.findDemand(demandId);
    }

    @Override
    public void delDemand(Integer demandId) {
        demandDAO.delDemand(demandId);
    }

    @Override
    public void completeDemand(Demand demand) {
        //修改需求信息
        List<ModleDemand> modleDemandList = modleDemandDAO.findModleDemandList(demand.getId());
        Demand demandOld = demandDAO.findDemand(demand.getId());
        demandOld.setActualEndTime(demand.getActualEndTime());
        demandOld.setCompleteUserId(demand.getCompleteUserId());
        demandDAO.updateDemand(demandOld);


        //组装版本并批量保存
        List<Version> versionList = new ArrayList<>();
        Version version = null;
        for(ModleDemand modleDemand:modleDemandList) {
            version = new Version();
            version.setDemandId(demand.getId());
            version.setModleId(modleDemand.getModleId());
            version.setUpTime(DateUtil.getDateTime(new Date()));
            version.setVersion(demandOld.getVersion());
            version.setUpUserId("admin");
            version.setVersionState(1);
            version.setVersionId(-1);
            versionList.add(version);
        }
        versionDAO.batchSave(versionList);
    }
}
