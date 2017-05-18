package com.ectrip.controller;

import com.ectrip.base.BaseController;
import com.ectrip.model.Project;
import com.ectrip.model.ProjectInfo;
import com.ectrip.service.ProjectService;
import com.ectrip.vo.ProjectInfoVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 23626 on 2017/5/11.
 */
@Controller
@RequestMapping(value = "/projectInfo")
public class ProjectInfoController extends BaseController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/viewProjectInfo",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView viewProjectInfo(Integer id){
        ModelAndView mav = getModelAndView();
        ProjectInfo projectInfo = projectService.queryProjectInfo(id);
        Project project = projectService.queryProject(id);
        mav.addObject("projectInfo",projectInfo);
        mav.addObject("project",project);
        mav.setViewName("/projectInfo/viewProjectInfo");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    public Object list(Integer offset,Integer limit,String projectName) {
        int pageNo = 1;
        if(offset != null) {
            pageNo = (offset/limit+1);
        }
        PageInfo<ProjectInfoVO> pageInfo = projectService.findProjectInfoListPage(pageNo,limit,projectName);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("rows",pageInfo.getList());
        result.put("total",pageInfo.getTotal());
        return result;
    }

    @RequestMapping(value = "/saveProjectInfo",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView saveProject(Integer id,Integer projectId,String serverIp, String dbServerIp, String dbUser, String dbPwd, Integer dbPort, String hostName,String ssh){
        ModelAndView mav = getModelAndView();
        Project project = projectService.queryProject(projectId);
        mav.addObject("project",project);
        if(StringUtils.isEmpty(serverIp)){
            mav.addObject("msg","服务器IP不能为空");
            mav.setViewName("projectInfo/editProjectInfo");
            return mav;
        }
        if(StringUtils.isEmpty(dbServerIp)){
            mav.addObject("msg","数据库IP不能为空");
            mav.setViewName("projectInfo/editProjectInfo");
            return mav;
        }
        if(StringUtils.isEmpty(dbUser)){
            mav.addObject("msg","数据库用户名不能为空");
            mav.setViewName("projectInfo/editProjectInfo");
            return mav;
        }
        if(StringUtils.isEmpty(dbPwd)){
            mav.addObject("msg","数据库密码不能为空");
            mav.setViewName("projectInfo/editProjectInfo");
            return mav;
        }
        if(StringUtils.isEmpty(dbPort)){
            mav.addObject("msg","数据库端口号不能为空");
            mav.setViewName("projectInfo/editProjectInfo");
            return mav;
        }
        if(StringUtils.isEmpty(hostName)){
            mav.addObject("msg","域名不能为空");
            mav.setViewName("projectInfo/editProjectInfo");
            return mav;
        }
        if(StringUtils.isEmpty(ssh)){
            mav.addObject("msg","ssh信息不能为空");
            mav.setViewName("projectInfo/editProjectInfo");
            return mav;
        }
        try{
        projectService.saveProjectInfo(id,projectId,serverIp, dbServerIp, dbUser, dbPwd, dbPort, hostName,ssh);
            mav.setViewName("projectInfo/projectInfoList");
        }catch (Exception e){
            e.printStackTrace();
            mav.setViewName("projectInfo/editProjectInfo");
        }
        return mav;
    }
}
