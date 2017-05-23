package com.ectrip.dao;

import com.ectrip.base.BaseDAO;
import com.ectrip.model.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huangxinguang on 2017/5/11.
 */
public interface ProjectDao extends BaseDAO<Project>{

    List<Project> findAllProjectList();

    List<Project> findProjectListPage(@Param("pageNum") Integer pageNo, @Param("pageSize") Integer pageSize,@Param("projectStatus") String projectStatus, @Param("projectName") String projectName, @Param("projectLeader") String projectLeader);
}
