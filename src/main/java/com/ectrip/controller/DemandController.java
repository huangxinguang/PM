package com.ectrip.controller;

import com.ectrip.base.BaseController;
import com.ectrip.model.Demand;
import com.ectrip.model.Modle;
import com.ectrip.model.ModleDemand;
import com.ectrip.model.Project;
import com.ectrip.service.*;
import com.ectrip.utils.DateUtil;
import com.ectrip.vo.DemandVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by huangxinguang on 2017/5/19 下午9:54.
 */
@Controller
@RequestMapping("/demand")
public class DemandController extends BaseController {

    @Autowired
    private DemandService demandService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ModleDemandService modleDemandService;

    @Autowired
    private ModleService modleService;

    /**
     * 需求列表
     * @param pageNo
     * @param projectId
     * @param projectName
     * @param demandName
     * @return
     */
    @RequestMapping(value = "/demandList",method = RequestMethod.GET)
    public ModelAndView demandList(Integer pageNo,Integer projectId,String projectName,String demandName) {
        ModelAndView mav = getModelAndView();
        PageInfo<DemandVO> pageInfo = demandService.queryDemandListPage(pageNo,pageSize,projectId,projectName,demandName);
        List<Project> projectList = projectService.queryAllProjectList();
        mav.addObject("pageInfo",pageInfo);
        mav.addObject("projectList",projectList);
        mav.setViewName("demand/demandList");
        return mav;
    }

    /**
     * 添加需求
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/addDemand.html",method = RequestMethod.GET)
    public ModelAndView addDemandPage(Integer projectId) {
        ModelAndView mav = getModelAndView();
        List<Modle> modleList = modleService.findProjectModleList(projectId);
        mav.addObject("modleList",modleList);
        mav.addObject("projectId",projectId);
        mav.setViewName("demand/addDemand");
        return mav;
    }

    /**
     * 编辑需求页面
     * @param demandId
     * @return
     */
    @RequestMapping(value = "/editDemand.html",method = RequestMethod.GET)
    public ModelAndView editDemandPage(Integer demandId){
        ModelAndView mav = getModelAndView();

        //组装modleIdList
        List<ModleDemand> modleDemandList = modleDemandService.findModleDemandList(demandId);
        List<Integer> modleIdList = new ArrayList<>();
        modleIdList.add(0);
        for(ModleDemand modleDemand:modleDemandList) {
            modleIdList.add(modleDemand.getModleId());
        }

        List<Modle> modleList = modleService.queryModleList(modleIdList);
        Demand demand = demandService.queryDemand(demandId);
        mav.addObject("modleList",modleList);
        mav.addObject("demand",demand);
        mav.setViewName("demand/editDemand");
        return mav;
    }

    /**
     * 编辑需求
     * @param demand
     * @return
     */
    @RequestMapping(value = "/editDemand.do",method = RequestMethod.POST)
    public ModelAndView editDemandPage(@ModelAttribute("demand") Demand demand){
        ModelAndView mav = getModelAndView();
        demandService.updateDemand(demand);
        mav.setViewName("redirect:demandList.html");
        return mav;
    }

    /**
     * 发起需求
     * @param projectId
     * @param mids
     * @param demand
     * @return
     */
    @RequestMapping(value = "/addDemand.do",method = RequestMethod.POST)
    public ModelAndView saveDemand(@RequestParam("projectId") Integer projectId, @RequestParam("mids") String[] mids, @ModelAttribute("demand")Demand demand) {
        ModelAndView mav = getModelAndView();
        List<Integer> modleIdList = new ArrayList<>();
        for(String mid:mids) {
            modleIdList.add(Integer.valueOf(mid));
        }
        demand.setProjectId(projectId);
        demandService.saveDemand(demand,modleIdList);
        mav.setViewName("redirect:demandList.html");
        return mav;
    }

    @RequestMapping(value = "/completeDemand.html",method = RequestMethod.GET)
    public ModelAndView completeDemandPage(Integer demandId) {
        ModelAndView mav = getModelAndView();
        mav.addObject("demandId",demandId);
        mav.addObject("userName",getCurrentUser());
        mav.addObject("currentDateTime", DateUtil.getDateTime(new Date()));
        mav.setViewName("demand/completeDemand");
        return mav;
    }

    /**
     * 完成需求
     * @param demand
     * @return
     */
    @RequestMapping(value = "/completeDemand.do",method = RequestMethod.POST)
    public ModelAndView completeDemand(@ModelAttribute("demand") Demand demand) {
        ModelAndView mav = getModelAndView();
        demandService.completeDemand(demand);
        mav.setViewName("redirect:demandList.html");
        return mav;
    }

    /**
     * 删除需求
     * @param demandId
     * @return
     */
    @RequestMapping(value = "/delDemand.do",method = RequestMethod.GET)
    public ModelAndView delDemand(Integer demandId) {
        ModelAndView mav = getModelAndView();
        demandService.delDemand(demandId);
        mav.setViewName("redirect:demandList.html");
        return mav;
    }
}
