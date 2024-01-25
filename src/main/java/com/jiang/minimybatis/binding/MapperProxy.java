package com.jiang.minimybatis.binding;

import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.jiang.minimybatis.session.SqlSession;

/**
 * 对外提供数据库操作对象
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-23
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    @Serial
    private static final long serialVersionUID = -6424540398559729838L;

    private SqlSession sqlSession;
    private final Class<T> mapperInterface;


    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            return sqlSession.selectOne(method.getName(), args);
        }
    }

}
