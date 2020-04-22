package com.cyf.billmanger.Controller;

import com.cyf.billmanger.Service.UserService;
import com.cyf.billmanger.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletRequest request,
                        Map map){
        User user = userService.login(username,password);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            return "redirect:/index";
        }else{
            map.put("msg","用户名或密码错误，请重新登录");
            return "main/login";
        }
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/toLogin";
    }
}
