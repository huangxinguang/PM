package com.ectrip.controller;

import com.ectrip.base.BaseController;
import com.ectrip.model.Modle;
import com.ectrip.model.ModlePrototype;
import com.ectrip.model.Project;
import com.ectrip.service.ModleService;
import com.ectrip.service.ProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * Created by huangxinguang on 2017/5/19 上午11:23.
 * 项目模块
 */
@Controller
@RequestMapping(value = "/modle")
public class ProjectModleController extends BaseController {
    @Autowired
    private ModleService modleService;

    @Autowired
    private ProjectService projectService;

    /**
     * 项目模块列表
     * @param pageNo
     * @param projectId
     * @param modleName
     * @param modleState
     * @return
     */
    @RequestMapping(value = "/modleList.html",method = RequestMethod.GET)
    public ModelAndView modleList(Integer pageNo, Integer projectId, String modleName, String modleState){
        if(pageNo != null) {
            pageNo = 1;
        }
        ModelAndView mav = getModelAndView();
        PageInfo<Modle> pageInfo = modleService.queryModleList(pageNo,pageSize,projectId,modleName,modleState);
        List<Project> projectList = projectService.queryAllProjectList();
        mav.addObject("pageInfo",pageInfo);
        mav.addObject("modleName",modleName);
        mav.addObject("modleState",modleState);
        mav.addObject("projectList",projectList);
        mav.setViewName("projectModle/projectModleList");
        return mav;
    }

    /**
     * 添加项目模块
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/addModle.html",method = RequestMethod.GET)
    public ModelAndView addModle(Integer projectId){
        ModelAndView mav = getModelAndView();
        List<Project> projectList = projectService.queryAllProjectList();
        mav.addObject("projectList",projectList);
        mav.setViewName("projectModle/addProjectModle");
        return mav;
    }

    /**
     * 编辑模块
     * @param projectId
     * @param modleId
     * @return
     */
    @RequestMapping(value = "/editModle.html",method = RequestMethod.GET)
    public ModelAndView editModle(Integer projectId,Integer modleId){
        ModelAndView mav = getModelAndView();
        Modle modle = modleService.queryModleById(modleId);
        mav.addObject("modle",modle);
        mav.setViewName("projectModle/editProjectModle");
        return mav;
    }

    /**
     * 添加项目模块
     * @return
     */
    @RequestMapping(value = "/saveModle.do",method = RequestMethod.POST)
    public ModelAndView saveModle(@ModelAttribute("modle") Modle modle){
        ModelAndView mav = getModelAndView();
        modleService.saveModle(modle);
        mav.setViewName("redirect:modleList.html");
        return mav;
    }

    /**
     * 删除项目模块
     * @param modleId
     * @return
     */
    @RequestMapping(value = "/delModle.do",method = RequestMethod.GET)
    public String delModle(Integer modleId) {
        modleService.delModle(modleId);
        return "redirect:modleList.html";
    }

}
