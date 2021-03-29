package com.ldq.dao.impl;

import com.ldq.pojo.Evaluate;

import java.util.List;

public class EvaluateDaoImpl extends BaseDao implements com.ldq.dao.EvaluateDao {

    @Override
    public int saveEvaluate(Evaluate evaluate) {
        String sql = "insert into evaluate(`userId`,`storeId`,`orderNumId`,`grade`,`content`) values(?,?,?,?,?)";
        return update(sql,evaluate.getUserId(),evaluate.getStoreId(),evaluate.getOrderNumId(),evaluate.getGrade(),evaluate.getContent());
    }

    @Override
    public int deleteByOrderNum(String orderNum) {
        String sql = "delete from evaluate where orderNumId = ?";
        return update(sql,orderNum);
    }

    @Override
    public List<Evaluate> queryByUserId(Integer userId) {
        String sql = "select * from evaluate where userId = ?";
        return queryForList(Evaluate.class,sql,userId);
    }

    @Override
    public List<Evaluate> queryByStoreId(Integer storeId) {
        String sql = "select * from evaluate where storeId = ?";
        return queryForList(Evaluate.class,sql,storeId);
    }
}
