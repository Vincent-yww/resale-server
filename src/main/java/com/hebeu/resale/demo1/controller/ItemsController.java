package com.hebeu.resale.demo1.controller;

import com.hebeu.resale.demo1.domain.Items;
import com.hebeu.resale.demo1.json.Json;
import com.hebeu.resale.demo1.service.ItemsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("item")
public class ItemsController {
    @Resource
    private ItemsService itemsService;

    @GetMapping("getall")
    public Map<String,Object> getAll(){
        List<Items> itemsList = null;
        try {
            itemsList=itemsService.queryByAllOrderByName(new Items());
            if (itemsList!=null){
                return Json.success(itemsList,"query itemlist success");
            }else {
                return Json.fail("query failed");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return Json.fail("query failed");
        }
    }
}
