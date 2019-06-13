package net.jikuodong.spring.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import net.jikuodong.spring.controller.base.BaseController;
import net.jikuodong.spring.po.User;
import net.jikuodong.spring.service.user.UserService;
import net.jikuodong.spring.utils.CommonUtils;
import net.jikuodong.spring.utils.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * describe 用户信息Controller层
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName UserController.java
 * @createTime 2019年06月05日 15:22:00
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("test")
    public ModelAndView test() {
        logBefore(logger, "测试ssm");
        PageData pd = this.getPageData();
        ModelAndView mv = new ModelAndView();
        // User user = userService.getResult();
       // mv.addObject("user", user);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("getUser")
    public @ResponseBody Object getUser(){
        logBefore(logger, "获取用户集合");
        PageData pageData  = this.getPageData();
        int limit = CommonUtils.toInt(pageData.get("limit")); // 页码显示列数
        int offset = CommonUtils.toInt(pageData.get("offset")); // 页码
        PageInfo pageInfo = userService.getResult(offset, limit);
        Map map = new HashMap();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }
}
