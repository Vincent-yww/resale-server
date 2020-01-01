package com.hebeu.resale.demo1.controller;

import com.hebeu.resale.demo1.domain.Users;
import com.hebeu.resale.demo1.json.Json;
import com.hebeu.resale.demo1.service.UsersService;
import com.hebeu.resale.demo1.utils.token.TokenUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Resource
    private UsersService usersService;

    @GetMapping("login")
    public Map<String,Object> adminLogin(@PathParam("username") String username,@PathParam("password") String password){
        Users users=null;
        try {
            users=usersService.queryOneByUsernameAndPasswordAndCharacter(username,password,"admin");
            if (users!=null){
                return Json.success(users,"admin login success", TokenUtils.getToken(users.getUsername()));
            }else {
                return Json.fail("amdin login failed");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return Json.fail("amdin login failed");
        }
    }
    //根据用户的权限查询用户
    @GetMapping("role")
    public Map<String,Object> getUsersByRole(@PathParam("role") String role){
        List<Users> usersList=null;
        Users queryUsers=new Users();
        try {
            queryUsers.setCharacter(role);
            usersList=usersService.queryByAll(queryUsers);
            if (usersList!=null){
                return Json.success(usersList,"query users success");
            }else {
                return Json.fail("userslist is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("query users failed");
        }
    }
    //修改用户信息
    @PutMapping("update")
    public Map<String,Object> updateUser(@RequestBody Users row){
        System.out.println(row);
        try {
            if(usersService.updateByPrimaryKey(row)>0){
                return Json.success(null,"修改成功");
            }else{
                return Json.fail("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("修改失败");
        }
    }
    //修改用户信息
    @GetMapping("auth")
    public Map<String,Object> authUser(@PathParam("uid") Integer uid,@PathParam("character") String character){
        try {

            if(usersService.updateCharacterByUid(character,uid)>0){
                return Json.success(null,"修改成功");
            }else{
                return Json.fail("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("修改失败");
        }
    }


}
