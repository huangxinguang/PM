package com.ectrip.dao;

import com.ectrip.base.BaseDAO;
import com.ectrip.model.Demand;
import com.ectrip.vo.DemandVO;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huangxinguang on 2017/5/17 0017.
 */
public interface DemandDAO extends BaseDAO<Demand>{
    /**
     * 需求列表
     * @param pageNo
     * @param pagesSize
     * @param projectId
     * @param projectName
     * @param demandName
     * @return
     */
    List<DemandVO> findDemandListPage(@Param("pageNum") Integer pageNo, @Param("pageSize") Integer pagesSize, @Param("projectId") Integer projectId,
                                      @Param("projectName") String projectName, @Param("demandName") String demandName);
}
