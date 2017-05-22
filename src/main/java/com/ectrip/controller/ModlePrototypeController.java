package com.ectrip.controller;

import com.ectrip.base.BaseController;
import com.ectrip.model.ModlePrototype;
import com.ectrip.service.ModlePrototypeService;
import com.ectrip.utils.DateUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.DateUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangxinguang on 2017/5/11.
 */
@Controller
@RequestMapping(value = "/modlePro")
public class ModlePrototypeController extends BaseController {

    @Autowired
    private ModlePrototypeService modlePrototypeService;

    /**
     * 模块列表
     * @param pageNo
     * @param modlePrototypeName
     * @return
     */
    @RequestMapping(value = "/modleProList.html", method = RequestMethod.GET)
    public ModelAndView modelProList(Integer pageNo, String modlePrototypeName) {
        if (pageNo == null) {
            pageNo = 1;
        }
        ModelAndView mav = getModelAndView();
        PageInfo<ModlePrototype> pageInfo = modlePrototypeService.findModlePrototypeListPage(pageNo, pageSize, modlePrototypeName);
        mav.addObject("pageInfo",pageInfo);
        mav.addObject("modlePrototypeName",modlePrototypeName);
        mav.setViewName("modle/modleProList");
        return mav;
    }

    /**
     * 添加模块页面
     * @return
     */
    @RequestMapping(value = "/addModlePro.html",method = RequestMethod.GET)
    public String addModleProPage() {
        return "modle/addModlePro";
    }

    /**
     * 编辑模块页面
     * @return
     */
    @RequestMapping(value = "/editModlePro.html",method = RequestMethod.GET)
    public ModelAndView editModleProPage(Integer modleProId) {
        ModelAndView mav = getModelAndView();
        ModlePrototype modlePro = modlePrototypeService.findModlePrototypeById(modleProId);
        mav.addObject("modlePro",modlePro);
        mav.setViewName("modle/editModlePro");
        return mav;
    }

    /**
     * 保存模块
     * @return
     */
    @RequestMapping(value = "/saveModlePro.do",method = RequestMethod.POST)
    public String addModlePro(@ModelAttribute("modlePrototype") ModlePrototype modlePrototype) {
        modlePrototypeService.saveModlePrototype(modlePrototype);
        return "redirect:modleProList.html";
    }

    /**
     * 删除模块
     * @return
     */
    @RequestMapping(value = "/delModlePro.do",method = RequestMethod.GET)
    public String delModlePro(Integer modleProId) {
        modlePrototypeService.delModlePrototype(modleProId);
        return "redirect:modleProList.html";
    }

}
