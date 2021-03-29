package com.ldq.dao.impl;

import com.ldq.dao.OrderDao;
import com.ldq.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
       String sql = "insert into `order`(`storeId`,`userId`,`createTime`,`price`,`status`,`orderNum`) values(?,?,?,?,?,?)";
       return update(sql,order.getStoreId(),order.getUserId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getOrderNum());
    }

    @Override
    public List<Order> queryForOrder(Integer userId) {
        String sql = "select * from `order` where userId = ?";
        return queryForList(Order.class,sql,userId);
    }

    @Override
    public int deleteById(String orderNum) {
        String sql = "delete from `order` where orderNum = ?";
        return update(sql,orderNum);
    }

    @Override
    public Order queryForByOrderNum(String orderNum) {
        String sql = "select * from `order` where orderNum = ?";
        return queryForOne(Order.class,sql,orderNum);
    }

    @Override
    public int changeStatus(String orderNum,Integer status) {
        String sql = "update `order` set status = ? where orderNum = ?";
        return update(sql,status,orderNum);
    }

    @Override
    public List<Order> queryByStoreId(Integer storeId) {
        String sql = "select * from `order` where storeId = ?";
        return queryForList(Order.class,sql,storeId);
    }

    @Override
    public int changePrice(String orderNum,Double price) {
        String sql = "update `order` set price = ? where orderNum = ?";
        return update(sql,price,orderNum);
    }
}
