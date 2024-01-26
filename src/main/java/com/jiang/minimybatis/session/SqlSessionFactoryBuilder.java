package com.jiang.minimybatis.session;

import java.io.Reader;

import com.jiang.minimybatis.builder.xml.XMLConfigBuilder;
import com.jiang.minimybatis.session.defaults.DefaultSqlSessionFactory;

/**
 * 整个 Mybatis 的入口类, 通过指定解析 XML 的 IO, 引导整个流程的启动
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-25
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}

