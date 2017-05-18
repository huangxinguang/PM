package com.ectrip.dao;

import com.ectrip.base.Page;
import com.ectrip.model.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 23626 on 2017/5/11.
 */
public interface ProjectDao {

    Project findProject(@Param("projectId") Integer projectId);

    void save(Project project);

    void updateProject(Project project);

    List<Project> findProjectListPage(@Param("pageNum") Integer pageNo, @Param("pageSize") Integer pageSize,@Param("projectStatus") String projectStatus, @Param("projectName") String projectName, @Param("projectLeader") String projectLeader);
}
