package com.jiang.minimybatis.session;

import java.util.HashMap;
import java.util.Map;

import com.jiang.minimybatis.binding.MapperRegistry;
import com.jiang.minimybatis.datasource.DruidDataSourceFactory;
import com.jiang.minimybatis.mapping.Environment;
import com.jiang.minimybatis.mapping.MappedStatement;
import com.jiang.minimybatis.transaction.jdbc.JdbcTransactionFactory;
import com.jiang.minimybatis.type.TypeAliasRegistry;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 整个 Mybatis 的操作都是使用 Configuration 配置选项类进行串联流程, 所有的内容都会在 Configuration 中进行链接
 *
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-25
 */
@Slf4j
public class Configuration {

    // 环境
    protected Environment environment;

    // 类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry
            = new TypeAliasRegistry();

    /**
     * 映射注册机, 用于注册 Mapper 映射器所提供的操作类
     * </br>
     * tips: Configuation 被实例化时, 此 mapperRegistry 同时也被实例化了
     */
    protected MapperRegistry mapperRegistry
            = new MapperRegistry(this);

    /**
     * 映射的语句，存在Map里
     */
    protected final Map<String, MappedStatement> mappedStatements
            = new HashMap<>();

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
    }


    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        log.debug("mappedStatements is : {}", JSONUtil.toJsonStr(mappedStatements));
        return mappedStatements.get(id);
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}