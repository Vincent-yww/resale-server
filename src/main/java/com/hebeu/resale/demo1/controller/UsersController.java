package com.hebeu.resale.demo1.controller;

import com.hebeu.resale.demo1.domain.Goods;
import com.hebeu.resale.demo1.domain.Users;
import com.hebeu.resale.demo1.json.Json;
import com.hebeu.resale.demo1.service.UsersService;
import com.hebeu.resale.demo1.vo.LoginVo;
import com.hebeu.resale.demo1.vo.RegVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UsersController extends BaseController {

    @Resource
    private UsersService usersService;

    @ApiOperation(value = "用户登录接口1", notes = "URL传入用户JSON对象执行用户登录")
    @ApiImplicitParam(name = "token", value = "token值", required = true)
    @GetMapping("login")
    public Map<String, Object> login(HttpSession session,String token, String username, String password, String verification) {
        Users loginuser = null;
        System.out.println("in controller-->token=" + token);
        try {
            if (redisTemplate.hasKey(token) == false) {
                return Json.fail("验证码错误");
            }
            Integer redis_ValidateCode = (Integer) redisTemplate.opsForValue().get(token);

            if (!redis_ValidateCode.toString().equals(verification)) {
                return Json.fail("验证码不正确");
            }
            loginuser = usersService.queryOneByUsernameAndPassword(username, password);
            if (loginuser != null) {
                session.setAttribute("login_user",loginuser);
                return Json.success(loginuser, "login success");
            } else {
                return Json.fail("密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("login failed");
        }
    }

    @ApiOperation(value = "用户登录接口", notes = "URL传入用户名和密码执行用户登录")
    @PostMapping("login")
    public Map<String, Object> login2(@RequestBody LoginVo vo, HttpSession session) {
        Users loginuser = null;
        System.out.println("in controller-->token=" + vo.getToken());
        try {
            if (!redisTemplate.hasKey(vo.getToken())) {
                return Json.fail("验证码错误");
            }
            String redis_ValidateCode = redisTemplate.opsForValue().get(vo.getToken()).toString();

            if (!redis_ValidateCode.toString().equals(vo.getVerification())) {
                return Json.fail("验证码不正确");
            }
            loginuser = usersService.queryOneByUsernameAndPassword(vo.getUsername(), vo.getPassword());
            if (loginuser != null) {
                session.setAttribute("login_user",loginuser);
                return Json.success(loginuser, "login success");
            } else {
                return Json.fail("密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("login failed");
        }
    }

    @PostMapping("reg")
    public Map<String, Object> reg(@RequestBody RegVo vo) {
        try {
            if (!checkValidateCode(vo.getToken(), vo.getVerification())) {
                return Json.fail("验证码不正确");
            }
            Users users1= usersService.queryOneByPhoneOrEmail(vo.getPhone(),vo.getPassword());
            if (users1!=null){
                 return Json.fail("此账号已经注册过了");
            }
            Users users = new Users();
            users.setSchool(vo.getSchool());
            users.setPassword(vo.getPassword());
            users.setPhone(vo.getPhone());
            users.setUsername(vo.getUsername());
            usersService.insert(users);
            return Json.success(users, "reg success");
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("reg failed");
        }
    }

    @GetMapping("getone")
    public Map<String,Object> getone(@PathParam("uid") Integer uid){
        Users users=null;
        try {
            users=usersService.selectByPrimaryKey(uid);
            if(users!=null){
                return Json.success(users,"query users success");
            }
            else{
                return Json.fail("query users failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("query users exception");
        }
    }
}
