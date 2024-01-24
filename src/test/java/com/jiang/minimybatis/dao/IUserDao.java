package com.jiang.minimybatis.dao;

/**
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-23
 */
public interface IUserDao {

    String queryUserName(String uId);

    Integer queryUserAge(String uId);

}