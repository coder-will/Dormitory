package com.zj.controller;

import com.zj.pojo.Admin;
import com.zj.pojo.PageInfo;
import com.zj.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {


    @Autowired
    private AdminService adminService;

    /*
    *
    * 前端提交username和password
    * 此处进行接受并且在数据库中进行检测
    *
    * */
    @PostMapping("/login")
    public String login(Admin admin, Model model, HttpSession session, ServletRequest request){
        Admin ad = adminService.findAdmin(admin);
        if(ad!=null){
            session.setAttribute("ad",ad);
            return "homepage";
        }
        model.addAttribute("msg","用户名或密码错误，请重新登陆");
        return "login";
    }

    /*
    *
    * 实现登出操作
    *
    * */
    @RequestMapping("/loginOut")
    public String loginOut(){
        return "login";
    }

    /*
    * 进入管理员页面操作
    * */
    @RequestMapping("/findAdmin")
    public String findAdmin(String a_username, String a_describe,Integer pageIndex,
                            Integer a_id ,Integer pageSize, Model model) {

        PageInfo<Admin> ai = adminService.findPageInfo(a_username,a_describe,
                a_id,pageIndex,pageSize);
        model.addAttribute("ai",ai);
        return "admin_list";
    }

    /**
     * 导出Excel
     */
    @PostMapping("/exportadminlist")
    @ResponseBody
    public List<Admin> exportAdmin(){
        List<Admin> admin = adminService.getAllAdmin();
        return admin;
    }

    /**
     * 添加管理员信息
     */
    @PostMapping("/addAdmin")
    @ResponseBody
    public String addAdmin( @RequestBody Admin admin) {
        int a = adminService.addAdmin(admin);
        return "admin_list";
    }

    /*
    * 删除管理员信息
    *
    * */
    @RequestMapping( "/deleteAdmin")
    @ResponseBody
    public String deleteAdmin(Integer a_id) {
        int a = adminService.deleteAdmin(a_id);
        return "admin_list";
    }


    /**
     * 修改管理员信息
     */
    /**
     * 将提交数据(a_id,a_username...)写入Admin对象
     */
    @PostMapping("/updateAdmin")
    public String updateAdmin(Admin admin) {
        int a = adminService.updateAdmin(admin);
        return "redirect:/findAdmin";
    }

    /**
     * 根据管理员Id搜索;将请求数据a_id写入参数a_id
     */
    @RequestMapping( "/findAdminById")
    public String findAdminById( Integer a_id,HttpSession session) {
        Admin a= adminService.findAdminById(a_id);
        session.setAttribute("a",a);
        return "admin_edit";
    }

}
