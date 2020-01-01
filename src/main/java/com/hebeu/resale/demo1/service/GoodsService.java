package com.hebeu.resale.demo1.service;

import com.hebeu.resale.demo1.domain.Goods;
import com.hebeu.resale.demo1.vo.QueryGoodsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {


    int deleteByPrimaryKey(Integer gId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);


    List<Goods> queryByAll(Goods goods);

    List<Goods> queryAllByCategory(Integer category);


    List<Goods> queryAllByCategoryAndSchoolAndNameLike(Integer category, Integer school, String likeName);

    QueryGoodsVo queryV0(@Param("id") Integer id);
}










