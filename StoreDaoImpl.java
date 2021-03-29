package com.ldq.dao.impl;

import com.ldq.dao.StoreDao;
import com.ldq.pojo.Store;

import java.util.List;

public class StoreDaoImpl extends BaseDao implements StoreDao {
    @Override
    public int addStore(Store store) {
        String sql ="insert into store(`name`,`type`,`money`,`address`,`img_path`) values(?,?,?,?,?)";

        return update(sql,store.getName(),store.getType(),store.getMoney(),store.getAddress(),store.getImgPath());
    }

    @Override
    public int deleteStoreById(Integer id) {
        String sql = "delete from store where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateStore(Store store) {
        String sql ="update store set `name`=?,`type`=?,`money`=?,`address`=?,`img_path`=? where id=?";
        return update(sql,store.getName(),store.getType(),store.getMoney(),store.getAddress(),store.getImgPath(),store.getId());
    }

    @Override
    public Store queryStoreById(Integer id) {
        String sql ="select `id`, `name`,`type`,`money`,`address`,`img_path` imgPath from store where id = ?";
        return queryForOne(Store.class,sql,id);
    }

    @Override
    public List<Store> queryStore() {
        String sql = "select `id`, `name`,`type`,`money`,`address`,`img_path` imgPath from store";
        return queryForList(Store.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql ="select count(*) from store";
        Number count =(Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Store> queryForPageItems(int begin, int pageSize) {
        String sql = "select `id`, `name`,`type`,`money`,`address`,`img_path` imgPath from store limit ?,?";
        return queryForList(Store.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalForPCCount() {
        String sql ="select count(*) from store where type ='手机/电脑'";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Store> queryForPagePCItems(int begin, int pageSize) {
        String sql = "select `id`, `name`,`type`,`money`,`address`,`img_path` imgPath from store where type ='手机/电脑' limit ?,? ";
        return queryForList(Store.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalForDQCount() {
        String sql ="select count(*) from store where type ='电器'";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Store> queryForPageDQItems(int begin, int pageSize) {
        String sql = "select `id`, `name`,`type`,`money`,`address`,`img_path` imgPath from store where type ='电器' limit ?,? ";
        return queryForList(Store.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalForJJCount() {
        String sql ="select count(*) from store where type ='家具'";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Store> queryForPageJJItems(int begin, int pageSize) {
        String sql = "select `id`, `name`,`type`,`money`,`address`,`img_path` imgPath from store where type ='家具' limit ?,? ";
        return queryForList(Store.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalForSMCount() {
        String sql ="select count(*) from store where type ='数码'";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Store> queryForPageSMItems(int begin, int pageSize) {
        String sql = "select `id`, `name`,`type`,`money`,`address`,`img_path` imgPath from store where type ='数码' limit ?,? ";
        return queryForList(Store.class,sql,begin,pageSize);
    }
}
