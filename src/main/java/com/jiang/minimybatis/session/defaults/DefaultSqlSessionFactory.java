package com.jiang.minimybatis.session.defaults;

import com.jiang.minimybatis.binding.MapperRegistry;
import com.jiang.minimybatis.session.SqlSession;
import com.jiang.minimybatis.session.SqlSessionFactory;

/**
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-24
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }

}
