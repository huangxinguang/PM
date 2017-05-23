package com.ectrip.service;

import com.ectrip.model.Demand;
import com.ectrip.vo.DemandVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by huangxinguang on 2017/5/22 上午9:29.
 */
public interface DemandService {

    /**
     * 需求列表
     * @param pageNo
     * @param pagesSize
     * @param projectId
     * @param projectName
     * @param demandName
     * @return
     */
    PageInfo<DemandVO> queryDemandListPage(Integer pageNo, Integer pagesSize, Integer projectId, String projectName, String demandName);

    /**
     * 发起一个需求
     * @param demand
     * @param modleIdList
     */
    void saveDemand(Demand demand, List<Integer> modleIdList);

    /**
     * 更新需求
     */
    void updateDemand(Demand demand,List<Integer> modleIdList);

    /**
     * 查询
     * @param demandId
     * @return
     */
    Demand queryDemand(Integer demandId);

    void delDemand(Integer demandId);

    /**
     * 完成需求
     * @param demand
     */
    void completeDemand(Demand demand);
}
