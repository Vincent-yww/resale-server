package com.hebeu.resale.demo1.controller;

import com.hebeu.resale.demo1.domain.Category;
import com.hebeu.resale.demo1.json.Json;
import com.hebeu.resale.demo1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("category")
public class CategoryController {


    @Autowired
    @Qualifier("categoryService")
    private CategoryService categoryService;

    @GetMapping("/")
    public Map<String, Object> getAllCategories() {
        List<Category> categoryList;
        try {
            categoryList = categoryService.queryAll();
            if (categoryList != null) {
                return Json.success(categoryList, "query category succeed");
            } else {
                return Json.fail("query category failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("query category failed");
        }
    }

    @PutMapping("update")
    public Map<String, Object> updateCategory(@RequestBody Category row) {
        try {
            if (categoryService.updateByPrimaryKey(row) > 0) {
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
    public Map<String, Object> addCategory(@PathParam("cname") String cname) {
        Category category = new Category();
        category.setCName(cname);
        try {
            if (categoryService.insertSelective(category) > 0) {
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
