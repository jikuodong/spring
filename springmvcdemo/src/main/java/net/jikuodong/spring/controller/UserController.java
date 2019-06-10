package net.jikuodong.spring.controller;

import net.jikuodong.spring.controller.base.BaseController;
import net.jikuodong.spring.po.User;
import net.jikuodong.spring.service.user.UserService;
import net.jikuodong.spring.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;

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
        User user = userService.getResult();
        mv.setViewName("success");
        return mv;
    }
}
