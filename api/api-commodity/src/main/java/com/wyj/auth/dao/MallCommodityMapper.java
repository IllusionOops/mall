package com.wyj.auth.dao;

import com.wyj.auth.entity.po.MallCommodity;

import java.util.List;

public interface MallCommodityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_commodity
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_commodity
     *
     * @mbggenerated
     */
    int insert(MallCommodity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_commodity
     *
     * @mbggenerated
     */
    MallCommodity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_commodity
     *
     * @mbggenerated
     */
    List<MallCommodity> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_commodity
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MallCommodity record);
}