package com.jiang.minimybatis.binding;

import java.lang.reflect.Proxy;

import com.jiang.minimybatis.session.SqlSession;

/**
 * 封装代理操作, 提供 SqlSession 服务, 屏蔽创建细节, 延迟创建过程
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-23
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @SuppressWarnings("unchecked")
    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }

}
