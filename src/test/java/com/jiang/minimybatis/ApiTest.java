package com.jiang.minimybatis;

import java.io.IOException;

import org.junit.Test;

import com.jiang.minimybatis.dao.IUserDao;
import com.jiang.minimybatis.io.Resources;
import com.jiang.minimybatis.po.User;
import com.jiang.minimybatis.session.SqlSession;
import com.jiang.minimybatis.session.SqlSessionFactory;
import com.jiang.minimybatis.session.SqlSessionFactoryBuilder;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-23
 */
@Slf4j
public class ApiTest {

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        User user = userDao.queryUserInfoById(1L);
        log.debug("测试结果：{}", JSONUtil.toJsonStr(user));
    }

}
