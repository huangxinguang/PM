package com.ectrip.controller;

import com.ectrip.base.BaseController;
import com.ectrip.model.Project;
import com.ectrip.model.ProjectInfo;
import com.ectrip.service.ProjectInfoService;
import com.ectrip.service.ProjectService;
import com.ectrip.vo.ProjectInfoVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by huangxinguang on 2017/5/19 下午8:56.
 */
@Controller
@RequestMapping(value = "/projectInfo")
public class ProjectInfoController extends BaseController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectInfoService projectInfoService;

    /**
     * 项目配置信息列表
     * @param pageNo
     * @param projectId
     * @param projectName
     * @return
     */
    @RequestMapping(value = "/projectInfoList.html",method = RequestMethod.GET)
    public ModelAndView projectInfoList(Integer pageNo, Integer projectId, String projectName){
        if(pageNo != null) {
            pageNo = 1;
        }
        ModelAndView mav = getModelAndView();
        PageInfo<ProjectInfoVO> pageInfo = projectInfoService.queryProjectInfoListPage(pageNo,pageSize,projectId,projectName);
        List<Project> projectList = projectService.queryAllProjectList();
        mav.addObject("pageInfo",pageInfo);
        mav.addObject("projectId",projectId);
        mav.addObject("projectName",projectName);
        mav.addObject("projectList",projectList);
        mav.setViewName("projectInfo/projectInfoList");
        return mav;
    }

    /**
     * 添加项目配置信息
     * @return
     */
    @RequestMapping(value = "/addProjectInfo.html",method = RequestMethod.GET)
    public ModelAndView addProjectInfo(){
        ModelAndView mav = getModelAndView();
        List<Project> projectList = projectService.queryAllProjectList();
        mav.addObject("projectList",projectList);
        mav.setViewName("projectInfo/addProjectInfo");
        return mav;
    }

    /**
     * 保存项目配置信息
     * @param projectInfo
     * @return
     */
    @RequestMapping(value = "/saveProjectInfo.do",method = RequestMethod.POST)
    public String addProjectInfo(@ModelAttribute("projectInfo") ProjectInfo projectInfo){
        projectInfoService.saveProjectInfo(projectInfo);
        return "redirect:projectInfoList.html";
    }

    /**
     * 编辑项目配置信息
     * @param projectInfoId
     * @return
     */
    @RequestMapping(value = "/editProjectInfo.html",method = RequestMethod.GET)
    public ModelAndView editProjectInfo(Integer projectInfoId){
        ModelAndView mav = getModelAndView();
        ProjectInfo projectInfo = projectInfoService.queryProjectInfoById(projectInfoId);
        mav.addObject("projectInfo",projectInfo);
        mav.setViewName("projectInfo/editProjectInfo");
        return mav;
    }

    /**
     * 删除项目配置信息
     * @param projectInfoId
     * @return
     */
    @RequestMapping(value = "/delProjectInfo.do",method = RequestMethod.GET)
    public String delModlePro(Integer projectInfoId) {
        projectInfoService.delProjectInfo(projectInfoId);
        return "redirect:projectInfoList.html";
    }


}
