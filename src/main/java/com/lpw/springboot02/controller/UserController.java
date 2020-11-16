package com.lpw.springboot02.controller;

import com.lpw.springboot02.entity.User;
import com.lpw.springboot02.service.UserService;
import com.lpw.springboot02.util.LogUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-09-22 15:52:19
 */
@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Resource
    UploadController uploadController;

    /**
     * 页面跳转
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String forWord(@PathVariable String page){
        return page;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne1")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    @RequestMapping("/selectUser")
    public String queryAll(User user,Model model){
        List<User> userList = userService.queryAll(user);
        model.addAttribute("userList",userList);
        return "userList";
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public String addUser(User user){
        user.setCreatetime(new Date());
        LogUtil.info(user.toString());
        userService.insert(user);
        return "redirect:/user/showAll";
    }

    /**
     * 查看所有用户
     * @param model
     * @return
     */
    @RequestMapping("/showAll")
    public String showAll(Model model){
        List<User> users = userService.queryAllByLimit(0, 10);
        model.addAttribute("userList",users);
        return "userList";
    }

    /**
     * 编辑单个用户
     */
    @RequestMapping("/editInfo/{id}/{name}")
    public String editInfo(@PathVariable Integer id,@PathVariable String name, Model model){
        User user = selectOne(id);
        LogUtil.info(user.toString());
        model.addAttribute("user",user);
        return "userInfo";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user, MultipartFile attach, Model model){
        String finalName = uploadController.upload(attach, model);
        user.setFilePath(finalName);
        LogUtil.info(user.toString());
        userService.update(user);
        return "redirect:/user/showAll";
    }

    @RequestMapping("/delUser/{id}/{name}")
    public String delUser(@PathVariable Integer id,@PathVariable String name){
        userService.deleteById(id);
        return "redirect:/user/showAll";
    }
}