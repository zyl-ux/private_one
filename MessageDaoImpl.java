package com.ldq.dao.impl;

import com.ldq.dao.MessageDao;
import com.ldq.pojo.Message;

public class MessageDaoImpl extends BaseDao implements MessageDao {
    @Override
    public int saveMessageItems(Message message) {
        String sql = "insert into message(`id`,`storeId`,`userId`,`orderId`,`name`,`phone`,`address`,`type`,`describe`,`time`) values(?,?,?,?,?,?,?,?,?,?)";
        return update(sql,message.getId(),message.getStoreId(),message.getUserId(),message.getOrderId(),message.getName(),message.getPhone(),message.getAddress(),message.getType(),message.getDescribe(),message.getTime());
    }

    @Override
    public int deleteById(String orderId) {
        String sql = "delete from message where orderId = ?";
        return update(sql,orderId);
    }

    @Override
    public Message queryForOrderNum(String orderNum) {
        String sql = "select * from message where orderId = ?";
        return queryForOne(Message.class,sql,orderNum);
    }
}
