package com.ectrip.dao;

import com.ectrip.model.ProjectInfo;
import com.ectrip.vo.ProjectInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/11 0011.
 */
public interface ProjectInfoDAO {

    List<ProjectInfoVO> findProjectInfoListPage(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize, @Param("projectName") String projectName);

    void saveProjectInfo(ProjectInfo projectInfo);

    void updateProjectInfo(ProjectInfo projectInfo);

    ProjectInfo findProjectInfoByProjectId(@Param("projectId") Integer projectId);
}