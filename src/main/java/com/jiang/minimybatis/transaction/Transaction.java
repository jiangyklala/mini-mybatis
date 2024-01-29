package com.jiang.minimybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 定义标准的事务接口: 连接, 提交, 回滚, 关闭; 具体的可由不同的事务方式进行实现, 包括: JDBC 和托管事务 (Spring 来管理)
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-26
 */
public interface Transaction {

    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;

}