package com.hebeu.resale.demo1;

import com.hebeu.resale.demo1.domain.Goods;
import com.hebeu.resale.demo1.service.GoodsService;
import com.hebeu.resale.demo1.vo.QueryGoodsVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemTest {
    @Resource
    private GoodsService goodsService;

    @Test
    public void t1() {

        List<Goods> goodsList = goodsService.queryAllByCategoryAndSchoolAndNameLike(1, 1, "iPhone");
        System.out.println(goodsList);
    }

    @Test
    public void t2(){
        QueryGoodsVo vo=goodsService.queryV0(1);
        System.out.println(vo);
    }
}
