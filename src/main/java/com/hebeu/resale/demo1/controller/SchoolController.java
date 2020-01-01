package com.hebeu.resale.demo1.controller;

import com.hebeu.resale.demo1.domain.Category;
import com.hebeu.resale.demo1.domain.School;
import com.hebeu.resale.demo1.json.Json;
import com.hebeu.resale.demo1.service.SchoolService;
import org.springframework.beans.factory.config.Scope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("school")
public class SchoolController {
    @Resource
    private SchoolService schoolService;
    @GetMapping("/")
    public Map<String,Object> getSchool(){
        try {
           List<School> schoolList= schoolService.queryByAll(new School());
           if (schoolList!=null){
               return Json.success(schoolList,"query schoolList success");
           }else {
               return Json.fail("query schoolList failed");
           }
        }catch (Exception ex){
            ex.printStackTrace();
            return Json.fail("query schoolList failed");

        }
    }

    @PutMapping("update")
    public Map<String, Object> updateCategory(@RequestBody School row) {
        try {
            if (schoolService.updateByPrimaryKey(row) > 0) {
                return Json.success(null, "修改成功");
            } else {
                return Json.fail("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("修改失败");
        }
    }

    @GetMapping("add")
    public Map<String, Object> addCategory(@PathParam("name") String name) {
       School school=new School();
        school.setName(name);
        try {
            if (schoolService.insertSelective(school) > 0) {
                return Json.success(null, "添加记录成功");
            } else {
                return Json.fail("添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("添加失败");
        }
    }
}
