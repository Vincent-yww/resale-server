package com.hebeu.resale.demo1.controller;

import com.hebeu.resale.demo1.domain.Goods;
import com.hebeu.resale.demo1.domain.School;
import com.hebeu.resale.demo1.json.Json;
import com.hebeu.resale.demo1.service.GoodsService;
import com.hebeu.resale.demo1.vo.GoodsVo;
import com.hebeu.resale.demo1.vo.QueryGoodsVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;


    @GetMapping("all")
    public Map<String, Object> queryAll() {
        List<Goods> goodsList = null;
        try {
            goodsList = goodsService.queryByAll(new Goods());
            if (goodsList != null) {
                return Json.success(goodsList, "query goodsList success");
            } else {
                return Json.fail("query failed");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("query failed");
        }
    }

    @GetMapping("/category/{category}")
    public Map<String, Object> queryByCategory(@PathVariable("category") Integer category,Integer school) {
        List<Goods> goodsList = null;
        System.out.println(school);
        try {
            Goods goods=new Goods();
            goods.setSchool(school);
            goods.setCategory(category);
            goodsList = goodsService.queryByAll(goods);
            if (goodsList != null) {
                return Json.success(goodsList, "query goodsList success");
            } else {
                return Json.fail("query failed");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("query failed");
        }
    }

    @PostMapping("/add")
    public Map<String, Object> addGoods(@RequestBody GoodsVo good) {
        Goods insertgoods = new Goods();
        try {
            insertgoods.setCreatetime(new Date());
            insertgoods.setCategory(good.getCategory());
            insertgoods.setDesc(good.getDesc());
            insertgoods.setDetail(good.getDetail());
            insertgoods.setDetailimgs(good.getDetailimgs());
            insertgoods.setName(good.getName());
            insertgoods.setPic(good.getPic());
            insertgoods.setPrice(BigDecimal.valueOf(good.getPrice()));
            insertgoods.setFromuser(good.getFromuser());
            insertgoods.setSchool(good.getSchool());
            insertgoods.setCondition(good.getCondition());
            goodsService.insertSelective(insertgoods);
            return Json.success(insertgoods,"insert goods success"+insertgoods.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("insert failed");
        }
    }


    @GetMapping("getone")
    public Map<String, Object> getOne(@PathParam("goodsId") Integer goodsId){
        QueryGoodsVo vo=null;
        try {
            vo=goodsService.queryV0(goodsId);
            if(vo!=null){
                return Json.success(vo,"query goods success");
            }
            else{
                return Json.fail("query goods failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("query goods exception");
        }
    }

    @GetMapping("search")
    public Map<String, Object> getGoodsByCondition(@PathParam("searchItem") String searchItem,@PathParam("category") Integer category,@PathParam("school") Integer school){
        List<Goods> goodsList = null;
        try {

            goodsList = goodsService.queryAllByCategoryAndSchoolAndNameLike(category,school,searchItem);
            if (goodsList != null) {
                return Json.success(goodsList, "query goodsList success");
            } else {
                return Json.fail("query failed");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Json.fail("query failed");
        }
    }
    @PutMapping("update")
    public Map<String, Object> updateCategory(@RequestBody Goods row) {
        try {
            if (goodsService.updateByPrimaryKey(row) > 0) {
                return Json.success(null, "修改成功");
            } else {
                return Json.fail("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Json.fail("修改失败");
        }
    }
}
