package com.jiang.minimybatis.transaction;

import java.sql.Connection;

import javax.sql.DataSource;

import com.jiang.minimybatis.session.TransactionIsolationLevel;

/**
 * 使用工厂模式包装 JDBC 事务实现, 为每一个事务都实现一个对应到工厂
 *
 * @author jiangyunkai <jiangyunkai@kuaishou.com>
 * Created on 2024-01-26
 */
public interface TransactionFactory {

    /**
     * 根据 Connection 创建 Transaction
     *
     * @param conn Existing database connection
     * @return Transaction
     */
    Transaction newTransaction(Connection conn);

    /**
     * 根据数据源和事务隔离级别创建 Transaction
     *
     * @param dataSource DataSource to take the connection from
     * @param level Desired isolation level
     * @param autoCommit Desired autocommit
     * @return Transaction
     */
    Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit);

}