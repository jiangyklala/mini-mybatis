package com.jiang.minimybatis;

import java.io.IOException;
import java.io.Reader;

import org.junit.Test;

import com.jiang.minimybatis.dao.IUserDao;
import com.jiang.minimybatis.io.Resources;
import com.jiang.minimybatis.session.SqlSession;
import com.jiang.minimybatis.session.SqlSessionFactory;
import com.jiang.minimybatis.session.SqlSessionFactoryBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-23
 */
@Slf4j
public class ApiTest {

    @Test
    public void test_MapperProxyFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        String res = userDao.queryUserInfoById("10001");
        log.debug("测试结果：{}", res);
    }

}
