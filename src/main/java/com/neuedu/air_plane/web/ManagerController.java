package com.neuedu.air_plane.web;


import com.github.pagehelper.PageInfo;
import com.neuedu.air_plane.model.Manager;
import com.neuedu.air_plane.model.PageCondition;
import com.neuedu.air_plane.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 处理管理员的请求
 */
@RestController
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/api/login")
    public String login(@RequestBody Manager manager, HttpServletResponse response, HttpSession session){
        //通过用户名和密码作为条件查询数据库返回结果如果不为空，就代表登录成功
        Manager principal = managerService.find(manager);
        //判断principal对象是否为空
        if(principal!=null){
            session.setAttribute("user",principal);
            return "success";
        }
        //设置状态码为403；
        response.setStatus(403);
        return "failed";
    }

    /**
     * 插入或者更新数据
     * @return
     */
    @PostMapping("/api/manager")
    public String save(@RequestBody Manager manager){

        if(manager.getManAutoId()==null){
            //插入
            managerService.insert(manager);
        }else{
            //更新
            managerService.update(manager);
        }
        return "success";
    }

    /**
     * 返回根据分页查询到的结果集，其中需要包含一些分页的信息
     */
    @PostMapping("/api/manager/find")
    public PageInfo<Manager> page(@RequestBody PageCondition<Manager> condition){
        return managerService.page(condition);
    }

    @DeleteMapping("/api/manager/{id}")
    public String delete(@PathVariable Integer id){
        managerService.deleteById(id);
        return "success";
    }
}
