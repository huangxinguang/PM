package com.ectrip.service.impl;

import com.ectrip.dao.ProjectInfoDAO;
import com.ectrip.model.ProjectInfo;
import com.ectrip.service.ProjectInfoService;
import com.ectrip.vo.ProjectInfoVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangxinguang on 2017/5/19 下午9:04.
 */
@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {

    @Autowired
    private ProjectInfoDAO projectInfoDAO;

    @Override
    public void saveProjectInfo(ProjectInfo projectInfo) {
        if(projectInfo.getId() != null) {
            projectInfoDAO.updateProjectInfo(projectInfo);
        }else {
            projectInfoDAO.saveProjectInfo(projectInfo);
        }
    }

    @Override
    public void delProjectInfo(Integer projectInfoId) {
       projectInfoDAO.delProjectInfo(projectInfoId);
    }

    @Override
    public void updateProjectInfo(ProjectInfo projectInfo) {
        projectInfoDAO.updateProjectInfo(projectInfo);
    }

    @Override
    public ProjectInfo queryProjectInfoById(Integer projectInfoId) {
        return projectInfoDAO.findProjectInfo(projectInfoId);
    }

    @Override
    public PageInfo<ProjectInfoVO> queryProjectInfoListPage(Integer pageNo, Integer pageSize, Integer projectId, String projectName) {
        List<ProjectInfoVO> list = projectInfoDAO.findProjectInfoListPage(pageNo,pageSize,projectId,projectName);
        return new PageInfo<>(list);
    }
}
