package com.jiang.minimybatis.dao;

import com.jiang.minimybatis.po.User;

/**
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-23
 */
public interface IUserDao {

    User queryUserInfoById(Long uId);

}