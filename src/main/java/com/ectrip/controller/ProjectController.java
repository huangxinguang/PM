package com.ectrip.controller;

import com.ectrip.base.BaseController;
import com.ectrip.model.Modle;
import com.ectrip.model.ModlePrototype;
import com.ectrip.model.Project;
import com.ectrip.service.ModlePrototypeService;
import com.ectrip.service.ModleService;
import com.ectrip.service.ProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by huangxinguang on 2017/5/11.
 */
@Controller
@RequestMapping(value = "/project")
public class ProjectController extends BaseController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ModlePrototypeService modlePrototypeService;

    @Autowired
    private ModleService modleService;

    /**
     * 项目列表页面
     * @param pageNo 当前页
     * @param projectStatus 项目状态
     * @param projectName 项目名称
     * @param projectLeader 项目负责人
     * @return
     */
    @RequestMapping(value = "/projectList.html",method = RequestMethod.GET)
    public ModelAndView projectList(Integer pageNo,String projectStatus,String projectName,String projectLeader) {
        ModelAndView mav = getModelAndView();
        if(pageNo == null) {
            pageNo = 1;
        }
        PageInfo<Project> pageInfo = projectService.findProjectListPage(pageNo,pageSize,projectStatus,projectName,projectLeader);
        mav.addObject("pageInfo",pageInfo);
        mav.addObject("projectStatus",projectStatus);
        mav.addObject("projectName",projectName);
        mav.addObject("projectLeader",projectLeader);
        mav.setViewName("project/projectList");
        return mav;
    }

    /**
     * 添加项目页面
     * @return
     */
    @RequestMapping(value = "/addProject.html",method = RequestMethod.GET)
    public ModelAndView addProjectPage() {
        ModelAndView mav = getModelAndView();
        List<ModlePrototype> modlePrototypeList =  modlePrototypeService.findAllModlePrototypeList();
        mav.addObject("modlePrototypeList",modlePrototypeList);
        mav.setViewName("project/addProject");
        return mav;
    }

    /**
     * 编辑项目页面
     * @return
     */
    @RequestMapping(value = "/editProject.html",method = RequestMethod.GET)
    public ModelAndView editProjectPage(Integer projectId) {
        ModelAndView mav = getModelAndView();
        Project project = projectService.queryProject(projectId);
        List<Modle> modleList = modleService.findProjectModleList(projectId);
        mav.addObject("project",project);
        mav.addObject("modleList",modleList);
        mav.setViewName("project/editProject");
        return mav;
    }

    /**
     * 保存项目
     * @param project
     * @return
     */
    @RequestMapping(value = "/saveProject.do",method = RequestMethod.POST)
    public ModelAndView saveProject(@ModelAttribute("project") Project project,@RequestParam("mids") String[] mids) {
        ModelAndView mav = getModelAndView();
        List<Integer> modelIdList = new ArrayList<>();
        for(String mid:mids) {
            modelIdList.add(Integer.valueOf(mid));
        }
        projectService.saveProject(project,modelIdList);
        mav.setViewName("redirect:projectList.html");
        return mav;
    }

    /**
     * 更新项目
     * @param project
     * @return
     */
    @RequestMapping(value = "/updateProject.do",method = RequestMethod.POST)
    public ModelAndView updateProject(@ModelAttribute("project") Project project) {
        ModelAndView mav = getModelAndView();
        projectService.updateProject(project);
        mav.setViewName("redirect:projectList.html");
        return mav;
    }


    /**
     * 删除项目
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/delProject.do",method = RequestMethod.GET)
    public String delProject(Integer projectId) {
        projectService.deleteProject(projectId);
        return "redirect:projectList.html";
    }


}
