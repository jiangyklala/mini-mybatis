package com.jiang.minimybatis.session;

import java.util.HashMap;
import java.util.Map;

import com.jiang.minimybatis.binding.MapperRegistry;
import com.jiang.minimybatis.mapping.MappedStatement;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-25
 */
@Slf4j
public class Configuration {

    /**
     * 映射注册机, 用于注册 Mapper 映射器所提供的操作类
     * </br>
     * tips: Configuation 被实例化时, 此 mapperRegistry 同时也被实例化了
     */
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    /**
     * 映射的语句，存在Map里
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

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

}