package com.ectrip.controller;

import com.ectrip.base.BaseController;
import com.ectrip.model.ModlePrototype;
import com.ectrip.service.ModlePrototypeService;
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
@RequestMapping(value = "/modlePrototype")
public class ModlePrototypeController extends BaseController {

    @Autowired
    private ModlePrototypeService modlePrototypeService;

    @ResponseBody
    @RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
    public Object list(Integer offset, Integer limit, String modlePrototypeName) {
        int pageNo = 1;
        if (offset != null) {
            pageNo = (offset / limit + 1);
        }
        PageInfo<ModlePrototype> pageInfo = modlePrototypeService.findModlePrototypeListPage(pageNo, limit, modlePrototypeName);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("rows", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }

    @RequestMapping(value = "/saveProjectInfo", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView saveProject(Integer id, String modlePrototypeName, String modlePrototypeDescribe) {
        ModelAndView mav = getModelAndView();
        if (id != null) {
            ModlePrototype modlePrototype = modlePrototypeService.findModlePrototype(id);
            mav.addObject("param", modlePrototype);
        }
        if (StringUtils.isEmpty(modlePrototypeName)) {
            mav.addObject("msg", "模块原型名称不能为空");
            mav.setViewName("modle/editModlePrototype");
            return mav;
        }
        if (StringUtils.isEmpty(modlePrototypeDescribe)) {
            mav.addObject("msg", "模块原型描述不能为空");
            mav.setViewName("modle/editModlePrototype");
            return mav;
        }
        try {
            modlePrototypeService.saveModlePrototype(id, modlePrototypeName, modlePrototypeDescribe);
            mav.setViewName("modle/modlePrototypeList");
        } catch (Exception e) {
            e.printStackTrace();
            mav.setViewName("modle/modlePrototypeList");
        }
        return mav;
    }
}
