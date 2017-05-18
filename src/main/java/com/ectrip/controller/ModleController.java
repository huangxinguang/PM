package com.ectrip.controller;

import com.ectrip.base.BaseController;
import com.ectrip.model.Modle;
import com.ectrip.model.ModlePrototype;
import com.ectrip.service.ModleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoaijin on 2017/5/16 0016.
 */
@Controller
@RequestMapping(value = "/modle")
public class ModleController extends BaseController {

    @Autowired
    private ModleService modleService;

    @ResponseBody
    @RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
    public Object modleList(Integer offset,Integer limit,Integer projectId,String modleName,String modleState){
        int pageNo = 1;
        if(offset != null) {
            pageNo = (offset/limit+1);
        }
        PageInfo<Modle> pageInfo = modleService.queryModleList(pageNo,limit,projectId,modleName,modleState);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("rows",pageInfo.getList());
        result.put("total",pageInfo.getTotal());
        return result;
    }

    @RequestMapping(value = "/saveModle",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView saveModle(Integer projectId, @RequestParam("mpid")String[] a){
        ModelAndView mav = getModelAndView();
        for (int i = 0; i < a.length; i++){
            modleService.saveModle(projectId,Integer.parseInt(a[i]));
        }
        mav.setViewName("modle/modleList");
        return mav;
    }

    @RequestMapping(value = "/addModle",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView addModle(Integer projectId){
        ModelAndView mav = getModelAndView();
        List<ModlePrototype> modlePrototypeList = modleService.findModlePrototypeList(projectId);
        if (modlePrototypeList.isEmpty()){
            mav.addObject("msg","模块原型已全部添加至项目模块中。如还想添加，请先添加模块到模块原型中！！！");
            return mav;
        }
        mav.addObject("list",modlePrototypeList);
        mav.setViewName("modle/addModle");
        return mav;
    }

}
