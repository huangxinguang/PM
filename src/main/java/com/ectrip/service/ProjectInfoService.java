package com.ectrip.service;

import com.ectrip.model.ProjectInfo;
import com.ectrip.vo.ProjectInfoVO;
import com.github.pagehelper.PageInfo;

/**
 * Created by huangxinguang on 2017/5/19 下午8:58.
 */
public interface ProjectInfoService {

    void saveProjectInfo(ProjectInfo projectInfo);

    void delProjectInfo(Integer projectInfoId);

    void updateProjectInfo(ProjectInfo projectInfo);

    ProjectInfo queryProjectInfoById(Integer projectInfoId);

    PageInfo<ProjectInfoVO> queryProjectInfoListPage(Integer pageNo, Integer pageSize, Integer projectId, String projectName);
}
