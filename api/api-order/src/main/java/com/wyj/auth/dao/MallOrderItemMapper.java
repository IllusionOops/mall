package com.wyj.auth.dao;

import com.wyj.auth.entity.MallOrderItem;
import java.util.List;

public interface MallOrderItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_order_item
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_order_item
     *
     * @mbggenerated
     */
    int insert(MallOrderItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_order_item
     *
     * @mbggenerated
     */
    MallOrderItem selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_order_item
     *
     * @mbggenerated
     */
    List<MallOrderItem> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mall_order_item
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MallOrderItem record);
}