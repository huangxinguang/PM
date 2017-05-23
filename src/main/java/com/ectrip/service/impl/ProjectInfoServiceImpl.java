package com.ectrip.service.impl;

import com.ectrip.dao.ProjectInfoDAO;
import com.ectrip.model.ProjectInfo;
import com.ectrip.service.ProjectInfoService;
import com.ectrip.vo.ProjectInfoVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by huangxinguang on 2017/5/19 下午9:04.
 */
@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {

    @Autowired
    private ProjectInfoDAO projectInfoDAO;

    @Transactional
    public void saveProjectInfo(ProjectInfo projectInfo) {
        if(projectInfo.getId() != null) {
            projectInfoDAO.update(projectInfo);
        }else {
            projectInfoDAO.save(projectInfo);
        }
    }

    @Override
    public void delProjectInfo(Integer projectInfoId) {
       projectInfoDAO.delete(projectInfoId);
    }

    @Override
    public void updateProjectInfo(ProjectInfo projectInfo) {
        projectInfoDAO.update(projectInfo);
    }

    @Override
    public ProjectInfo queryProjectInfoById(Integer projectInfoId) {
        return projectInfoDAO.find(projectInfoId);
    }

    @Override
    public PageInfo<ProjectInfoVO> queryProjectInfoListPage(Integer pageNo, Integer pageSize, Integer projectId, String projectName) {
        List<ProjectInfoVO> list = projectInfoDAO.findProjectInfoListPage(pageNo,pageSize,projectId,projectName);
        return new PageInfo<>(list);
    }
}
