package com.jiang.minimybatis.session.defaults;

import com.jiang.minimybatis.session.Configuration;
import com.jiang.minimybatis.session.SqlSession;
import com.jiang.minimybatis.session.SqlSessionFactory;

/**
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-24
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }

}
