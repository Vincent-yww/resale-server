package com.hebeu.resale.demo1.mapper;

import com.hebeu.resale.demo1.domain.Goods;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.hebeu.resale.demo1.vo.QueryGoodsVo;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> queryByAll(Goods goods);

    List<Goods> queryAllByCategory(@Param("category") Integer category);

    List<Goods> queryAllByCategoryAndSchoolAndNameLike(@Param("category") Integer category, @Param("school") Integer school, @Param("likeName") String likeName);

    QueryGoodsVo queryV0(@Param("id")Integer id);
}