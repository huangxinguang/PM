package com.ectrip.service;

import com.ectrip.base.Page;
import com.ectrip.model.Project;
import com.ectrip.model.ProjectInfo;
import com.ectrip.vo.ProjectInfoVO;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huangxinguang on 2017/4/20 下午2:18.
 * </p>
 * Desc:
 */
public interface ProjectService {

    void saveProject(Integer id, String projectName, String projectLeader, String phone, String QQ, String email, String projectStatus);
    void saveProjectInfo(Integer id, Integer projectId, String serverIp, String dbServerIp, String dbUserId, String dbPwd, Integer dbPort, String hostName, String SSH);
    Project queryProject(Integer projectId);
    ProjectInfo queryProjectInfo(Integer projectId);
    /**
     * 按条件查询操作记录和环境
     *
     * @return
     */
    PageInfo<Project> findProjectListPage(Integer pageNo,Integer pageSize, String projectStatus, String projectName, String projectLeader);

    PageInfo<ProjectInfoVO> findProjectInfoListPage(Integer pageNo, Integer pageSize, String projectName);


}
