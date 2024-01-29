package com.jiang.minimybatis.type;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Mybatis 中的基本类型, 数组类型以及自定义实现的事务和事务工厂都需要注册到 TypeAliasRegistry (别名注册器) 中进行管理, 需要使用的时候直接从
 * 中获取到具体的对象类型, 之后再实例化进行使用
 *
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-26
 */
public class TypeAliasRegistry {

    private final Map<String, Class<?>> TYPE_ALIASES = new HashMap<>();

    public TypeAliasRegistry() {
        // 构造函数里注册系统内置的类型别名
        registerAlias("string", String.class);

        // 基本包装类型
        registerAlias("byte", Byte.class);
        registerAlias("long", Long.class);
        registerAlias("short", Short.class);
        registerAlias("int", Integer.class);
        registerAlias("integer", Integer.class);
        registerAlias("double", Double.class);
        registerAlias("float", Float.class);
        registerAlias("boolean", Boolean.class);
    }

    public void registerAlias(String alias, Class<?> value) {
        String key = alias.toLowerCase(Locale.ENGLISH);
        TYPE_ALIASES.put(key, value);
    }

    public <T> Class<T> resolveAlias(String string) {
        String key = string.toLowerCase(Locale.ENGLISH);
        return (Class<T>) TYPE_ALIASES.get(key);
    }

}
