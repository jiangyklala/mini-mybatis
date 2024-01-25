package com.jiang.minimybatis;

import org.junit.Test;

import com.jiang.minimybatis.binding.MapperRegistry;
import com.jiang.minimybatis.dao.IUserDao;
import com.jiang.minimybatis.session.SqlSession;
import com.jiang.minimybatis.session.SqlSessionFactory;
import com.jiang.minimybatis.session.defaults.DefaultSqlSessionFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-23
 */
@Slf4j
public class ApiTest {

    @Test
    public void test_MapperProxyFactory() {
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("com.jiang.minimybatis.dao");

        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("10001");
        log.debug("测试结果：{}", res);
    }

}
