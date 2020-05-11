package com.cyf.billmanger.controller;

import com.cyf.billmanger.Service.UserService;
import com.cyf.billmanger.dto.UserInfor;
import com.cyf.billmanger.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

}
