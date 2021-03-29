package com.ldq.dao.impl;

import com.ldq.dao.UserDao;
import com.ldq.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public User queryUserByUsername(String username) {
         String sql = "select `id`,`username`,`password`,`email`,`sign`,`storeId` from user where `username` = ?";
         return  queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email`,`sign` ,`storeId` from user where `username` = ? and `password` = ?";
        return  queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user(`username`,`password`,`email`,`sign`,`storeId`) values(?,?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail(),0,0);
    }

    @Override
    public int ChangePassword(String password,Integer id) {
        String sql = "update user set password = ? where id = ?";
        return update(sql,password,id);
    }

    @Override
    public User queryByUserId(Integer userId) {
        String sql="select * from user where id = ?";
        return queryForOne(User.class,sql,userId);

    }

}
