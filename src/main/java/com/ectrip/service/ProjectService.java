package com.ectrip.service;

import com.ectrip.model.Project;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by huangxinguang on 2017/4/20 下午2:18.
 * </p>
 * Desc:
 */
public interface ProjectService {
    /**
     * 保存
     * @param project
     */
    void saveProject(Project project,List<Integer> modleIds);

    void updateProject(Project project);

    /**
     * 查询
     * @param projectId
     * @return
     */
    Project queryProject(Integer projectId);

    /**
     * 查询所有项目
     * @return
     */
    List<Project> queryAllProjectList();
    /**
     * 按条件查询操作记录和环境
     *
     * @return
     */
    PageInfo<Project> findProjectListPage(Integer pageNo,Integer pageSize, String projectStatus, String projectName, String projectLeader);

    /**
     * 根据ID删除指定项目
     * @param id
     */
    void deleteProject(Integer id);

}
