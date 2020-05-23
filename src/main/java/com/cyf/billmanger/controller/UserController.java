package com.cyf.billmanger.controller;

import com.cyf.billmanger.Service.UserService;
import com.cyf.billmanger.dto.UserInfor;
import com.cyf.billmanger.entities.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
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
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
            subject.login(usernamePasswordToken);
        }catch (Exception e){
            map.put("msg","用户名或密码错误，请重新登录");
            return "main/login";
        }
        return "redirect:/index";
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/toLogin";
    }

    @GetMapping("/list")
    public String list(Map map,User user){
        List<UserInfor> users = userService.getUsers(user);
        map.put("users",users);
        map.put("username",user.getUsername());
        return "user/list";
    }

    @GetMapping("/getUser/{id}")
    public String list(Map map,@PathVariable("id") String id,@RequestParam(defaultValue = "view") String type){
        UserInfor user = userService.getUser(id);
        map.put("user",user);
        if("update".equals(type)){
            return "user/update";
        }
        return "user/view";
    }

    @PostMapping("/save")
    public String save(User user){
        userService.saveUser(user);
        return "redirect:/user/list";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        userService.deleteUser(id);
        return "redirect:/user/list";
    }

    @PostMapping("/checkPassword")
    @ResponseBody
    public boolean checkPassword(String password, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user!=null&&password.equals(user.getPassword())){
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("/changePassword")
    public String changePassword(String password,HttpSession session){
        User user = (User) session.getAttribute("user");
        user.setPassword(password);
        userService.saveUser(user);
        return "redirect:/user/loginOut";
    }


}
