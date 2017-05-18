package com.ectrip.controller;

import com.ectrip.base.BaseController;
import com.ectrip.base.Page;
import com.ectrip.model.ModlePrototype;
import com.ectrip.model.Project;
import com.ectrip.service.ModlePrototypeService;
import com.ectrip.service.ProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


/**
 * Created by 23626 on 2017/5/11.
 */
@Controller
@RequestMapping(value = "/project")
public class ProjectController extends BaseController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ModlePrototypeService modlePrototypeService;

    @RequestMapping(value = "/projectList.html",method = RequestMethod.GET)
    public ModelAndView projectList(Integer pageNo,String projectStatus,String projectName,String projectLeader) {
        ModelAndView mav = getModelAndView();
        if(pageNo == null) {
            pageNo = 1;
        }
        int pageSize = 10;
        PageInfo<Project> pageInfo = projectService.findProjectListPage(pageNo,pageSize,projectStatus,projectName,projectLeader);
        mav.addObject("pageInfo",pageInfo);
        mav.addObject("projectStatus",projectStatus);
        mav.addObject("projectName",projectName);
        mav.addObject("projectLeader",projectLeader);
        mav.setViewName("projectList");
        return mav;
    }

    @RequestMapping(value = "/saveProject",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView saveProject(Integer id,String projectName, String projectLeader, String phone, String qq, String email, String projectStatus){
        ModelAndView mav = getModelAndView();
        try{
        projectService.saveProject(id,projectName, projectLeader, phone, qq, email, projectStatus);
            mav.setViewName("project/projectList");
        }catch (Exception e){
            e.printStackTrace();
            mav.setViewName("project/addProject");
        }
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/addProject", method = {RequestMethod.GET,RequestMethod.POST})
    public Object modlePrototypeList(Integer id) {
        ModelAndView mav = getModelAndView();
        List<ModlePrototype> list = modlePrototypeService.queryModlePrototype();
        Project project = projectService.queryProject(id);
        mav.addObject("project",project);
        mav.addObject("list", list);
        mav.setViewName("project/addProject");
        return mav;
    }
}
